public class Tort {
    private String denumire;
    private int gramaj;
    private int pret;

    public Tort(String denumire, int gramaj, int pret) {
        this.denumire = denumire;
        this.gramaj = gramaj;
        this.pret = pret;
    }
    public Tort (){

    }

    public void setTort(Tort t){
        this.denumire = t.getDenumire();
        this.gramaj = t.getGramaj();
        this.pret = t.getPret();
    }

    public void actualizeazaGramaj(int gramajCumparat){
        this.gramaj = this.gramaj-gramajCumparat;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getGramaj() {
        return gramaj;
    }

    public void setGramaj(int gramaj) {
        this.gramaj = gramaj;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

}
