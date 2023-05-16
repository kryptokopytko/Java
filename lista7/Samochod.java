import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.io.*;

class Samochod extends  Pojazd {
    int rok_produkcji;
    int liczba_drzwi;
    String rodzaj;

    JLabel rok_etykieta;
    JTextField text_rok; 

    JLabel drzwi_etykieta;
    JTextField text_drzwi; 

    JLabel rodzaj_etykieta;
    JTextField text_rodzaj; 


    public Samochod() {
        moc_silnika = 772;
        przebieg = 123456;
        marka = "Tesla";
        nazwa_pliku = "Przyklad.ser";
        rok_produkcji = 1986;
        liczba_drzwi = 5;
        rodzaj = "kaczka";
    }
    @Override
    public String toString() {
        return "Informacje o pojezdzie:\nMoc silnika: " +  Integer.toString(moc_silnika) + 
        "\nPrzebieg: " + Integer.toString(przebieg) + 
        "\nMarka: " + marka + 
        "\nLiczba drzwi: " + Integer.toString(liczba_drzwi) +
        "\nRok produkcji: " + Integer.toString(rok_produkcji) +
        "\nRodzaj: " + rodzaj + '\n';
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

        rok_etykieta = new JLabel("rok produkcji");
        kontener.add(rok_etykieta);
        text_rok = new JTextField(Integer.toString(this.rok_produkcji, 40));
        kontener.add(text_rok);

        drzwi_etykieta = new JLabel("Liczba drzwi");
        kontener.add(drzwi_etykieta);
        text_drzwi = new JTextField(Integer.toString(this.liczba_drzwi, 40));
        kontener.add(text_drzwi);

        rodzaj_etykieta = new JLabel("rodzaj");
        kontener.add(rodzaj_etykieta);
        text_rodzaj = new JTextField(this.rodzaj, 40);
        kontener.add(text_rodzaj);


        b = new JButton("Zapisz");
        b.addActionListener(this);
        kontener.add(b);

        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Zapisz")) {
            moc_silnika = Integer.valueOf(text_silnik.getText());
            przebieg = Integer.valueOf(text_przebieg.getText());
            marka = text_marka.getText();
            liczba_drzwi = Integer.valueOf(text_drzwi.getText());
            rodzaj = text_rodzaj.getText();
            rok_produkcji = Integer.valueOf(text_rok.getText());
          //  System.out.println(toString());
        }

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
    @Override public void Edycja () {
        createGUI();
    }
}