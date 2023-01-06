package teht1;
import java.util.Scanner;

//Luodaan luokka Laiva
class Laiva{
	protected String nimi;
	protected double pituus;
	protected double syvays;
	protected double nopeus;
	protected Scanner lukija = new Scanner(System.in);
	
	public Laiva(String nimi, double pituus, double syvays, double nopeus) {
		this.nimi = nimi;
		this.pituus = pituus;
		this.syvays = syvays;
		this.nopeus = nopeus;
	}
	public Laiva() {
		this.nimi = "";
		this.pituus = 0;
		this.syvays = 0;
		this.nopeus = 0;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public double getNopeus() {
		return nopeus;
	}
	public void setNopeus(double nopeus) {
		this.nopeus = nopeus;
	}
	public double getPituus() {
		return pituus;
	}
	public void setPituus(double pituus) {
		this.pituus = pituus;
	}
	public double getSyvays() {
		return syvays;
	}
	public void setSyvays(double syvays) {
		this.syvays = syvays;
	}
	public void matkanKesto() {
		System.out.print("Anna matkan pituus kilometrein�: ");
		double matka = Double.valueOf(lukija.nextLine());
		double kesto = Math.round((matka / (getNopeus() * 1.852))*100.0)/100.0;
		System.out.println("Matkassa kest�� " + kesto + " tuntia.");
	}
}

//Luodaan luokka Rahtilaiva, joka perii luoka Laiva
class Rahtilaiva extends Laiva{
	private double kapasiteetti;
	private double rahti;
	
	public Rahtilaiva(String nimi, double pituus, double syvays, double nopeus, double kapasiteetti) {
		super(nimi, pituus, syvays, nopeus);
		this.kapasiteetti = kapasiteetti;
		this.rahti = 0;
	}
	public double getKapasiteetti() {
		return kapasiteetti;
	}
	public void setKapasiteetti(double kapasiteetti) {
		this.kapasiteetti = kapasiteetti;
	}
	public double getRahti() {
		return rahti;
	}
	public void lisaaRahti(double rahti) {
		if(this.rahti + rahti < kapasiteetti && this.rahti + rahti >= 0) {
			this.rahti += rahti;
			//Muutetaan nopeus vastaamaan rahdin painoa
			this.nopeus = nopeus*(Math.abs((this.rahti/kapasiteetti)-1));
		}else {
			System.out.println("Rahti on liian suuri tai rahti menee negatiiviseksi.");
		}
	}
}

//Luodaan luokka Autolautta, joka perii luoka Laiva
class Autolautta extends Laiva{
	private final int kapasiteetti;
	private int matkustajat;
	private int ajoneuvot;
	
	public Autolautta(String nimi, double pituus, double syvays, double nopeus, int kapasiteetti) {
		super(nimi, pituus, syvays, nopeus);
		this.kapasiteetti = kapasiteetti;
		this.matkustajat = 0;
		this.ajoneuvot = 0;
	}
	public int getKapasiteetti() {
		return kapasiteetti;
	}
	public int getMatkustajat() {
		return matkustajat;
	}
	public void lisaaMatkustajat(int matkustajat) {
		if(this.matkustajat + matkustajat + this.ajoneuvot*10 <= kapasiteetti && this.matkustajat + matkustajat >= 0) {
			this.matkustajat += matkustajat;
		}else {
			System.out.println("Valittua m��r�� matkustajia ei voida lis�t�.");
		}
	}
	public int getAjoneuvot() {
		return ajoneuvot;
	}
	public void lisaaAjoneuvot(int ajoneuvot) {
		if(this.ajoneuvot*10 + ajoneuvot*10 + this.matkustajat <= kapasiteetti && this.ajoneuvot + ajoneuvot >= 0) {
			this.ajoneuvot += ajoneuvot;
		}else {
			System.out.println("Valittua m��r�� ajoneuvoja ei voida lis�t�.");
		}
	}
}

public class Teht1 {

	public static void main(String[] args) {
		Rahtilaiva rahtiLaiva = new Rahtilaiva("Tankker", 313.4, 26.4, 20, 200);
		System.out.println("Laivan nimi: " + rahtiLaiva.getNimi());
		rahtiLaiva.lisaaRahti(100);
		System.out.println("Laivan rahti: " + rahtiLaiva.getRahti() + ", Laivan nopeus: " + rahtiLaiva.getNopeus());
		Autolautta autoLautta = new Autolautta("Lautta", 50.5, 4.2, 15, 150);
		autoLautta.lisaaAjoneuvot(4);
		autoLautta.lisaaMatkustajat(7);
		System.out.println("Ajoneuvot: " + autoLautta.getAjoneuvot() + ", Matkustajat: " + autoLautta.getMatkustajat());
	}

}
