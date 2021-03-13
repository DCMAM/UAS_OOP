public class Karyawan extends Orang{
	public String location;
	public String startWorking;
	public Integer salary;

	public Karyawan(String name, String address, String email, String phoneNumber, String location, Integer salary, String startWorking2) {
		super(name, address, email, phoneNumber);
		this.location = location;
		this.salary = salary;
		this.startWorking = startWorking2;
	}

	protected String getLocation() {
		return location;
	}
	protected void setLocation(String location) {
		this.location = location;
	}
	
	protected Integer getSalary() {
		return salary;
	}
	protected void setSalary(Integer salary) {
		this.salary = salary;
	}

	protected String getStartWorking() {
		return startWorking;
	}
	protected void setStartWorking(String startWorking) {
		this.startWorking = startWorking;
	}
}
