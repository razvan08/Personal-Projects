import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
public class Fabrica {
    //membru privat de tip int in care se retine dimensiunea fabricii
    private int dimensiune;
    //membru privat de tip int in care se retine id-ul fabricii
    private int idFabrica;
    //membru privat de tip ArrayList cu elemente de tip Elf in care se retin elfii din fabrica
    private ArrayList<Elf> elfi;
    //membru privat de tip int in care se retine numarul de elfi din fabrica
    private int nrElfi;
    //membru privat de tip ArrayList cu elemente de tip Point in care se retin pozitiile elfilor din fabrica
    private ArrayList<Point> fabrica;
    //membru de tip ConcurrentLinkedQueue cu elemente de tip String care reprezinta coada in care se retin cadourile
    //ce asteapta sa fie impachetate de catre reni
    ConcurrentLinkedQueue<String> cadouri;
    //membru de tip ReentrantLock folosit pentru a realiza corect dispunerea cronologica a evenimentelor
    ReentrantLock zavor;
    //membru de tip Semaphore folosit pentru a realiza corect impartirea de cadouri catre reni
    Semaphore semaphoreReni = new Semaphore(1);
    //membru privat de tip Random prin care se genereaza aleator numere. Am decis sa adaug aceasta variabila ca membru
    //intrucat am nevoie de generarea unui numar aleator in cadrul mai multor metode si astfel evit declararea repetata
    //a unei variabile pentru generarea de numere.
    private Random randomNumber = new Random();
    //membru privat de tip RetragereElf folosit pentru implementarea EXTRA TASK 1
    private RetragereElf retragereElf;
    //membru privat de tip CyclicBarrier folosit pentru implementarea EXTRA TASK 3
    private CyclicBarrier cyclicBarrier;
    //membru privat de tip Semaphore folosit pentru implementarea EXTRA TASK 2
    private Semaphore oprireElfi = new Semaphore(1);

