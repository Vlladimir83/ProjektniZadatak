import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

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

				int br = brPjesama + 4;

				if (i == 1) {
					cd.setImeIzvodjaca(data);
				} else if (i == 2) {
					cd.setNaslov(data);
				} else if (i == 3) {
					cd.setGodinaIzdanja(Integer.parseInt(data.substring(0, data.length() - 3)));
					cd.setBrojPjesama(Integer.parseInt(data.substring(data.length() - 2, data.length())));

					brPjesama = Integer.parseInt(data.substring(data.length() - 2, data.length()));
				} else if (i > 3 && i < br) {
					pjesme1.add(data);
				}
				if (i >= br) {
					i = 0;
					cd.setPjesme(pjesme1);
					cds.add(cd);
					cd = new CompactDisc();
					pjesme1 = new ArrayList();
					brPjesama = 0;
					udji = true;
				}

				i++;
			}
			cd.setPjesme(pjesme1);
			cds.add(cd);
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Doslo je do greske.");
			e.printStackTrace();
		}
		// System.out.println(cds);
		CompactDisc cdProba = new CompactDisc();
//		cdProba.getTotalTime(cds.get(0), true);
//		cdProba.getAverage(cds.get(1));
		DomaciFajlovi df = new DomaciFajlovi();
		// df.appendToTextFile("noviFajl", cds.get(0));           
//		df.readFromTextFile("fName.txt", 40, 70, false);        

	}
}
