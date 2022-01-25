import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

//Mos Craciun este reprezentat de asemenea ca un fir de executie
class MosCraciun extends Thread {
    //membru de tip Socket necesar realizarii conexiunii de tip TCP/IP
    Socket socket;
    //membru de tip DataInputStream in care se retine data extrasa in urma conexiunii TCP/IP
    DataInputStream input;

    //Constructor in care se initializeze membrii
    public MosCraciun(Socket socket) {
        try {
            this.socket = socket;
            input = new DataInputStream(this.socket.getInputStream());
            this.start();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        try {
            //se incearca citirea datei transmise prin intermediul conexiunii TCP/IP
            String cadou = input.readUTF();
            //se afiseaza un mesaj adecvat in consola pentru a testa corectitudinea
            System.out.println("Mos Craciun a primit cadoul de tip : "+cadou);
            //sunt tratate exceptiile aferente conexiunii
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //se incearca inchiderea socket-ului
            try {
                this.socket.close();
            }//se trateaza exceptiile aferente
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}