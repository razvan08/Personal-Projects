import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

//Fiecare elf reprezinta un fir de executie,fapt ce asigura ca fiecare elf
//din cadrul fabricilor va lucra in mod independent de ceilalti elfi din fabrica respectiva
public class Elf extends Thread {
    //membru privat de tip int in care se retine id-ul elfului
    private int idElf;
    //membru privat de tip Point in care se retine pozitia elfului in fabrica
    private Point pozitie;
    //membru privat de tip Fabrica in care se retine fabrica in care lucreaza elful
    private Fabrica fabrica;
    //membru privat de tip Boolean prin care se poate pornii/oprii activitatea elfului
    private Boolean punctOprire;
    //membru privat de tip CyclicBarrier folosit pentru implementarea EXTRA TASK 3
    private CyclicBarrier barrier;

    //constructor in care se initializeaza membrii la anumite valori date ca parametrii
    public Elf(Fabrica fabrica, Point pozitie, int idElf,CyclicBarrier barrier){
        this.fabrica = fabrica;
        this.pozitie = pozitie;
        this.idElf = idElf;
        punctOprire = true;
        this.barrier = barrier;
    }

    public void run(){
        //cat timp valoarea membrului punctOprire e true
        while (punctOprire) {
            //se creeaza un nou obiect de tip Cadou
            Cadou cadou = new Cadou();
            //se realizeaza deplasarea elfului in fabrica cu o pozitie aleasa random
            //si de asemenea se adauga cadoul in lista de cadouri din fabrica
            fabrica.createPresent(this, cadou);
            //se raporteaza crearea cadoului
            fabrica.reportPresent(this, cadou);
            //se cere raportarea pozitiei pentru fiecare elf din fabrica
            fabrica.reportPositions();
            //Parte pentru EXTRA TASK 3
            //daca elful se afla in zona diagonalei dar nu toti elfii din fabrica se afla in acea zona
            if(pozitie.x == pozitie.y && fabrica.checkAllStopped() == false){
                //se realizeaza oprirea elfului in zona barierei
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //altfel daca elful se afla in zona diagonalei si toti ceilalti elfi din fabrica se afla in aceeasi zona
            }else if(pozitie.x == pozitie.y && fabrica.checkAllStopped() == true){
                //se parcurg toti elfii din fabrica si se reia activitatea pentru fiecare
                for(int i = 0 ; i < fabrica.getElfi().size();i++){
                    fabrica.getElfi().get(i).resumeWork();
                }
            }
        }
    }

    //metoda prin care se opreste activitatea elfului
    public void stopWork(){
        this.punctOprire = false;
    }
    //metoda prin care se reia activitatea elfului
    public void resumeWork() {
        this.punctOprire = true;
    }

    //sectiune pentru metode de tip GETTER prin care se acceseaza membrii privati
    public int getIdElf() {
        return idElf;
    }

    public Point getPozitie() {
        return pozitie;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

}