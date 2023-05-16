import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.io.*;

class Tramwaj extends Pojazd{
    int liczba_pasazerow;
    int liczba_wagonow;
    String miasto;

    JLabel liczba_pasazerow_etykieta;
    JTextField text_liczba_pasazerow; 

    JLabel liczba_wagonow_etykieta;
    JTextField text_liczba_wagonow; 

    JLabel miasto_etykieta;
    JTextField text_miasto; 


    public Tramwaj () {
        moc_silnika = 772;
        przebieg = 123456;
        marka = "Tesla";
        nazwa_pliku = "Przyklad.ser";
        liczba_pasazerow = 1234;
        liczba_wagonow = 2;
        miasto = "Wroclaw";
    }

    @Override
    public String toString() {
        return "Informacje o pojezdzie:\nMoc silnika: " + Integer.toString(moc_silnika) + 
        "\nPrzebieg: " + Integer.toString(przebieg) + 
        "\nMarka: " + marka + 
        "\nLiczba pasazerow: " + Integer.toString(liczba_pasazerow) +
        "\nLiczba wagonow: " + Integer.toString(liczba_wagonow) +
        "\nMiasto: " + miasto + '\n';
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

        liczba_pasazerow_etykieta = new JLabel("liczba_pasazerow produkcji");
        kontener.add(liczba_pasazerow_etykieta);
        text_liczba_pasazerow = new JTextField(Integer.toString(this.liczba_pasazerow, 40));
        kontener.add(text_liczba_pasazerow);

        liczba_wagonow_etykieta = new JLabel("Liczba liczba_wagonow");
        kontener.add(liczba_wagonow_etykieta);
        text_liczba_wagonow = new JTextField(Integer.toString(this.liczba_wagonow, 40));
        kontener.add(text_liczba_wagonow);

        miasto_etykieta = new JLabel("miasto");
        kontener.add(miasto_etykieta);
        text_miasto = new JTextField(this.miasto, 40);
        kontener.add(text_miasto);


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
            liczba_wagonow = Integer.valueOf(text_liczba_wagonow.getText());
            miasto = text_miasto.getText();
            liczba_pasazerow = Integer.valueOf(text_liczba_pasazerow.getText());
          //  System.out.println(toString());

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
    @Override public void Edycja () {
        createGUI();
    }
}