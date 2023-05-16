import java.io.*;
import java.io.Serializable;

public class Main {
    public static void main (String[] args) {
        try {
        MyList<Integer> Przyklad = new MyList<Integer>();
        for (int i = 0; i < 22; i++) {
            Przyklad.AddToBeginning(i);
            Przyklad.AddToEnd(i);
         //   System.out.println(Przyklad.getfirst());
        }
        FileOutputStream sav = new FileOutputStream("Przyklad.ser");
        ObjectOutputStream outSaving = new ObjectOutputStream(sav);
        outSaving.writeObject(Przyklad);
        outSaving.close();
        sav.close();
        MyList<Integer> Przyklad2 = new MyList<Integer>();
        FileInputStream read = new FileInputStream("Przyklad.ser");
        ObjectInputStream inReading = new ObjectInputStream(read);
        Przyklad2 = (MyList<Integer>) inReading.readObject();
        for (int i = 30; i > 0; i--) 
            System.out.println(Przyklad2.DeleteFromBeginning());
        }
        catch (Exception e) {
            System.out.println("Blad");
        }
      //  System.out.println(":)");
    }
}