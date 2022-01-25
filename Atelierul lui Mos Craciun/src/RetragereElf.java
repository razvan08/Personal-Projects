import java.util.concurrent.Semaphore;

//Clasa folosita pentru implementarea EXTRA TASK 1
//Clasa contine un semafor pe care elful retinut in membrul de tip Elf il va achizitiona atunci cand
//se doreste ca acesta sa se retraga iar pentru a opri corect lucrul pentru acest elf se va apela metoda
//stopWork() care seteaza membrul aferent opririi la valoarea false iar in metoda run nu se va mai
//indeplinii conditia while (punctOprire) iar acest lucru va face ca elful sa si opreasca activitatea
public class RetragereElf extends Thread {
    //membru de tip Semaphore
    Semaphore semaphoreElfi = new Semaphore(1);
    //membru privat de tip Elf in care se retine elful care dorim sa se retraga
    private Elf elf;

    //constructor in care se initializeaza membrul de tip Elf
    RetragereElf(Elf elf){
        this.elf = elf;
    }

    //metoda prin care se opreste activitatea pentru membrul de tip Elf
    public void stopActivity(){
        semaphoreElfi.tryAcquire();
        elf.stopWork();
        semaphoreElfi.release();
    }


}
