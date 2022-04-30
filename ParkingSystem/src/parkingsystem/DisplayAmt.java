package parkingsystem;

import java.util.Date;

public class DisplayAmt {

	private int alloted_time;
	private int vehicle_type;
	private String name;
	private String mobile_no;
	private String car_number;
	private Date entryDatetime;
	
	
	/**
	 * @return the entryDatetime
	 */
	public Date getEntryDatetime() {
		return entryDatetime;
	}
	/**
	 * @param entryDatetime the entryDatetime to set
	 */
	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}
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
	 * @return the car_number
	 */
	public String getCar_number() {
		return car_number;
	}
	/**
	 * @param car_number the car_number to set
	 */
	public void setCar_number(String car_number) {
		this.car_number = car_number;
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
	 * @return the vehicle_type
	 */
	public int getVehicle_type() {
		return vehicle_type;
	}
	/**
	 * @param vehicle_type the vehicle_type to set
	 */
	public void setVehicle_type(int vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	
}
