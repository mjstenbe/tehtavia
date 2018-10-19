import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Tiedostolukija {
	public static void main(String[] args) {

		File file = new File("Tekstitesti.txt");
		Scanner lukija = null;
		FileWriter kirjoittaja = null;
		Scanner teksteri = new Scanner(System.in);

		try {
			file.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			kirjoittaja = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			kirjoittaja.write("peruna");
			kirjoittaja.flush();
			kirjoittaja.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			lukija = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		String rivi = lukija.nextLine();
		System.out.println(rivi);

	}
}
