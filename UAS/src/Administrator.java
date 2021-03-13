import java.util.Scanner;

public class Administrator extends Karyawan implements Runnable{
	public String title;
	public int index;

	public Administrator(String name, String address, String email, String phoneNumber, String location, Integer salary, String startWorking, String title) {
		super(name, address, email, phoneNumber, location, salary, startWorking);
		this.title = title;
	}

	public Administrator(String name, String address, String email, String phoneNumber, String location, Integer salary, String startWorking, String title, int index) {
		super(name, address, email, phoneNumber, location, salary, startWorking);
		this.title = title;
		this.index = index;
	}

	protected int getIndex() {
		return index;
	}	
	
	protected void setIndex(int index) {
		this.index = index;
	}

	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}
	
	public static void menuAdministrator() {
		System.out.println("1. Profile");
		System.out.println("2. Add Mahasiswa");
		System.out.println("3. Add Dosen");
		System.out.println("4. Add Administrator");
		System.out.println("5. List all Mahasiswa");
		System.out.println("6. List all Dosen");
		System.out.println("7. List all Administrator");
		System.out.println("8. List all user");
		System.out.println("9. Change user");
		System.out.print(">> ");
	}
	
	Scanner input = new Scanner(System.in);
	
	@Override
	public void run() {
		int menu_2 = 0;
		do {
			cls();
			Administrator.menuAdministrator();
			menu_2 = input.nextInt();input.nextLine();
			if(menu_2 == 1) profile();
			else if(menu_2 == 2) addMahasiswa();
			else if(menu_2 == 3) addDosen();
			else if(menu_2 == 4) addAdministrator();
			else if(menu_2 == 5) listAllMahasiswa();	
			else if(menu_2 == 6) listAllDosen();
			else if(menu_2 == 7) listAllAdministrator();
			else if(menu_2 == 8) listAllUser();
			else if(menu_2 == 9) {
				if(list.isEmpty()) continue;
				else{
					int menu_9 = 0;
					for (int i = 0; i < list.size(); i++) {
						System.out.println(i+1 + ". " + list.get(i).getName() + " -> " + list.get(i).getClass().toString());
					}
					System.out.print("Choose >> ");
					menu_9 = input.nextInt();input.nextLine();
					if(list.get(menu_9-1) instanceof Mahasiswa) {
						Mahasiswa nM = new Mahasiswa(list.get(menu_9 - 1).getName(), list.get(menu_9 - 1).getAddress(), list.get(menu_9 -1).getEmail(), list.get(menu_9 -1).getPhoneNumber(), ((Mahasiswa)list.get(menu_9-1)).getYearOfTheStudent(), menu_9-1);
						Thread t1 = new Thread(nM);
						t1.start();
					}
					else if(list.get(menu_9-1) instanceof Dosen) {
						Dosen nM = new Dosen(list.get(menu_9-1).getName(), list.get(menu_9 - 1).getAddress(), list.get(menu_9 -1).getEmail(), list.get(menu_9 -1).getPhoneNumber(), ((Dosen)list.get(menu_9-1)).getLocation(), ((Dosen)list.get(menu_9-1)).getSalary(),
								((Dosen)list.get(menu_9-1)).getStartWorking(), ((Dosen)list.get(menu_9-1)).getAcademicLevel(), ((Dosen)list.get(menu_9-1)).getTeachingHours(), menu_9-1);
						Thread t1 = new Thread(nM);
						t1.start();
					}
					else if(list.get(menu_9-1) instanceof Administrator) {
						Administrator nA = new Administrator(list.get(menu_9-1).getName(),  list.get(menu_9 - 1).getAddress(), list.get(menu_9 -1).getEmail(), list.get(menu_9 -1).getPhoneNumber(),((Administrator)list.get(menu_9-1)).getLocation(),((Administrator)list.get(menu_9-1)).getSalary(),
								((Administrator)list.get(menu_9-1)).getStartWorking(), ((Administrator)list.get(menu_9-1)).getTitle(), menu_9-1);
						Thread t1 = new Thread(nA);
						t1.start();
					}
					break;					
				}
			}
			System.out.println("enter to continue.."); input.nextLine();
		}while(true);
		
	}

	private void profile() {
		System.out.println("Name		  : " + list.get(index).getName());
		System.out.println("Address		  : " + list.get(index).getAddress());
		System.out.println("E-mail 		  : " + list.get(index).getEmail());
		System.out.println("Phone number 	  : " + list.get(index).getPhoneNumber());
		System.out.println("Location 	  : " + ((Administrator)list.get(index)).getLocation());
		System.out.println("Salary 		  : " + ((Administrator)list.get(index)).getSalary());
		System.out.println("Start working 	  : " + ((Administrator)list.get(index)).getStartWorking());
		System.out.println("Title		  : " + ((Administrator)list.get(index)).getTitle());
	}

	private void addMahasiswa() {
		String name2, address2, email2, phoneNumber2;
		int yearOfTheStudent2;
		
		System.out.print("Name: "); name2 = input.nextLine();
		System.out.print("Address: "); address2 = input.nextLine();
		System.out.print("Email: "); email2 = input.next();input.nextLine();
		do {
			System.out.print("Phone Number [Integer]: "); phoneNumber2 = input.next(); input.nextLine();	
			try {
				Integer.parseInt(phoneNumber2);
				break;						
			}catch(NumberFormatException e) {}
		}while(true);
		do {					
			System.out.print("Year of the student [2015-2020]: "); yearOfTheStudent2 = input.nextInt();input.nextLine();
		}while(yearOfTheStudent2 < 2015 || yearOfTheStudent2 > 2020);
		Mahasiswa newMahasiswa = new Mahasiswa(name2, address2, email2, phoneNumber2, yearOfTheStudent2);
		list.add(newMahasiswa);
	}

	private void addDosen() {
		String name2, address2, email2, location2, academicLevel2, phoneNumber2;
		Integer salary2, teachingHours2;
		System.out.print("Name: "); name2 = input.nextLine();
		System.out.print("Address: "); address2 = input.nextLine();
		System.out.print("E-mail: "); email2 = input.next();input.nextLine();
		do {
			System.out.print("Phone Number [Integer]: "); phoneNumber2 = input.next(); input.nextLine();	
			try {
				Integer.parseInt(phoneNumber2);
				break;						
			}catch(NumberFormatException e) {}
		}while(true);
		do {
			System.out.print("Location [Kemanggisan | Alam Suterea | Bekasi | Bandung | Malang]: "); location2 = input.nextLine();					
		}while(!(location2.equalsIgnoreCase("Kemanggisan") || location2.equalsIgnoreCase("Alam Sutera") || location2.equalsIgnoreCase("Bekasi") || location2.equalsIgnoreCase("Bandung") || location2.equalsIgnoreCase("Malang")) );
		System.out.print("Salary: "); salary2 = input.nextInt();input.nextLine();
		System.out.print("Academic Level [Asisten Ahli | Lektor | Lektor Kepala | Professor]: "); academicLevel2 = input.nextLine();
		System.out.print("Teaching Hours: "); teachingHours2 = input.nextInt();input.nextLine();
		Dosen newDosen = new Dosen(name2, address2, email2, phoneNumber2, location2, salary2, calendar.getTime().toString(), academicLevel2, teachingHours2);
		list.add(newDosen);
	}

	private void addAdministrator() {
		String location2 = null, phoneNumber2, title2 = null, address2 = null, name2 = null;
		Integer salary2 = null;
		System.out.print("Name: "); name2 = input.nextLine();
		System.out.print("Address: "); address2 = input.nextLine();
		System.out.print("E-mail: "); String email2 = input.next();input.nextLine();
		do {
			System.out.print("Phone Number [Integer]: "); phoneNumber2 = input.next(); input.nextLine();	
			try {
				Integer.parseInt(phoneNumber2);
				break;						
			}catch(NumberFormatException e) {}
		}while(true);
		do {
			System.out.print("Location [Kemanggisan | Alam Suterea | Bekasi | Bandung | Malang]: "); location2 = input.nextLine();					
		}while(!(location2.equalsIgnoreCase("Kemanggisan") || location2.equalsIgnoreCase("Alam Sutera") || location2.equalsIgnoreCase("Bekasi") || location2.equalsIgnoreCase("Bandung") || location2.equalsIgnoreCase("Malang")) );
		System.out.print("Salary: "); salary2 = input.nextInt();input.nextLine();
		do {
			System.out.print("Title [Staff | Supervisor | Manager | Kepala Divisi | Direksi]: "); title2 = input.nextLine();					
		}while(!(title2.equalsIgnoreCase("Staff") || title2.equalsIgnoreCase("Supervisor") || title2.equalsIgnoreCase("Manager") || title2.equalsIgnoreCase("Kepala Divisi") || title2.equalsIgnoreCase("Direksi")));
		Administrator newAdmin = new Administrator(name2, address2, email2, phoneNumber2, location2, salary2, calendar.getTime().toString(), title2);
		list.add(newAdmin);
	}

	private void listAllMahasiswa() {
		int x = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Mahasiswa) {
				x++;
				System.out.printf("%d. %s %s\n", x, 
						((Mahasiswa)list.get(i)).getName(), 
						((Mahasiswa)list.get(i)).getYearOfTheStudent());
			}
		}
	}

	private void listAllDosen() {
		int x = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Dosen) {
				x++;
				System.out.printf("%d. %s %s %s\n", x, 
						list.get(i).getName(), 
						((Dosen)list.get(i)).getLocation(), 
						((Dosen)list.get(i)).getAcademicLevel() );
			}
		}
	}

	private void listAllAdministrator() {
		for (int i = 0; i < list.size(); i++) {
			int x = 0;
			if(list.get(i) instanceof Administrator) {
				x++;
				System.out.printf("%d. %s %s %s\n", x,
						list.get(i).getName(), 
						((Administrator)list.get(i)).getLocation(), 
						((Administrator)list.get(i)).getTitle());
			}
		}
	}

	private void listAllUser() {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d. %-30s -> (%s)\n", i+1, 
					list.get(i).getName(), 
					list.get(i).getClass().toString());
		}
	}
	
}
