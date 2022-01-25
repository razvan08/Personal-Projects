import java.util.Random;

public class Cadou {
    //membru privat de tip String in care se retine denumirea cadoului
    private String nume;
    //membru privat de top vector de String in care se retin denumirile posibile de cadouri
    private String tipuri_Cadou[];

    public Cadou() {
        //variabila cu ajutorul careia se va genera un numar random
        Random cadouRandom = new Random();
        //definim cadourile posibile
        tipuri_Cadou = new String[]{"trenulet", "masinuta", "papusa", "ursulet","minge"};
        //setam membrul nume la o valoare random din lista de cadouri
        nume = tipuri_Cadou[cadouRandom.nextInt(5)];
    }

    //sectiune pentru metode de tip GETTER prin care se acceseaza membrii privati
    public String getNume() {
        return nume;
    }

    public String[] getTipuri_Cadou() {
        return tipuri_Cadou;
    }

}
