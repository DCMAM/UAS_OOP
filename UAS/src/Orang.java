import java.util.ArrayList;
import java.util.Calendar;

public class Orang {
	protected String name, address, email, phoneNumber;
	
	Calendar calendar = Calendar.getInstance();
	
	static ArrayList<Orang> list = new ArrayList<Orang>();
	
	public Orang(String name, String address, String email, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getPhoneNumber() {
		return phoneNumber;
	}

	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	protected void cls() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
}
