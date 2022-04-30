package parkingsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DBFunctions {
	private Connection link = null;

	public DBFunctions() {
		DBConnection db = DBConnection.getInstance(); // instance of dbconnection class

		if (link == null) {
			link = db.getLink(); // get the connection object
		} else {
			System.out.println("failed due to technical problem");
		}
	}

	/**
	 * @param carNumber
	 * @return
	 */
	public DisplayAmt displayAmnt(String carNumber) {
		PreparedStatement stmt = null;
		DisplayAmt displayAmt = new DisplayAmt();
		try {
			stmt = link.prepareStatement(
					"select entry_datetime, vehicle_type, alloted_time,mobile_no, uname, car_number from parking where car_number=? AND DATE(entry_datetime) = CURDATE()");
			stmt.setString(1, carNumber);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				displayAmt.setEntryDatetime(rs.getTimestamp("entry_datetime"));
				displayAmt.setAlloted_time(rs.getInt("alloted_time"));
				displayAmt.setVehicle_type(rs.getInt("vehicle_type"));
				displayAmt.setName(rs.getString("uname"));
				displayAmt.setMobile_no(rs.getString("mobile_no"));
				displayAmt.setCar_number(rs.getString("car_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return displayAmt;
	}

	/**
	 * @return
	 */
	public int checkRecords() {
		PreparedStatement stmt = null;
		int i = 0;
		try {
			stmt = link.prepareStatement("select *from parking where DATE(entry_datetime) = CURDATE()");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return i;
	}

	// method to store parking information
	public boolean park(Owner owner) {
		boolean status = false;

		/*
		 * Date date = new Date(); // get current date and time (by java.util.Date)
		 * java.sql.Date sqldate = new java.sql.Date(date.getDate()); // convert current
		 * date and time into sql format
		 */

		String query = "insert into parking(uname, mobile_no, bank_balance, vehicle_type,modal_number, manufacturer, car_number, entry_datetime, alloted_time) values(?,?,?,?,?,?,?, CURRENT_TIMESTAMP,?)";

		try {
			PreparedStatement stmt = link.prepareStatement(query);
			stmt.setString(1, owner.getName());
			stmt.setString(2, owner.getMobile_no());
			stmt.setInt(3, owner.getBank_balance());
			stmt.setInt(4, owner.getVehicle().getVehicle_type());
			stmt.setInt(5, owner.getVehicle().getModel_number());
			stmt.setString(6, owner.getVehicle().getManufacturer());
			stmt.setString(7, owner.getVehicle().getCar_number());
			stmt.setInt(8, owner.getAlloted_time());

			int result = stmt.executeUpdate();

			if (result > 0) {
				status = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * @param mobile
	 * @return
	 */
	public Date checkUniqueMobile(String mobile) {
		Date date = null;
		PreparedStatement stmt = null;
		;
		try {
			stmt = link.prepareStatement("select entry_datetime from parking where mobile_no = ?");
			stmt.setString(1, mobile);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				date = rs.getTimestamp("entry_datetime");
				System.out.println("===date=======" + date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return date;
	}
}
