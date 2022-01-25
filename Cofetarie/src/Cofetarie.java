import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cofetarie {
    private JPanel panelApp;
    private JButton listaTorturiButton;
    private JList listaDenumiriTorturi;
    private JList pretPerKg;
    private JButton optiuniButton;
    private JButton cumparaButton;
    private JList listaOptiuniCumparare;
    private JTextField torturiDisponibile;
    private JTextField optiuniCumparare;
    private JTextField pretTort;
    private JTextField textAchizitie;
    private ArrayList<Tort> listaTorturi;
    private Tort auxTort = new Tort();


    public void CitireDate() throws IOException {
        BufferedReader inFile = new BufferedReader(new FileReader("D:\\Java Projects\\Cofetarie\\src\\input.txt"));
        String nextline;
        while((nextline = inFile.readLine())!=null){
            String denumire = nextline;
            int greutate = Integer.parseInt(inFile.readLine());
            int pret = Integer.parseInt(inFile.readLine());
            listaTorturi.add(new Tort(denumire,greutate,pret));
        }
    }
    public void ScrieDate() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java Projects\\Cofetarie\\src\\input.txt"));

            for(int i = 0 ;i<listaTorturi.size();i++){
                if(listaTorturi.get(i).getGramaj() > 0) {
                    writer.write(listaTorturi.get(i).getDenumire() + "\n");
                    writer.write(String.valueOf(listaTorturi.get(i).getGramaj()) + "\n");
                    writer.write(String.valueOf(listaTorturi.get(i).getPret()) + "\n");
                }
            }
        writer.close();
    }

    public Cofetarie() throws IOException {
     listaTorturi = new ArrayList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        DefaultListModel<Integer> quantityModel = new DefaultListModel<>();
        DefaultListModel<Integer> priceModel = new DefaultListModel<>();


        listaTorturiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAchizitie.setText("");
                try {
                    CitireDate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for(Tort t:listaTorturi){
                    listModel.addElement(t.getDenumire());
                }
                listaDenumiriTorturi.setModel(listModel);
            }
        });

        optiuniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listaDenumiriTorturi.getSelectedIndex() != -1){
                    String auxText = (String) listaDenumiriTorturi.getSelectedValue();
                    for(int t=0;t<listaTorturi.size();t++){
                        if(auxText == listaTorturi.get(t).getDenumire()){
                            for(int i = 1;i<=listaTorturi.get(t).getGramaj();i++){
                                quantityModel.addElement(i);
                            }
                            priceModel.addElement(listaTorturi.get(t).getPret());
                            auxTort.setTort(listaTorturi.get(t));

                        }
                    }
                    listaOptiuniCumparare.setModel(quantityModel);
                    pretPerKg.setModel(priceModel);
                }
            }
        });
        cumparaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAchizitie.setText("");
                if(listaOptiuniCumparare.getSelectedIndex() != -1){
                    String auxText = "Ati achizitionat "+listaOptiuniCumparare.getSelectedValue()+" kg de tort "+listaDenumiriTorturi.getSelectedValue()+". Pret final: "+(Integer)listaOptiuniCumparare.getSelectedValue()*auxTort.getPret();
                    textAchizitie.setText(auxText);
                }
                listaTorturi.get(listaDenumiriTorturi.getSelectedIndex()).actualizeazaGramaj((int)listaOptiuniCumparare.getSelectedValue());
                listModel.removeAllElements();
                quantityModel.removeAllElements();
                priceModel.removeAllElements();
                try {
                    ScrieDate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                listaTorturi.clear();
            }
        });
    }

    public static void main(String[] args) throws IOException {
        JFrame jFrame = new JFrame("Cofetarie");
        jFrame.setContentPane(new Cofetarie().panelApp);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
