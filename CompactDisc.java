import java.util.ArrayList;

public class CompactDisc {

	String imeIzvodjaca;
	String naslov;
	int godinaIzdanja;
	int brojPjesama;
	ArrayList pjesme;

	public String getImeIzvodjaca() {
		return imeIzvodjaca;
	}

	public void setImeIzvodjaca(String imeIzvodjaca) {
		this.imeIzvodjaca = imeIzvodjaca;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov=naslov;
	}

	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(int godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public int getBrojPjesama() {
		return brojPjesama;
	}

	public void setBrojPjesama(int brojPjesama) {
		this.brojPjesama = brojPjesama;
	}

	public ArrayList getPjesme() {
		return pjesme;
	}

	public void setPjesme(ArrayList pjesme) {
		this.pjesme = pjesme;
	}

	public CompactDisc() {
	}

	public CompactDisc(String imeIzvodjaca, String naslov, int godinaIzdanja, int brojPjesama, ArrayList pjesme) {

		this.imeIzvodjaca = imeIzvodjaca;
		this.naslov = naslov;
		this.godinaIzdanja = godinaIzdanja;
		this.brojPjesama = brojPjesama;
		this.pjesme = pjesme;
	}

	@Override
	public String toString() {
		return "CompactDisc  \nIme izvodjaca: " + this.imeIzvodjaca + "\nNaslov: " + this.naslov + "\nGodina izdanja: "
				+ this.godinaIzdanja + ", BrojPjesama: " + this.brojPjesama + ", \nPjesme: " + "\n" + this.pjesme;
	}

	public String getTotalTime(CompactDisc cd, boolean ispisi) {

		int sumaM = 0;
		int sumaS = 0;

		for (int i = 0; i < cd.pjesme.size(); i++) {

			sumaM = sumaM + Integer.parseInt(cd.pjesme.get(i).toString()
					.substring(cd.pjesme.get(i).toString().length() - 5, cd.pjesme.get(i).toString().length() - 4));

			sumaS = sumaS + Integer.parseInt(cd.pjesme.get(i).toString()
					.substring(cd.pjesme.get(i).toString().length() - 3, cd.pjesme.get(i).toString().length() - 1));

		}
		// System.out.println("\nUkupno minuta: " + sumaM);
		//System.out.println("\nUkupno sekundi: " + sumaS);
		double sumaS1 = sumaS;
		double sekundeUminute = (sumaS1 / 60);
		// System.out.println(sekundeUminute);
		double suma = sumaM + (Math.floor(sekundeUminute));

		double sec = sumaS % 60;
		double min = (sumaS / 60) % 60;
		// System.out.println("minute: " + min + " sekunde :" + sec);
		if(ispisi == true)
		{
			System.out.println("Ukupno trajanje pjesama na CD-u je: " + Math.round(suma) + ":" + Math.round(sec));
		}
		
		int sum = (int) suma;
		return Integer.toString(sum);

	}

	public String getAverage(CompactDisc cd) {

		double zbirM = 0;
		double zbirS = 0;

		for (int i = 0; i < ((ArrayList) cd.pjesme).size(); i++) {

			zbirM = zbirM + Integer.parseInt(cd.pjesme.get(i).toString()
					.substring(cd.pjesme.get(i).toString().length() - 5, cd.pjesme.get(i).toString().length() - 4));

			zbirS = zbirS + Integer.parseInt(cd.pjesme.get(i).toString()
					.substring(cd.pjesme.get(i).toString().length() - 3, cd.pjesme.get(i).toString().length() - 1));
		}
		// System.out.println("\nZbir minuta: " +zbirM);
		// System.out.println("\nZbir sekundi: " +zbirS);
		double minUsec = (zbirM * 60);
		double ukupnoSec = (minUsec + zbirS);
		// System.out.println("ukupno sekundi: " + ukupnoSec);
		double prosjekS = (ukupnoSec / cd.brojPjesama);
		// System.out.println("prosjek u sekundama:" + prosjekS);
		double secUmin = (prosjekS / 60);
		// System.out.println("sekunde u minute:" + secUmin);

		double sec1 = prosjekS % 60;
		double min1 = (prosjekS / 60) % 60;

		min1 = Math.floor(min1);
		// System.out.println("min1:" + min1);
		// System.out.println("sec1:" + sec1);
		System.out.println("Prosjecna duzina pjesme na CD-u je : " + Math.round(min1) + ":" + Math.round(sec1));
		return (Math.round(min1) + ":" + Math.round(sec1));
	}

}