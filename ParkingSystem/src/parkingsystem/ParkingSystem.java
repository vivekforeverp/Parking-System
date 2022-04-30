package parkingsystem;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class ParkingSystem {

	public static void main(String[] args) {

		char parking_choice = ' '; // do you park or not.

		DBFunctions dbfunction = new DBFunctions();

		Scanner scan = new Scanner(System.in);
		System.out.println("------: Welcome to Parking System Application :------");
		System.out.println("-----------------------------------------------------------");
		do {
			System.out.println("Press A for parking : ");
			System.out.println("Press B for Displacing : ");
			System.out.println("Press C for parking amount : ");
			System.out.println("Press N for close application : ");
			System.out.println("Enter your choice : ");

			parking_choice = (new Scanner(System.in)).next().charAt(0); // take input only single character

			parking_choice = Character.toLowerCase(parking_choice);

			if (parking_choice == 'a') {
				int records = dbfunction.checkRecords();
				if (records == 40) {
					System.out.println("Parking has been full today.. ");
				} else {
					Owner owner = new Owner();
					Vehicle vehicle = new Vehicle();

					System.out.println("Enter your name : "); // owner name input
					owner.setName(scan.nextLine());

					System.out.println("Enter your Mobile no : "); // owner's mobile number input
					String mobile = scan.next();

					while (!Validation.isValidMobile(mobile)) {
						System.out.println("Please enter valid mobile number ===> ");
						mobile = scan.next();
					}
					while (!Validation.isValidUniqueMobile(mobile)) {
						System.out.println("Entered mobile number has been already registered in that time ===> ");
						mobile = scan.next();
					}
					owner.setMobile_no(mobile);

					System.out.println("Enter your bank balance : "); // owner mobile number input
					owner.setBank_balance(scan.nextInt());

					int type;

					// vehicle type input
					System.out.println("Enter your Vechile type \n '2' for two-wheeler \n '4' for four-wheeler : ");
					type = scan.nextInt();

					while (!Validation.isValidVehicleType(type)) {
						System.out.println("Only 2-wheeler and 4-wheeler are allowed.. \n Please try again..");
						type = scan.nextInt();
					}
					vehicle.setVehicle_type(type);

					// input car number
					String car_number;
					System.out.println("Enter car number : ");
					car_number = (new Scanner(System.in)).next();

					while (!Validation.isValidCarNumber(car_number)) {
						System.out.println("Car number must be 10 character : ");
						car_number = (new Scanner(System.in)).next();
					}
					vehicle.setCar_number(car_number);

					System.out.println("Enter modal number : "); // modal number input
					vehicle.setModel_number(scan.nextInt());

					System.out.println("Enter manufacturer name : "); // manufacturer name
					vehicle.setManufacturer((new Scanner(System.in)).nextLine());

					// input for alloted time
					System.out.println("How much hours you want to park ?");
					int time = scan.nextInt();
					while (!Validation.isValidAllotedTime(time)) {
						System.out.println("Only 12 hourse can be alloted for parking :-\n Please, input again :- ");
						time = scan.nextInt();
					}
					owner.setAlloted_time(time);

					owner.setVehicle(vehicle);
					if (dbfunction.park(owner)) {
						System.out.println("Your Ticket Generated Success fully..");
						System.out.println("At the time of Displacing you have to pay ammount..");
					} else {
						System.out.println("There are some technical problem...");
					}

				}
			} else if (parking_choice == 'b') {
				// dbconn.displace();
			} else if (parking_choice == 'c') {
				System.out.println("Enter your vehicle no : "); // owner's mobile number input
				String mobile = scan.next();
				DisplayAmt displayAmt = dbfunction.displayAmnt(mobile);
				DecimalFormat df = new DecimalFormat("0.00");
				float total = 00;
				Date entryDate = null;
				Date currentDate = new Date();
				int hrsCurr = currentDate.getHours() * 60 * 60 * 1000;
				int mntCurr = currentDate.getMinutes() * 60 * 1000;
				int scndCurr = currentDate.getSeconds() * 1000;
				int totalCuntMilli = (hrsCurr + mntCurr + scndCurr);
				entryDate = displayAmt.getEntryDatetime();
				int hrs = entryDate.getHours() * 60 * 60 * 1000;
				int mnt = entryDate.getMinutes() * 60 * 1000;
				int scnd = entryDate.getSeconds() * 1000;
				int totalMilli =(hrs + mnt + scnd) +(displayAmt.getAlloted_time() * 60 * 60 * 1000);
				int diff = (totalCuntMilli )- (hrs + mnt + scnd);
				int hrss = (diff/(1000*60*60));
				int hrs1 = Math.round(hrss);
				if (displayAmt.getVehicle_type() == 2) {

					if (hrs1 <= 3) {
						total = 20 * hrs1;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 15) / 100;
						}
					}
					if (hrs1 > 3) {
						total = 20 * 3;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 15) / 100;
						}
					}

					if (hrs1 > 3 && hrs1 <= 8) {
						total = total + 35 * (hrs1 - 3);
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 15) / 100;
						}
					}
					if (hrs1 > 9) {
						total = 235;
					}
					if (hrs1 >= 9 && hrs1 <= 12) {
						total = total + 50 * (hrs1 - 8);
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 15) / 100;
						}
					}
					if (hrs1 > 12) {
						total = 435;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 15) / 100;
						}
					}
					if (hrs1 > 12) {
						total = total + 70 * (hrs1 - 12);
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 15) / 100;
						}
					}
				
				} else if (displayAmt.getVehicle_type() == 4) {
					
					if (hrs1  <= 3) {
						total = 50 * hrs1;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
					if (hrs1 > 3) {
						total = 50 * 3;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}

					if (hrs1 > 3 && hrs1 <= 8) {
						total = total + 70 * (hrs1 - 3);
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
					if (hrs1 > 9) {
						total = 500;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
					if (hrs1 >= 9 && hrs1 <= 12) {
						total = total + 100 * (hrs1 - 8);
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
					if (hrs1 > 12) {
						total = 900;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
					if (hrs1 > 12) {
						total = total + 120 * (hrs1 - 12);
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
					if (totalCuntMilli > totalMilli) {
						total = (total * 30) / 100;
						if (totalCuntMilli > totalMilli) {
							total = total + (total * 30) / 100;
						}
					}
				}

				System.out.println("------------Parking Bill---------------------");
				System.out.println("name: " + displayAmt.getName());
				System.out.println("Mobile No. : " + displayAmt.getMobile_no());
				System.out.println("Vehicle Type. : " + displayAmt.getVehicle_type());
				System.out.println("Vehicle No. : " + displayAmt.getCar_number());
				System.out.println("Parking Ant. : " + df.format(total) + " Rs.");
				System.out.println("------------Thank You------------------------");
			} else if (parking_choice == 'n') {
				System.exit(0);
			} else {
				System.out.println("Invalid choice ..\nPlease try again..");
			}

		} while (parking_choice != 'n');
	}

}
