import java.util.Scanner;

public class Dosen extends Karyawan implements Runnable{
	public String academicLevel;
	public Integer teachingHours = 0;
	public Integer index = 0;
	
	public Dosen(String name, String address, String email, String phoneNumber, String location, Integer salary2, String startWorking2, String academicLevel, Integer teachingHours) {
		super(name, address, email, phoneNumber, location, salary2, startWorking2);
		this.academicLevel = academicLevel;
		this.teachingHours = teachingHours;
	}
	
	public Dosen(String name, String address, String email, String phoneNumber, String location, Integer salary, String startWorking2, String academicLevel, Integer teachingHours, Integer index){
		super(name, address, email, phoneNumber, location, salary, startWorking2);
		this.academicLevel = academicLevel;
		this.teachingHours = teachingHours;
		this.index = index;
	}
	
	protected Integer getIndex() {
		return index;
	}

	protected void setIndex(Integer index) {
		this.index = index;
	}

	protected String getAcademicLevel() {
		return academicLevel;
	}
	protected void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}
	protected Integer getTeachingHours() {
		return teachingHours;
	}
	protected void setTeachingHours(Integer teachingHours) {
		this.teachingHours = teachingHours;
	}
	
	public static void menuDosen() {
		System.out.println("1. Profile");
		System.out.println("2. Change address");
		System.out.println("3. Change phone number");
		System.out.println("4. Change email");
		System.out.println("5. Change user");
		System.out.print(">> ");
	}
	
	Scanner input = new Scanner(System.in);
	
	@Override
	public void run() {
		int menu_2 = 0;
		do {
			cls();
			Dosen.menuDosen();
			menu_2 = input.nextInt(); input.nextLine();
			if(menu_2 == 1) profile();
			else if(menu_2 == 2) changeAddress();
			else if(menu_2 == 3) changePhoneNumber();
			else if(menu_2 == 4) changeEmail();
			else if(menu_2 == 5) {
				if(list.isEmpty()) {
					continue;
				}
				else{
					int menu_9 = 0;
					for (int i = 0; i < list.size(); i++) {
						System.out.println(i+1 + ". " + list.get(i).getName() + " " + list.get(i).getClass().toString());
					}
					System.out.print("Choose >> ");
					menu_9 = input.nextInt();
					if(list.get(menu_9-1) instanceof Mahasiswa) {
						Mahasiswa nM = new Mahasiswa(list.get(menu_9 - 1).getName(), list.get(menu_9 - 1).getAddress(), list.get(menu_9 -1).getEmail(),
								list.get(menu_9 -1).getPhoneNumber(), ((Mahasiswa)list.get(menu_9-1)).getYearOfTheStudent(), menu_9-1);
						Thread t1 = new Thread(nM);
						t1.start();
					}
					else if(list.get(menu_9-1) instanceof Dosen) {
						Dosen nM = new Dosen(list.get(menu_9-1).getName(), list.get(menu_9 - 1).getAddress(), list.get(menu_9 -1).getEmail(), list.get(menu_9 -1).getPhoneNumber(),
								((Dosen)list.get(menu_9-1)).getLocation(), ((Dosen)list.get(menu_9-1)).getSalary(),
								((Dosen)list.get(menu_9-1)).getStartWorking(), ((Dosen)list.get(menu_9-1)).getAcademicLevel(), ((Dosen)list.get(menu_9-1)).getTeachingHours(), menu_9-1);
						Thread t1 = new Thread(nM);
						t1.start();
					}
					else if(list.get(menu_9-1) instanceof Administrator) {
						Administrator nA = new Administrator(list.get(menu_9-1).getName(),  list.get(menu_9 - 1).getAddress(), list.get(menu_9 -1).getEmail(), 
								list.get(menu_9 -1).getPhoneNumber(),((Administrator)list.get(menu_9-1)).getLocation(),((Administrator)list.get(menu_9-1)).getSalary(),
								((Administrator)list.get(menu_9-1)).getStartWorking(), ((Administrator)list.get(menu_9-1)).getTitle(), menu_9-1);
						Thread t1 = new Thread(nA);
						t1.start();
					}
					break;					
				}
			}
			System.out.println("Enter to continue.."); input.nextLine();
		}while(true);
	}

	private void profile() {
		System.out.println("Name           : " + list.get(index).getName());
		System.out.println("Address        : " + list.get(index).getAddress());
		System.out.println("E-mail         : " + list.get(index).getEmail());
		System.out.println("Phone Number   : " + list.get(index).getPhoneNumber());
		System.out.println("Location       : " + ((Dosen)list.get(index)).getLocation());
		System.out.println("Salary         : " + ((Dosen)list.get(index)).getSalary());
		System.out.println("Start Working  : " + ((Dosen)list.get(index)).getStartWorking());
		System.out.println("Academic Level : " + ((Dosen)list.get(index)).getAcademicLevel());
		System.out.println("Teaching Hours : " + ((Dosen)list.get(index)).getTeachingHours());
	}

	private void changeAddress() {
		String tempAddress;
		System.out.print("New Address: ");
		tempAddress = input.nextLine();
		list.get(index).setAddress(tempAddress);
	}
	
	private void changePhoneNumber() {
		String tempPhone;
		System.out.print("New Phone Number: ");
		tempPhone = input.next();input.nextLine();
		list.get(index).setPhoneNumber(tempPhone);
	}
	
	private void changeEmail() {
		String tempEmail;
		System.out.print("New E-mail: ");
		tempEmail = input.next();input.nextLine();
		list.get(index).setEmail(tempEmail);
	}
}
