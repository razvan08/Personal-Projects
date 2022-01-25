import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Atelier {
    public static void main(String[] args) {
        //variabila in care retinem numarul de fabrici din atelier
        int numarFabrici = 4;
        //variabila in care retinem numar de reni ce vor primii cadourile din fabrici
        int numarReni = 4;
        //variabila in care retinem dimensiunea fabricilor
        int dimensiuneFabrica= 4;
        //variabila cu ajutorul careia se va face raportarea pozitiilor din fabrici
        RaportarePozitii raportarePozitii;
        //variabila de tip vector de "Fabrica" in care se retin fabricile din atelier
        Fabrica[] fabrici = new Fabrica[numarFabrici];
        //variabila de tip vector de "Ren" in care se retin renii din atelier
        Ren[] reni = new Ren[numarReni];
        //variabila de tip Boolean setata la valoarea true pentru a mentine repetarea ciclurilor
        Boolean isOk = true;

        //parcurgem numarul de fabrici
        for(int i=0; i<numarFabrici; i++) {
            //se creeaza o fabrica noua cu id-ul i,toate fabricile vor avea aceeasi dimensiune
            Fabrica fabrica = new Fabrica(dimensiuneFabrica,i);
            //setam in vectorul de fabrici pe pozitia i noua fabrica creata
            fabrici[i] = fabrica;
            //se incepe raportarea poziitilor din fabrica i
            RaportarePozitii raport = new RaportarePozitii(fabrici[i]);
            raportarePozitii = raport;
            raportarePozitii.start();
        }
        //parcurgem numarl de reni
        for(int i=0; i<numarReni; i++){
            //se creeaza un ren nou cu id-ul i,toti renii vor avea ca parametru aceeasi lista de fabrici
            Ren ren = new Ren(fabrici,i,dimensiuneFabrica);
            //setam in vectorul de reni pe pozitia i noul ren creat
            reni[i] = ren;
            //se incepe executia firului apeland metoda start,astfel se declanseaza metoda run() implementata
            reni[i].start();
        }

        // se incearca conectarea la port si realizarea comunicatiei de tip TCP/IP
        try {
            int Port = 8888;
            ServerSocket socket = new ServerSocket(Port);

            while (isOk) {
                Socket clientSocket = socket.accept();
                new MosCraciun(clientSocket);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
