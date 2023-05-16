import java.io.*;
import java.io.Serializable;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main (String[] args) {
        int length = args.length;
        try {
            if (length < 2) 
                throw new Exception("Argumentami wywolania programu sa: nazwa pliku w ktorym przechowywany jest pojedynczy obiekt, zas drugim argumentem jest nazwa klasy obiektu");
        }
        catch (Exception e) {
            System.out.println("Argumentami wywolania programu sa: nazwa pliku w ktorym przechowywany jest pojedynczy obiekt, zas drugim argumentem jest nazwa klasy obiektu");
            return;
        }
        String plik = args[0];
        String klasa = args[1];

        Pojazd p = new Pojazd();
        Samochod s = new Samochod();
        Tramwaj t = new Tramwaj();

        File f = new File(plik);
        if(!f.exists() || f.isDirectory()) { 
            try {
                FileOutputStream sav = new FileOutputStream("Przyklad.ser");
                ObjectOutputStream outSaving = new ObjectOutputStream(sav);
                if (klasa.equals("Samochod"))
                    outSaving.writeObject(s);
                else {
                    if (klasa.equals("Tramwaj")) 
                        outSaving.writeObject(t);
                    else {
                        if (klasa.equals("Pojazd"))
                            outSaving.writeObject(p);
                        else 
                        throw new Exception("Blad wpisywania do nowego pliku"); 
                    }
                } 
                outSaving.close();
                sav.close();
            }
            catch (Exception e) {
                System.out.println("Blad wpisywania do nowego pliku");
                return;
            }
        }
        
        try {
            FileInputStream read = new FileInputStream(plik);
            ObjectInputStream inReading = new ObjectInputStream(read);

            if (klasa.equals("Samochod")) {
                s = (Samochod) inReading.readObject();
                read.close();
                s.Edycja();
            }
            else {
                if (klasa.equals("Tramwaj")) {
                    t = (Tramwaj) inReading.readObject();
                    read.close();
                    t.Edycja();
                }
                else {
                    if (klasa.equals("Pojazd")) {
                        p = (Pojazd)inReading.readObject();
                        read.close();
                        p.Edycja();
                    }
                    else 
                    throw new Exception("Argumentami wywolania programu sa: nazwa pliku w ktorym przechowywany jest pojedynczy obiekt, zas drugim argumentem jest nazwa klasy obiektu"); 
                }
            } 
        }
        catch (Exception e) {
            System.out.println("Argumentami wywolania programu sa: nazwa pliku w ktorym przechowywany jest pojedynczy obiekt, zas drugim argumentem jest nazwa klasy obiektu");
            return;
        }
    }

    public static void zrob_pojazd () {
        Pojazd a = new Pojazd(123, 312, "Syrena");
        System.out.println(a.toString());
      //  a.Edycja();
        Pojazd Przyklad2  = new Pojazd();

        try {
            FileOutputStream sav = new FileOutputStream("Przyklad.ser");
            ObjectOutputStream outSaving = new ObjectOutputStream(sav);
            outSaving.writeObject(a);
            outSaving.close();
            sav.close();
            FileInputStream read = new FileInputStream("Przyklad.ser");
            ObjectInputStream inReading = new ObjectInputStream(read);
            Przyklad2 = (Pojazd) inReading.readObject();
        }
        catch (Exception e) {
            System.out.println("Blad Serializable");
        }
    }

    public static void zrob_tramwaj() {
        Pojazd a = new Tramwaj();
            try {
            FileOutputStream sav = new FileOutputStream("Przyklad.ser");
            ObjectOutputStream outSaving = new ObjectOutputStream(sav);
            outSaving.writeObject(a);
            outSaving.close();
            sav.close();
        }
        catch (Exception e) {
            System.out.println("Blad Serializable");
        }
    }
    public static void zrob_samochod() {
        Pojazd a = new Samochod();
        try {
            FileOutputStream sav = new FileOutputStream("Przyklad.ser");
            ObjectOutputStream outSaving = new ObjectOutputStream(sav);
            outSaving.writeObject(a);
            outSaving.close();
            sav.close();
        }
        catch (Exception e) {
            System.out.println("Blad Serializable");
        }
    }
}