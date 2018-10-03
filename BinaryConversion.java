import java.util.Scanner;
public class BinaryConversion {

	public static void main(String[] args) {
		
		Scanner l = new Scanner(System.in);
		int[] binary = new int[8];
		
		int numero;
		int j = 0;
		
		System.out.println("Anna kokonaisluku muunnettavaksi: ");
		numero = l.nextInt();
		
		for (int i = numero; i>0; i = i/2) {
			binary[j] = i % 2;
			j++;
		}
		
		System.out.print("Numero " + numero + " on binäärinä ");
		for (int u = binary.length-1; u >= 0; u--) {
			System.out.print(binary[u]);
		}
		
		l.close();

	}

}
