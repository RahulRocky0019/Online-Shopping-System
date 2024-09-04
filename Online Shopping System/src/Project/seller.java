package Project;

import info_details.*;
import java.util.*;

public class seller extends info implements activity {

	private int seller_id;
	private long seller_phoneno;
	private String seller_name, seller_email, seller_password, seller_address;

	static ArrayList<seller> seller_list = new ArrayList<seller>();
	static Scanner in = new Scanner(System.in);

	seller() {
	}

	seller(int id, String Name, String emailid, String Password, long Phoneno, String Address) {
		this.seller_id = id;
		this.seller_name = Name;
		this.seller_email = emailid;
		this.seller_password = Password;
		this.seller_phoneno = Phoneno;
		this.seller_address = Address;
	}

	static void register() {
		System.out.println("Enter id (numbers only): ");
		int id = in.nextInt();
		System.out.println("Enter Name: ");
		String Name = in.next();
		System.out.println("Enter emaild: ");
		String emailid = in.next();
		System.out.println("Enter password: ");
		String Password = in.next();
		System.out.println("Enter Phoneno: ");
		long Phoneno;
		int valid;
		do {
			valid = 1;
			Phoneno = in.nextLong();
			if (String.valueOf(Phoneno).length() != 10) {
				System.out.println("Invalid Phone.No");
				valid = 0;
			}
		} while (valid == 0);
		System.out.println("Enter Address: ");
		String Address = in.next();

		seller New = new seller(id, Name, emailid, Password, Phoneno, Address);
		seller_list.add(New);
		System.out.print("User Successfully Registered");
		afterlogin(New);
	}

	static void login() {
		System.out.println("Enter UserName id: ");
		int id = in.nextInt();
		System.out.println("Enter password: ");
		String Password = in.next();

		for (seller i : seller_list) {
			if (i.seller_id == id && i.seller_password.equals(Password)) {
				seller.afterlogin(i);
			} else {
				System.out.println("User id and password does not match/exist");
				seller.main(null);
			}
		}
	}

	static void afterlogin(seller i) {
		System.out.println("\n\nWelcome " + i.seller_name + "\nChoose option");
		System.out.println("1.Manage Products\n2.Manage Account\n3.View your Products\n4.Back");
		int choice = in.nextInt();

		switch (choice) {
		case 1:
			products.main(null);
			break;
		case 2:
			seller.manage_account(i.seller_id);
			break;
		case 3:
			products.view_your_products(i.seller_id);
			break;
		case 4:
			seller.main(null);
			break;
		default:
			System.out.print("Invalid Choice\n");
		}
	}

	static void afterlogin(int sellerid) {
		for (seller i : seller_list) {
			System.out.println("\n\nWelcome " + i.seller_name + "\nChoose option");
			System.out.println("1.Manage Products\n2.Manage Account\n3.View your Products\n4.Back");
			int choice = in.nextInt();

			switch (choice) {
			case 1:
				products.main(null);
				break;
			case 2:
				seller.manage_account(i.seller_id);
				break;
			case 3:
				products.view_your_products(i.seller_id);
				break;
			case 4:
				seller.main(null);
				break;
			default:
				System.out.print("Invalid Choice\n");
			}
		}
	}

	static void manage_account(int id) {
		for (seller i : seller_list) {
			if (i.seller_id == id) {
				seller old = i;
				int valid;
				do {
					valid = 1;
					System.out.println(toString(i));
					System.out.println("/nMANAGE ACCOUNT");
					System.out.println("1.Change Name");
					System.out.println("2.Change Password");
					System.out.println("3.Change Address");
					System.out.println("4.Change Phoneno");
					System.out.println("5.Change emailid");
					System.out.println("6.Back");

					int choosec = in.nextInt();
					switch (choosec) {
					case 1:
						System.out.println("Enter new Name: ");
						String Name = in.next();
						seller Newn = new seller(i.seller_id, Name, i.seller_email, i.seller_password, i.seller_phoneno,
								i.seller_address);
						seller_list.add(Newn);
						System.out.println("Address changed successfully");
						break;
					case 2:
						System.out.println("Enter old password: ");
						String oldp = in.next();
						if (i.seller_password.equals(oldp)) {
							System.out.println("Enter new password: ");
							String Password = in.next();
							seller Newp = new seller(i.seller_id, i.seller_name, i.seller_email, Password,
									i.seller_phoneno, i.seller_address);
							seller_list.add(Newp);
							System.out.println("Password changed successfully");
						} else {
							System.out.println("Wrong Password");
							seller Newp = new seller(i.seller_id, i.seller_name, i.seller_email, i.seller_password,
									i.seller_phoneno, i.seller_address);
							seller_list.add(Newp);
							seller.afterlogin(i);
						}
						break;
					case 3:
						System.out.println("Enter new Address: ");
						String Address = in.next();
						seller Newa = new seller(i.seller_id, i.seller_name, i.seller_email, i.seller_password,
								i.seller_phoneno, Address);
						seller_list.add(Newa);
						System.out.println("Address changed successfully");
						break;
					case 4:
						System.out.println("Enter new Phone number: ");
						long Phoneno = in.nextLong();
						seller Newpn = new seller(i.seller_id, i.seller_name, i.seller_email, i.seller_password,
								Phoneno, i.seller_address);
						seller_list.add(Newpn);
						System.out.println("Phone No changed successfully");
						break;
					case 5:
						System.out.println("Enter emaild: ");
						String emailid = in.next();
						seller Newe = new seller(i.seller_id, i.seller_name, emailid, i.seller_password,
								i.seller_phoneno, i.seller_address);
						seller_list.add(Newe);
						System.out.println("emailid changed successfully");
						break;
					case 6:
						seller.afterlogin(i);
						break;
					default:
						System.out.println("Invalid Option");
						valid = 0;
					}
				} while (valid == 0);

				seller_list.remove(old);
				seller.afterlogin(i);
			}
		}
	}

	public static String toString(seller i) {
		return "\nid: " + i.seller_id + "\nName: " + i.seller_name + "\nemailid: " + i.seller_email + "\nAddress: "
				+ i.seller_address + "\nPhoneno: " + i.seller_phoneno;
	}

	public String get_seller_name() {
		return seller_name;
	}

	public int get_seller_id() {
		return seller_id;
	}

	public String get_seller_email() {
		return seller_email;
	}

	public void page_info() {
		System.out.println("welcome to the seller page \n");
	}

	public void get_activity() {
		System.out.println("These are the activities that you can perform in our webiste ");
		System.out.println("First you need to login or register");
		System.out.println("After login :");
		System.out.println("1. seller can manage products \n add \n edit \n delete");
		System.out.println("2 . Seller can manage his account");
		System.out.println("2 . Seller can view their products");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		seller temp = new seller();
		temp.page_info();
		System.out.println("Do you want to see the activities that you can perform (y/n)");
		String t = in.next();
		if (t.equals("y")) {
			temp.get_activity();
		}
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.Back");
		int valid;
		try {
			do {
				valid = 1;
				int choice = in.nextInt();
				switch (choice) {
				case 1:
					seller.register();
					break;
				case 2:
					seller.login();
					break;
				case 3:
					main_menu.main(null);
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
