package parkingsystem;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	// mobile number validation
	public static boolean isValidMobile(String mobile) {

		Pattern ptr = Pattern.compile("[1-9]{1}[0-9]{9}");

		Matcher matcher = ptr.matcher(mobile);

		return (matcher.find() && matcher.group().equals(mobile));
	}

	/**
	 * @param mobile
	 * @return
	 */
	public static boolean isValidUniqueMobile(String mobile) {
		DBFunctions dbfunction = new DBFunctions();
		Date date = dbfunction.checkUniqueMobile(mobile);
		Date currentdate = new Date();
		if (date != null) {
			if (date.getYear() == currentdate.getYear() && date.getMonth() == currentdate.getMonth()
					&& date.getDate() == currentdate.getDate()) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	// validation vehicle type
	public static boolean isValidVehicleType(int type) {

		if (type == 2 || type == 4) {
			return true;
		} else {
			return false;
		}
	}

	// validate car number
	public static boolean isValidCarNumber(String car) {
		if (car.length() != 10) {
			return false;
		} else {
			return true;
		}
	}

	// alloted time validation
	public static boolean isValidAllotedTime(int t) {
		if (t > 12) {
			return false;
		} else {
			return true;
		}
	}
}
