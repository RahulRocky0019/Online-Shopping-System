package Project;

import info_details.*;
import java.util.*;

public class customer extends info implements activity {

	private int customer_id;
	private long customer_phoneno;
	private String customer_name, customer_email, customer_password, customer_address;

	static ArrayList<customer> customer_list = new ArrayList<customer>();
	static Scanner in = new Scanner(System.in);

	customer() {
	}

	customer(int id, String Name, String emailid, String Password, long Phoneno, String Address) {
		this.customer_id = id;
		this.customer_name = Name;
		this.customer_email = emailid;
		this.customer_password = Password;
		this.customer_phoneno = Phoneno;
		this.customer_address = Address;
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

		customer New = new customer(id, Name, emailid, Password, Phoneno, Address);
		customer_list.add(New);
		System.out.print("User Successfully Registered");
		afterlogin(New);
	}

	static void login() {
		System.out.println("Enter UserName id: ");
		int id = in.nextInt();
		System.out.println("Enter password: ");
		String Password = in.next();

		for (customer i : customer_list) {
			if (i.customer_id == id && i.customer_password.equals(Password)) {
				customer.afterlogin(i);
			} else {
				System.out.println("User id and password does not match/exist");
				customer.main(null);
			}
		}
	}

	static void afterlogin(customer i) {
		System.out.println("\nWelcome " + i.customer_name + "\nChoose option");
		System.out.println("1.Item Menu\n2.Manage Account\n3.Back");
		int choice = in.nextInt();

		switch (choice) {
		case 1:
			products.view_all_products();
			System.out.println("\n");
			System.out.println("1.Add Item");
			System.out.println("2.Back");
			int valid;
			do {
				valid = 1;
				int choicep = in.nextInt();
				switch (choicep) {
				case 1:
					System.out.println("How many products do you want to add:");
					int nop = in.nextInt();
					for (int k = 0; k < nop; k++) {
						System.out.println("Enetr Product ID:");
						int prdid = in.nextInt();
						for (products j : products.products_list) {
							if (j.product_id == prdid) {
								cart.AddToCart(j);
							}
						}
					}
					cart.after_add_cart();
					break;
				case 2:
					afterlogin(i);
					break;
				default:
					System.out.print("Invalid Choice\n");
					valid = 0;
				}
			} while (valid == 0);
			break;
		case 2:
			customer.manage_account(i.customer_id);
			break;
		case 3:
			customer.main(null);
			break;
		default:
			System.out.print("Invalid Choice\n");
		}
	}

	static void manage_account(int id) {
		for (customer i : customer_list) {
			if (i.customer_id == id) {
				customer old = i;
				int valid;
				do {
					valid = 1;
					System.out.println(toString(i));
					System.out.println("\nMANAGE ACCOUNT");
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
						customer Newn = new customer(i.customer_id, Name, i.customer_email, i.customer_password,
								i.customer_phoneno, i.customer_address);
						customer_list.add(Newn);
						System.out.println("Address changed successfully");
						break;
					case 2:
						System.out.println("Enter old password: ");
						String oldp = in.next();
						if (i.customer_password.equals(oldp)) {
							System.out.println("Enter new password: ");
							String Password = in.next();
							customer Newp = new customer(i.customer_id, i.customer_name, i.customer_email, Password,
									i.customer_phoneno, i.customer_address);
							customer_list.add(Newp);
							System.out.println("Password changed successfully");
						}
						break;
					case 3:
						System.out.println("Enter new Address: ");
						String Address = in.next();
						customer Newa = new customer(i.customer_id, i.customer_name, i.customer_email,
								i.customer_password, i.customer_phoneno, Address);
						customer_list.add(Newa);
						System.out.println("Address changed successfully");
						break;
					case 4:
						System.out.println("Enter new Phone number: ");
						long Phoneno = in.nextLong();
						customer Newpn = new customer(i.customer_id, i.customer_name, i.customer_email,
								i.customer_password, Phoneno, i.customer_address);
						customer_list.add(Newpn);
						System.out.println("Phone No changed successfully");
						break;
					case 5:
						System.out.println("Enter emaild: ");
						String emailid = in.next();
						customer Newe = new customer(i.customer_id, i.customer_name, emailid, i.customer_password,
								i.customer_phoneno, i.customer_address);
						customer_list.add(Newe);
						System.out.println("emailid changed successfully");
						break;
					case 6:
						customer.afterlogin(i);
						break;
					default:
						System.out.println("Invalid Option");
						valid = 0;
					}
				} while (valid == 0);

				customer_list.remove(old);
				customer.afterlogin(i);
			}
		}
	}

	public static String toString(customer i) {
		return "\nid: " + i.customer_id + "\nName: " + i.customer_name + "\nemailid: " + i.customer_email
				+ "\nAddress: " + i.customer_address + "\nPhoneno: " + i.customer_phoneno;
	}

	public void get_activity() {
		System.out.println("These are the activities that you can perform in our webiste");
		System.out.println("First you need to login or register");
		System.out.println("After login :");
		System.out.println("1 . view products ");
		System.out.println("2 . Add to cart ");
		System.out.println("3 . Enter delivery address ");
		System.out.println("4 . proceed to payment  ");
		System.out.println("5 . make payment  ");
		System.out.println("6 . Then your order will be placed successfully \n");

	}

	public void page_info() {
		System.out.println("welcome to the customer page\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		customer temp = new customer();
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
					customer.register();
					break;
				case 2:
					customer.login();
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
