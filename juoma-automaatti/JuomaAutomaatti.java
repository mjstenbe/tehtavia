public class JuomaAutomaatti {

    //Muuttujat juomien määrille // Näiden muuttujien arvojen sijoitus tulisi olla konstruktorissa, eli public JuomaAutomaatti() -nimisessä rakenteessa
    private int teetä = 50;
    private int kahvia = 50;
    private int kaakaota = 50;

    //Tulostaa juomien määrät
    public String toString() {
        String teksti = "Kahvia jäljellä: " + this.kahvia + ", teetä jäljellä: " + this.teetä + ", kaakaota jäljellä: " + this.kaakaota;
        return teksti;
    }

    //Määritellään juomien valmistusmetodit kahville, teelle ja kaakaolle
    public void valmistaKahvia() {
        //Tarkistaa, että juomaa on tarpeeksi
        if (this.kahvia >= 10) { // Hyvä että tsekkaat että raaka-ainetta on riittävästi ennen vähennystä
            System.out.println("Odota hetki, kahvisi valmistuu...");
            this.kahvia -= 10;
            System.out.println(toString());
        } else {
            System.out.println("Kahvi loppu, tilaa täyttö");
        }
    }

    public void valmistaTeetä() {
        if (this.teetä >= 10) {
            System.out.println("Odota hetki, teesi valmistuu...");
            this.teetä -= 10;
            System.out.println(toString());
        } else {
            System.out.println("Tee loppu, tilaa täyttö");
        }
    }

    public void valmistaKaakaota() {
        if (this.kaakaota >= 10) {
            System.out.println("Odota hetki, kaakaosi valmistuu...");
            this.kaakaota -= 10;
            System.out.println(toString());
        } else {
            System.out.println("Kaakao loppu, tilaa täyttö");
        }
    }

    //Satunnaisuusmetodi, joka kutsutaan juoman valmistuksen yhteydessä
    //Metodi palauttaa 25% todennäköisyydellä arvon false, jolloin juoma ei valmistu
    public boolean Onnistuuko() {
        int numero = (int) (Math.random() * 100 + 1);
        if (numero < 25) {
            return false;
        } else {
            return true;
        }
    }

}
