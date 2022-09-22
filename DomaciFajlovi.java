import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DomaciFajlovi {

	public void appendToTextFile(String fName, CompactDisc cds) {

		try {

			FileWriter file = new FileWriter(fName, true);

			file.write(cds.imeIzvodjaca + "\n" + cds.naslov + "\n" + cds.godinaIzdanja + " " + cds.brojPjesama + "\n");

			for (int i = 0; i < cds.pjesme.size(); i++) {
				file.write(cds.pjesme.get(i).toString() + "\n");
			}
			file.close();
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("");
		}
	}

	public void readFromTextFile(String fName, int minLength, int maxLength, boolean toFile) {

		ArrayList<CompactDisc> cds = new ArrayList<CompactDisc>();
		try {
			File myObj = new File("spisak.txt");
			Scanner myReader = new Scanner(myObj);

			int i = 1;
			int brPjesama = 0;

			ArrayList pjesme1 = new ArrayList();
			CompactDisc cd = new CompactDisc();
			String data = "";
			boolean udji = false;
			while (myReader.hasNextLine()) {
				if (udji == true) {
					udji = false;
				} else {
					data = myReader.nextLine();
				}
				int proba = brPjesama + 4;
				if (i == 1) {
					cd.setImeIzvodjaca(data);
				} else if (i == 2) {
					cd.setNaslov(data);
				} else if (i == 3) {
					cd.setGodinaIzdanja(Integer.parseInt(data.substring(0, data.length() - 3)));
					cd.setBrojPjesama(Integer.parseInt(data.substring(data.length() - 2, data.length())));

					brPjesama = Integer.parseInt(data.substring(data.length() - 2, data.length()));
				} else if (i > 3 && i < proba) {
					pjesme1.add(data);
				}
				if (i >= proba) {

					i = 0;
					cd.setPjesme(pjesme1);
					if (Integer.parseInt(cd.getTotalTime(cd, false)) > minLength
							&& Integer.parseInt(cd.getTotalTime(cd, false)) < maxLength) {
						cds.add(cd);
					}
					cd = new CompactDisc();
					pjesme1 = new ArrayList();
					brPjesama = 0;
					udji = true;
				}
				i++;
			}
			if (toFile == false) {
				for (int i1 = 0; i1 < cds.size(); i1++) {

					System.out.println(
							cds.get(i1).imeIzvodjaca + "-" + cds.get(i1).naslov + " " + "[" + cds.get(i1).godinaIzdanja
									+ "]" + " " + cds.get(i1).getTotalTime(cds.get(i1), false) + " minuta");
				}
			} else {
				try {
					FileWriter file = new FileWriter("rezultat.txt", true);
					for (int i1 = 0; i1 < cds.size(); i1++) {
						file.write(cds.get(i1).imeIzvodjaca + "-" + cds.get(i1).naslov + " " + "["
								+ cds.get(i1).godinaIzdanja + "]" + " " + cds.get(i1).getTotalTime(cds.get(i1), false)
								+ " minuta" + "\n");
					}
					file.close();
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					System.out.println("");
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Doslo je do greske.");
			e.printStackTrace();
		}
	}
}
