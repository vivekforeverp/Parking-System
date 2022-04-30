package parkingsystem;

public class Owner {
	private String name;
	private String mobile_no;
	private int bank_balance;
	private int alloted_time;
	
	private Vehicle vehicle; // 

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile_no
	 */
	public String getMobile_no() {
		return mobile_no;
	}

	/**
	 * @param mobile_no the mobile_no to set
	 */
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	/**
	 * @return the bank_balance
	 */
	public int getBank_balance() {
		return bank_balance;
	}

	/**
	 * @param bank_balance the bank_balance to set
	 */
	public void setBank_balance(int bank_balance) {
		this.bank_balance = bank_balance;
	}

	/**
	 * @return the alloted_time
	 */
	public int getAlloted_time() {
		return alloted_time;
	}

	/**
	 * @param alloted_time the alloted_time to set
	 */
	public void setAlloted_time(int alloted_time) {
		this.alloted_time = alloted_time;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
