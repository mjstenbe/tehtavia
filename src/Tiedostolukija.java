import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class Tiedostolukija {
    public static void main(String[] args) {

        Scanner lukija = null;

        File tiedosto = new File("C:\\testi\\teksti.txt");

        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy");
        }

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println("Riivi: " + rivi);
        }


    }
}
