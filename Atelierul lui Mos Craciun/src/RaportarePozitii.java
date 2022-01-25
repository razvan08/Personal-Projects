//clasa reprezentata ca un fir de executie prin care
//se realizeaza interogarea elfilor pentru a obtine
//pozitiile acestora
public class RaportarePozitii extends Thread {
    //membru privat de tip Fabrica care retine fabrica pentru care se realizeaza raportarea
    private Fabrica fabrica;
    //membru privat de tip Boolean prin care se poate pornii/oprii raportarea
    private Boolean isOk;

    //contructor in care se initializeaza membrii la anumite valori
    RaportarePozitii (Fabrica fabrica) {
        this.fabrica = fabrica;
        isOk = true;
    }

    public void run () {
        //cat timp membrul aferent este true
        while(isOk) {
            //se incearca un delay de 5000 de ms
            try{
                Thread.sleep(5000);
                //se trateaza exceptia aferenta
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //se apeleaza metoda aferenta din fabrica pentru raportarea pozitiilor
            this.fabrica.reportPositions();
        }
    }
}
