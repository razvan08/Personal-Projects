import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

//fiecare Ren este reprezentat ca un fir de executie intrucat aceasta implementarea
//asigura ca fiecare ren impacheteaza/primeste independent de ceilalti cadouri si de asemenea
//transmite cadourile catre Mos Craciun
public class Ren extends Thread {
    //membru privat de tip vector de Fabrica in care se retin fabricile de la care poate un ren sa
    // primeasca cadouri
    private Fabrica fabrici[];
    //membru privat de tip int in care se retine id-ul(numarul) renului
    private int numarRen;
    //membru privat de tip int in care se retine dimensiunea fabricii
    private int dimensiuneFabrica;
    //membru privat de tip ArrayList cu elemente de tip String in care retinem cadourile impachetate de fiecare ren
    private ArrayList<String> cadouri;
    //membru static de tip int pentru a alege random o fabrica
    static int randomFabrica = -1;
    //membru de tip socket
    Socket socket;
    //membru privat de tip Boolean folosit pentru a pornii/oprii primirea si transmiterea cadourilor de catre
    //renul respectiv
    private Boolean isOk;

    //constructor in care se initializeaza membrii la anumite valori date ca parametrii
    public Ren(Fabrica[] fabrici, int numarRen, int dimensiuneFabrica){
        this.numarRen = numarRen;
        socket = null;
        this.dimensiuneFabrica = dimensiuneFabrica;
        this.fabrici = new Fabrica[dimensiuneFabrica];
        this.cadouri = new ArrayList<>();
        for(int i=0; i< this.dimensiuneFabrica; i++) {
            this.fabrici[i] = fabrici[i];
        }
        isOk = true;
    }

    public void run(){
        //variabila in care retinem denumirea cadoului primit din fabrica
        String cadou;
        //variabila de tip Random folosita pentru a genera un numar random
        Random random = new Random();
        while (isOk) {
            //alegem o fabrica random
            int pos = random.nextInt(this.dimensiuneFabrica);
            if(randomFabrica == pos) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            randomFabrica = pos;
            //daca exista cadouri disponibile in fabrica selectata
            if(fabrici[pos].cadouri.size() > 0) {
                //extragem un cadou din coada de cadouri
                cadou = fabrici[pos].takePresent(this);
                //afisam un mesaj corespunzator in consola pentru a testa corectitudinea
                System.out.println("Renul " + this.numarRen + " a trimis cadoul " + cadou + " preluat din fabrica " + fabrici[pos].getIdFabrica()+" catre Mos Craciun");
               //se incearca realizarea conexiunii de tip TCP/IP
                try {
                    int serverPort = 8888;
                    socket = new Socket(InetAddress.getLocalHost(), serverPort);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    //se scrie in cadrul conexiunii cadoul pentru a putea fi preluat de Mos Craciun
                    out.writeUTF(cadou);
                    // se trateaza execeptiile aferente
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    //se incearca inchiderea socket-ului
                    if (socket != null) {
                        try {
                            socket.close();
                            //se trateaza exceptia aferenta
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
    //metoda de tip GETTER pentru a avea acces la membrul privat ce retine cadourile trimise de acest ren
    public ArrayList<String> getCadouri(){
        return this.cadouri;
    }
}