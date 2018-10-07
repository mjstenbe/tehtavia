import java.util.Scanner;
public class Suoritus {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        JuomaAutomaatti juomis = new JuomaAutomaatti();

        while (true) {
            //Käyttöliittymän piirtäminen
            System.out.println("********Juoma-automaatti********");
            System.out.println("\t1. Kahvi");
            System.out.println("\t2. Tee");
            System.out.println("\t3. Kaakao");
            System.out.println("\t4. Lopeta");
            System.out.println("********************************");

            //Kysytään juomavalinta käyttäjältä
            int valinta = lukija.nextInt();

            //Tarkistetaan, että antaako kone juoman vai syökö rahan, mutta ei kuitenkaan vie rahoja jos käyttäjä haluaa poistua ohjelmasta
            if (juomis.Onnistuuko() == true && valinta != 4) {
                //Valmistetaan juoma valinnan perusteella
                if (valinta == 1) {
                    juomis.valmistaKahvia();
                } else if (valinta == 2) {
                    juomis.valmistaTeetä();
                } else if (valinta == 3) {
                    juomis.valmistaKaakaota();
                } else {
                    //Tarkistetaan, että valinta on validi, muutoin annetaan virhe ja kysytään uudestaan
                    System.out.println("Virheellinen valinta, yritä uudelleen");
                    continue;
                }
            } else if (valinta == 4){
                //Jos valinta on 4, poistutaan ohjelmasta
                System.exit(0);
            } else {
                //Viedään käyttäjän raha muttei anneta juomaa jos Onnistuuko() palauttaa false arvon
                System.out.println("Ei onnistu mutta rahat pidän :-))))");
            }
            lukija.close();

        }
        
    }
}