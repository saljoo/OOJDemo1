package teht2;
import java.util.Scanner;

class Paivakirja{
	private String salasana;
	
	public Paivakirja(String salasana) {
		this.salasana = salasana;
	}
	public String getSalasana() {
		return salasana;
	}
}

public class Teht2 {

	public static void main(String[] args) {
		Paivakirja paivakirja = new Paivakirja("TamaOnSalasana");
		Scanner lukija = new Scanner(System.in);
		String syote;
		int valinta;
		System.out.println("1. Muokkaa p�iv�kirjaa");
		System.out.println("2. Lue p�iv�kirjaa");
		System.out.print("Valinta: ");
		valinta = Integer.valueOf(lukija.nextLine());
		if(valinta == 1) {
			System.out.print("Sy�t� salasana: ");
			syote = lukija.nextLine();
			if(syote.equals(paivakirja.getSalasana())) {
				System.out.println("Sinulla on oikeus muokata p�iv�kirjaa.");
			}else {
				System.out.println("Salasana on v��r�.");
			}
		}else if(valinta == 2) {
			System.out.print("Sy�t� salasana: ");
			syote = lukija.nextLine();
			if(syote.equals(paivakirja.getSalasana())) {
				System.out.println("Sinulla on oikeus lukea p�iv�kirjaa.");
			}else {
				System.out.println("Salasana on v��r�.");
			}
		}
		lukija.close();
	}

}
