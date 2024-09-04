package Project;

import java.util.*;

public class main_menu {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("----ONLINE SHOPPING SYSTEM----");
		System.out.println("Choose whether you are an Admin or a Customer");
		System.out.println("1.Admin");
		System.out.println("2.Seller");
		System.out.println("3.Customer");
		System.out.println("4.Exit");
		int valid;

		try {
			do {
				valid = 1;
				int choice = in.nextInt();
				switch (choice) {
				case 1:
					admin.main(null);
					break;
				case 2:
					seller.main(null);
					break; 
				case 3:
					customer.main(null);
					break;
				case 4:
					System.out.println("Exiting from program..\nThankyou for using this shopping system!");
					System.exit(0);
					break;
				default:
					System.out.print("Invalid Choice\n");
					valid = 0;
				}
			} while (valid == 0);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Please enter a valid number.");
		}

	}

}
