import java.util.concurrent.CyclicBarrier;

//EXTRA TASK 4

//Implementarea proprie a barierei
public class OdihnireElf {
    int initialParties;
    int partiesAwait;
    Runnable odihnireElfEvent;

    public OdihnireElf(int parties , Runnable odihnireElfEvent){
        initialParties = parties;
        partiesAwait = parties;
        this.odihnireElfEvent = odihnireElfEvent;
    }
    public synchronized void await() throws InterruptedException {
        partiesAwait--;
        if(partiesAwait > 0){
            this.wait();
        }else{
            partiesAwait=initialParties;
            notifyAll();
            odihnireElfEvent.run();
        }

    }


}
