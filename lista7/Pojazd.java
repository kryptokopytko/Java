import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.io.*;

class Pojazd implements ActionListener, Serializable {
    int moc_silnika;
    int przebieg;
    String marka;
    String nazwa_pliku;

    JFrame frame;
    JTextField text_silnik;
    JLabel silnik_etykieta;
    JTextField text_przebieg;
    JLabel przebieg_etykieta;
    JLabel marka_etykieta;
    JTextField text_marka; 
    JButton b;

    public String toString() {
        return "Informacje o pojezdzie:\nMoc silnika: " + Integer.toString(moc_silnika) + "\nPrzebieg: " + Integer.toString(przebieg) + "\nMarka: " + marka + '\n';
    }

    public Pojazd(int Silnik, int Przebieg, String Marka) {
        moc_silnika = Silnik;
        przebieg = Przebieg;
        marka = Marka;
        nazwa_pliku = "Przyklad.ser";
    }
    public Pojazd () {
        moc_silnika = 772;
        przebieg = 123456;
        marka = "Tesla";
        nazwa_pliku = "Przyklad.ser";
    }

    private void createGUI() {
        frame = new JFrame("Edycja pojazdu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container kontener = frame.getContentPane();
        GridLayout layout = new GridLayout(4, 2);
        kontener.setLayout(layout);

        silnik_etykieta = new JLabel("moc silnika");
        kontener.add(silnik_etykieta);
        text_silnik = 
        new JTextField(Integer.toString(this.moc_silnika, 40));
        kontener.add(text_silnik);

        przebieg_etykieta = new JLabel("przebieg");
        kontener.add(przebieg_etykieta);
        text_przebieg = 
        new JTextField(Integer.toString(this.przebieg, 40));
        kontener.add(text_przebieg);

        marka_etykieta = new JLabel("marka");
        kontener.add(marka_etykieta);
        text_marka = new JTextField(this.marka, 40);
        kontener.add(text_marka);

        b = new JButton("Zapisz");
        b.addActionListener(this);
        kontener.add(b);

        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Zapisz")) {
            moc_silnika = Integer.valueOf(text_silnik.getText());
            przebieg = Integer.valueOf(text_przebieg.getText());
            marka = text_marka.getText();

            try {
                FileOutputStream sav = new FileOutputStream(nazwa_pliku);
                ObjectOutputStream outSaving = new ObjectOutputStream(sav);
                outSaving.writeObject(this);
                outSaving.close();
                sav.close();
            }
            catch (Exception er) {
                System.out.println("Blad wypisywania do pliku");
                return;
            }
        }
    }

    public void Edycja() {
         createGUI();
    }
}
