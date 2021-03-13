import java.util.Calendar;
import java.util.Scanner;

public class Main extends Thread{
	Scanner input = new Scanner(System.in);
	Calendar calendar = Calendar.getInstance();
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		cls();
		Administrator na = new Administrator("Admin 123", "Jakarta No.1", "admin123@binus.ac.id", "082195551234", "Alam Sutera", 10000,  calendar.getTime().toString(), "Direksi", 0);
		Orang.list.add(na);
		Mahasiswa nm = new Mahasiswa("David Alexander", "Bogor Raya No.1", "davidalexander@binus.ac.id", "08219333", 2019);
		Orang.list.add(nm);
		Dosen nd = new Dosen("Michael Christian", "Jakarta No.1", "dosen@binus.ac.id", "08219678", "Alam Sutera", 10000, calendar.getTime().toString(), "Professor", 1500);
		Orang.list.add(nd);
		Thread t1 = new Thread(na);
		t1.start();
	}

	private void cls() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}
}
