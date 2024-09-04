package Project;

import java.util.*;

public class admin {
	private int admin_id;
	private String admin_password;

	static Scanner in = new Scanner(System.in);

	admin() {
		this.admin_id = 100;
		this.admin_password = "admin";
	}

	static void login() {
		int valid;
		do {
			valid = 1;
			System.out.println("Enter Admin id: ");
			int Adminid = in.nextInt();
			System.out.println("Enter password: ");
			String AdminPassword = in.next();
			if (Adminid == 100 && AdminPassword.equals("admin")) {
				afterloginadmin();
			} else {
				System.out.println("Invalid");
				valid = 0;
			}
		} while (valid == 0);
	}

	static void afterloginadmin() {
		System.out.println("\nWelcome Admin \nChoose option");
		System.out.println("1.View Seller");
		System.out.println("2.Manage Products");
		System.out.println("3.Logout");
		int valid = 1;

		do {
			int choise = in.nextInt();
			switch (choise) {
			case 1:
				for (seller i : seller.seller_list) {
					System.out.println("Seller id:    " + i.get_seller_id());
					System.out.println("Seller Name:  " + i.get_seller_name());
					System.out.println("Seller Email: " + i.get_seller_email());
				}
				afterloginadmin();
				break;
			case 2:
				products.view_all_products();
				manage_products();
				break;
			case 3:
				main_menu.main(null);
				break;
			default:
				System.out.println("Invalid choice");
				valid = 0;
			}
		} while (valid == 0);
	}

	static void manage_products() {
		System.out.println("1.Edit Product");
		System.out.println("2.Delete Product");
		System.out.println("3.Back");
		int valid1;
		do {
			valid1 = 1;
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				edit_product();
				break;
			case 2:
				delete_product();
				break;
			case 3:
				afterloginadmin();
				break;
			default:
				System.out.print("Invalid Choice\n");
				valid1 = 0;
			}
		} while (valid1 == 0);
	}

	static void edit_product() {
		System.out.println("Enter Product id (numbers only): ");
		int id = in.nextInt();
		for (products i : products.products_list) {
			if (i.product_id == id) {
				products old = i;
				int valid;
				do {
					valid = 1;
					System.out.println(products.toString(i));
					System.out.println("\nEdit Product");
					System.out.println("1.Change Name");
					System.out.println("2.Change Price");
					System.out.println("3.Back");

					int choosec = in.nextInt();
					switch (choosec) {
					case 1:
						System.out.println("Enter new Name: ");
						String Name = in.next();
						products Newn = new products(i.product_id, Name, i.product_price, i.seller_id);
						products.products_list.add(Newn);
						System.out.println("Name changed successfully");
						break;
					case 2:
						System.out.println("Enter new Price: ");
						int Price = in.nextInt();
						products Newp = new products(i.product_id, i.product_name, Price, i.seller_id);
						products.products_list.add(Newp);
						System.out.println("Price changed successfully");
						break;
					case 3:
						products.main(null);
						break;
					default:
						System.out.println("Invalid Option");
						valid = 0;
					}
				} while (valid == 0);

				products.products_list.remove(old);
				afterloginadmin();
			}
		}
	}

	static void delete_product() {
		System.out.println("Enter Product id (numbers only): ");
		int id = in.nextInt();
		for (products i : products.products_list) {
			if (i.product_id == id) {
				System.out.println(products.toString(i));
				System.out.println("Do you want to delete this Product (y/n):");
				String choice = in.next();
				if (choice.equals("y")) {
					products.products_list.remove(i);
					System.out.println("Product deleted Successfully");
					afterloginadmin();
				} else {
					afterloginadmin();
				}
			} else {
				System.out.println("Product not found");
				afterloginadmin();
			}
		}
	}

	public static void main(String[] args) {
		admin.login();
	}

}
