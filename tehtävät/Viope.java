import java.util.Scanner;
public class Viope {
    public static void main(String [] args) {
        String merkkijono;
        Scanner lukija = new Scanner(System.in);

        Tulostaja tulostusOlio = new Tulostaja();

        System.out.print("Anna merkkijono: ");
        merkkijono = lukija.nextLine();

        merkkijono = tulostusOlio.isotPienet(merkkijono);
        tulostusOlio.takaperinHarva(merkkijono);
    }
}

public class Tulostaja {
    public void isotPienet(String teksti) {

    }
}