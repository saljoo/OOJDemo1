package teht4;
import java.util.LinkedList;
import java.util.Scanner;

class LinkitettyLista{
	private LinkedList<Integer> luvut;
	int i;
	boolean loytyi;
	
	public LinkitettyLista() {
		luvut = new LinkedList<>();
	}
	public void lisaaUusiLuku(int luku) {
		luvut.add(luku);
	}
	public void poistaLuku(int indeksi) {
		luvut.remove(indeksi);
	}
	public String haeIndeksi(int luku) {
		i = 0;
		loytyi = false;
		for(int numero : luvut) {
			if(numero == luku) {
				loytyi = true;
				break;
			}else {
				i++;
			}
		}
		if(loytyi == true) {
			return "" + i;
		}else {
			return "Haettua lukua ei löytynyt.";
		}
	}
	
}

public class Teht4 {

	public static void main(String[] args) {
		 LinkitettyLista lukuLista = new LinkitettyLista();
		 Scanner lukija = new Scanner(System.in);
		 int valinta;
		 int luku;
		 while(true) {
			 System.out.println("1. Lisää luku listaan");
			 System.out.println("2. Poista luku listasta");
			 System.out.println("3. Hae lukua");
			 System.out.println("4. Poistu");
			 System.out.print("Valinta: ");
			 valinta = Integer.valueOf(lukija.nextLine());
			 if(valinta == 1) {
				 System.out.print("Syötä lisättävä luku: ");
				 luku = Integer.valueOf(lukija.nextLine());
				 lukuLista.lisaaUusiLuku(luku);
			 }else if(valinta == 2) {
				 System.out.print("Syötä poistettavan luvun indeksi: ");
				 luku = Integer.valueOf(lukija.nextLine());
				 lukuLista.poistaLuku(luku);
			 }else if(valinta == 3) {
				 System.out.print("Syötä haettava luku: ");
				 luku = Integer.valueOf(lukija.nextLine());
				 System.out.println("Haetun luvun indeksi on " + lukuLista.haeIndeksi(luku));
			 }else if(valinta == 4) {
				 break;
			 }
		 }
		 lukija.close();
	}

}