    //constructor in care se initializeaza membrii si de asemenea se genereaza elfii pe pozitii aleatoare
    //in cadrul fabricii
    public Fabrica(int dimensiune, int idFabrica) {
        //sectiune in care se initializeaza membrii
        this.dimensiune = dimensiune;
        this.idFabrica = idFabrica;
        this.zavor = new ReentrantLock();
        int randomNrElfi = this.dimensiune/2;
        this.nrElfi = randomNrElfi;
        elfi = new ArrayList<>();
        fabrica = new ArrayList<>();
        cadouri = new ConcurrentLinkedQueue<String>();
        cyclicBarrier = new CyclicBarrier(this.nrElfi);

        //se parcurge numarul de elfi
        for (int i = 0; i < this.nrElfi; i++) {
            Boolean isOk;
            Point auxPoint;
            Boolean goodMove;

            //consideram ca elful inca nu a fost creat pe o pozitie ok
            isOk = false;
            //consideram o variabila auxiliara de tip Point pentru a putea verifica daca pozitia pe care urmeaza sa se
            //creeze un nou elf este una ok
            auxPoint= new Point();
            //cat timp nu s-a generat random o pozitie ok pentru crearea elfului
            while (isOk == false) {
                //consideram ca pozitia generata va fi una ok
                goodMove = true;
                //generam pozitia pentru coloana
                auxPoint.x = randomNumber.nextInt(this.dimensiune);
                //generam pozitia pentru linie
                auxPoint.y = randomNumber.nextInt(this.dimensiune);
                //parcurgem lista de elfi pana la pozitia elfului curent
                for (int j = 0; j < i; j++) {
                    //daca se gaseste un elf pe pozitia pe care dorim sa cream un nou elf
                    if ((auxPoint.y == elfi.get(j).getPozitie().y && auxPoint.x == elfi.get(j).getPozitie().x)) {
                        //setam variabila goodMove la valoare false intrucat pozitia generata random nu e ok
                        goodMove = false;
                        //oprim executia buclei intrucat verificarea conditiei pentru a crea un nou elf nu se va executa
                        //si doar va face ca executia algoritmului sa fie mai greoaie
                        break;
                    }
                }
                //daca pozitia generata random este una ok
                if(goodMove) {
                    //incercam crearea unui nou elf cu parametrii curenti
                    try {
                        Elf elf = new Elf(this,auxPoint,i,cyclicBarrier);
                        //se adauga elful in lista de elfi din fabrica
                        elfi.add(elf);
                        //se adauga pozitia elfului creat in fabrica
                        fabrica.add(auxPoint);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    } finally {
                        //setam variabila isOk la valoarea true pentru a trece la generarea unei pozitii pentru
                        // urmatorul elf
                        isOk = true;
                        //afisam un mesaj adecvat pentru a vedea detaliile in consola
                        System.out.println("S-a creat elful " + i + " in fabrica cu numarul " + this.idFabrica + ". Pozitia acestuia(linie,coloana) este: " + auxPoint.y +","+ auxPoint.x);
                        //intrucat fiecare elf reprezinta un fir de executie se apeleaza metoda start() pentru ca elful
                        //sa si inceapa productia de cadouri
                        elfi.get(i).start();
                    }
                    //dupa crearea unui elf se adauga un anumit delay
                    try {
                        Thread.sleep(randomNumber.nextInt(1));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    //metoda prin care se verifica daca o pozitie se afla in lista de pozitii din fabrica
    //metoda este utila in cadrul metodelor de deplasare cu o pozitie a elfilor intrucat
    //putem verifica mai usor daca pozitia pe care doreste elful sa se deplaseze este disponibila in fabrica
    //metoda returneaza false daca pozitia data ca parametru este una indisponibila in fabrica(exista un alt elf pe acea
    //pozitie) si true daca pozitia este disponibila(nu exista alt elf pe acea pozitie)
    Boolean checkMoveSamePosition(Point point){
        //se parcurg toate pozitii;e din fabrica
        for(Point currentPoint:fabrica){
            //daca se gasete o pozitie cu acelasi x si y
            if(currentPoint.x == point.x && currentPoint.y == point.y){
                return false;
            }
        }
        return true;
    }

    //metoda prin care se verifica daca un elf se poate deplasa cu o pozitie in sus
    Boolean moveUp(Elf elf) throws NullPointerException {
        //variabila in care se va retine noua pozitie a elfului in urma deplasarii
        Point auxPoint = new Point();
        //variabila in care retinem daca noua pozitie e una disponibila
        Boolean checkMove;
        //pastram aceeasi coloana
        auxPoint.x = elf.getPozitie().x;
        //scadem cu o linie intrucat deplasarea in sus presupune mutarea pe linia anterioara
        auxPoint.y = elf.getPozitie().y-1;
        //daca elful se afla deja pe prima linie returnam false intrucat nu se poate deplasa in sus
        if(elf.getPozitie().y < 1) {
            return false;
        }
        //verificam daca noua pozitie e una disponibila prin apelul functiei checkMoveSamePosition si retinem
        //raspunsul intr-o variabila
        checkMove = checkMoveSamePosition(auxPoint);
        //returnam raspunsul in urma verificarii
        return checkMove;
    }

    //metoda prin care se verifica daca un elf se poate deplasa cu o pozitie in jos
    Boolean moveDown(Elf elf) throws NullPointerException {
        //variabila in care se va retine noua pozitie a elfului in urma deplasarii
        Point auxPoint = new Point();
        //variabila in care retinem daca noua pozitie e una disponibila
        Boolean checkMove;
        //pastram aceeasi coloana
        auxPoint.x = elf.getPozitie().x;
        //adunam 1 pentru linie intrucat deplasarea in jos presupune mutarea pe linia urmatoare
        auxPoint.y = elf.getPozitie().y+1;
        //daca elful se afla pe ultima linie returnam false pentru ca nu se poate deplasa in jos
        if(elf.getPozitie().y > this.dimensiune-2) {
            return false;
        }
        //verificam daca noua pozitie e una disponibila prin apelul functiei checkMoveSamePosition si retinem
        //raspunsul intr-o variabila
        checkMove = checkMoveSamePosition(auxPoint);
        //returnam raspunsul in urma verificarii
        return checkMove;
    }

    //metoda prin care se verifica daca un elf se poate deplasa cu o pozitie la stanga
    Boolean moveLeft(Elf elf)throws NullPointerException {
        //variabila in care se va retine noua pozitie a elfului in urma deplasarii
        Point auxPoint = new Point();
        //variabila in care retinem daca noua pozitie e una disponibila
        Boolean checkMove;
        //scadem 1 pentru coloana intrucat deplasarea la stanga presupune trecerea pe coloana anterioara
        auxPoint.x = elf.getPozitie().x-1;
        //pastram aceeasi linie
        auxPoint.y = elf.getPozitie().y;
        //daca elful se afla pe coloana 1 atunci returnam false intrucat nu este posibila deplasarea la stanga
        if(elf.getPozitie().x < 1) {
            return false;
        }
        //verificam daca noua pozitie e una disponibila prin apelul functiei checkMoveSamePosition si retinem
        //raspunsul intr-o variabila
        checkMove = checkMoveSamePosition(auxPoint);
        //returnam raspunsul in urma verificarii
        return checkMove;
    }

    //metoda prin care se verifica daca un elf se poate deplasa cu o pozitie la dreapta
    Boolean moveRight(Elf elf) throws NullPointerException {
        //variabila in care se va retine noua pozitie a elfului in urma deplasarii
        Point auxPoint = new Point();
        //variabila in care retinem daca noua pozitie e una disponibila
        Boolean checkMove;
        //adunam 1 pentru coloana intrucat deplasarea la dreapta presupune trecerea pe coloana urmatoare
        auxPoint.x = elf.getPozitie().x+1;
        //pastram aceeasi linie
        auxPoint.y = elf.getPozitie().y;
        //daca elful se afla pe ultima coloana returnam false intrucat nu se poate deplasa la dreapta
        if(elf.getPozitie().x > this.dimensiune-2) {
            return false;
        }
        //verificam daca noua pozitie e una disponibila prin apelul functiei checkMoveSamePosition si retinem
        //raspunsul intr-o variabila
        checkMove = checkMoveSamePosition(auxPoint);
        //returnam raspunsul in urma verificarii
        return checkMove;
    }

    //metoda prin care se raporteaza crearea unui cadou
    public synchronized void reportPresent (Elf elf, Cadou cadou) {
        zavor.lock();
        System.out.println("Elful cu id-ul "+elf.getIdElf()+" din fabrica  "+elf.getFabrica().idFabrica+" a creat un cadou de tip "+cadou.getNume());
        zavor.unlock();
    }

    //metoda prin care se raporteaza pozitiile elfilor din fabrica
    public synchronized void reportPositions() {
        zavor.lock();
        for (int i = 0; i < fabrica.size(); i++) {
            System.out.println("Pozitia(linie,coloana) elfului "+ elfi.get(i).getIdElf() + " din fabrica "+this.idFabrica+" este: "+elfi.get(i).getPozitie().getY()+","+elfi.get(i).getPozitie().getX());
        }
        //Parte pentru EXTRA TASK 1
        //int elfRandomToRemove = randomNumber.nextInt(this.nrElfi);
        //retragereElf = new RetragereElf(elfi.get(elfRandomToRemove));
        //retragereElf.stopActivity();
        //System.out.println("S-a oprit din productie elful "+elfi.get(elfRandomToRemove).getIdElf()+" din fabrica "+elfi.get(elfRandomToRemove).getFabrica().getIdFabrica());
        //this.elfi.remove(elfRandomToRemove);
        zavor.unlock();
    }

    //metoda prin care se verifica daca toti elfii se afla in zona diagonalei principale
    public Boolean checkAllStopped(){
        for (int i = 0; i < elfi.size();i++){
            if(elfi.get(i).getPozitie().y != elfi.get(i).getPozitie().x){
                return false;
            }
        }
        return true;
    }
    //metoda prin care se realizeaza deplasarea unui elf si crearea unui cadou de catre acesta
    public synchronized void createPresent (Elf elf, Cadou cadou) {
        zavor.lock();
        Integer sleepTime;
        Boolean goodMove;
        int nextMove;
        //daca elful nu se poate deplasa in nici una din pozitiile disponibile
        if (!(moveLeft(elf)|| moveRight(elf) || moveUp(elf) || moveDown(elf)))  {
            //se adauga un delay
            try {
                sleepTime = randomNumber.nextInt(41)+10;
                Thread.sleep(sleepTime);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            //altfel daca este disponibila cel putin una din optiunile de deplasare
        } else {
            //plecam de la premiza ca nu s-a generat o pozitie random disponibila
            goodMove = false;
            //cat timp nu a fost generata o pozite disponibila de deplasare
            while (goodMove==false) {
                //generam un numar intreg random avand codificarea aferenta pentru deplasari
                nextMove = randomNumber.nextInt(4);
                //Parte pentru EXTRA TASK 2
               /* if(elf.getPozitie().x == elf.getPozitie().y && checkAllStopped()== false){
                    oprireElfi.tryAcquire();
                    elf.stopWork();
                    oprireElfi.release();
                }else if(elf.getPozitie().x == elf.getPozitie().y && checkAllStopped() == true){
                    for(int i =0;i<elfi.size();i++){
                        oprireElfi.tryAcquire();
                        elfi.get(i).resumeWork();
                        oprireElfi.release();
                    }
                }*/
                //daca numarul generat e cel aferent deplasarii cu o pozitie in sus
                if(nextMove == 2) {
                    //verificam daca se poate deplasa in sus si retinem rezultatul in variabila goodMove
                    goodMove = moveUp(elf);
                    //daca este ok deplasarea in sus
                    if(goodMove) {
                        //scoatem pozitia veche din fabrica
                        fabrica.remove(elf.getPozitie());
                        //adaugam cadoul creat in lista de cadouri
                        cadouri.add(cadou.getNume());
                        //actualizam pozitia elfului pentru o deplasara in sus
                        elf.getPozitie().y = elf.getPozitie().y - 1;
                        //adaugam noua pozitie in fabrica
                        fabrica.add(elf.getPozitie());
                    }
                }
                //daca numarul generat e cel aferent deplasarii cu o pozitie la dreapta
                else if(nextMove == 1) {
                    //verificam daca se poate deplasa la dreapta si retinem rezultatul in variabila goodMove
                    goodMove = moveRight(elf);
                    //daca este ok deplasarea la dreapta
                    if(goodMove) {
                        //scoatem pozitia veche din fabrica
                        fabrica.remove(elf.getPozitie());
                        //adaugam cadoul creat in lista de cadouri
                        cadouri.add(cadou.getNume());
                        //actualizam pozitia elfului pentru o deplasara la dreapta
                        elf.getPozitie().x = elf.getPozitie().x + 1;
                        //adaugam noua pozitie in fabrica
                        fabrica.add(elf.getPozitie());
                    }
                }
                //daca numarul generat e cel aferent deplasarii cu o pozitie in jos
                else if(nextMove == 3) {
                    //verificam daca se poate deplasa in jos si retinem rezultatul in variabila goodMove
                    goodMove = moveDown(elf);
                    //daca este ok deplasarea in jos
                    if(goodMove) {
                        //scoatem pozitia veche din fabrica
                        fabrica.remove(elf.getPozitie());
                        //adaugam cadoul creat in lista de cadouri
                        cadouri.add(cadou.getNume());
                        //actualizam pozitia elfului pentru o deplasara in jos
                        elf.getPozitie().y = elf.getPozitie().y + 1;
                        //adaugam noua pozitie in fabrica
                        fabrica.add(elf.getPozitie());
                    }
                }
                //daca numarul generat e cel aferent deplasarii cu o pozitie la stanga
                else {
                    //verificam daca se poate deplasa la stanga si retinem rezultatul in variabila goodMove
                    goodMove = moveLeft(elf);
                    //daca este ok deplasarea la stanga
                    if(goodMove) {
                        //scoatem pozitia veche din fabrica
                        fabrica.remove(elf.getPozitie());
                        //adaugam cadoul creat in lista de cadouri
                        cadouri.add(cadou.getNume());
                        //actualizam pozitia elfului pentru o deplasara la stanga
                        elf.getPozitie().x = elf.getPozitie().x - 1;
                        //adaugam noua pozitie in fabrica
                        fabrica.add(elf.getPozitie());
                    }
                }
            }
        zavor.unlock();
            //dupa ce a creat un cadou si s a deplasat elful se odihneste timp de 30 de milisecunde
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    //metoda prin care se transmite un cadou din coada de asteptare catre renul dat ca parametru
    public String takePresent (Ren ren) {
        String cadou;
        //se face achizitia semaforului
        semaphoreReni.tryAcquire();
        //se scoate din coada de asteptare un cadou
        cadou = cadouri.poll();
        //se adauga cadoul extras in lista de cadouri ale renului
        ren.getCadouri().add(cadou);
        //se face release la semafor
        semaphoreReni.release();
        //returnam cadoul extras din coada
        return cadou;
    }

    //sectiune pentru metode de tip GETTER prin care se acceseaza membrii privati

    public ArrayList<Point> getFabrica() {
        return fabrica;
    }

    public int getIdFabrica() {
        return this.idFabrica;
    }

    public ArrayList<Elf> getElfi() {
        return elfi;
    }

}