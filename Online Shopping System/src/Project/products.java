package Project;

import java.util.*;

public class products {

	public int product_id, product_price, seller_id;
	public String product_name;

	static ArrayList<products> products_list = new ArrayList<products>();
	static Scanner in = new Scanner(System.in);

	products(int id, String Name, int price, int seller) {
		this.product_id = id;
		this.product_name = Name;
		this.product_price = price;
		this.seller_id = seller;
	}

	static void add_product() {
		System.out.println("Enter Product id (numbers only): ");
		int id = in.nextInt();
		System.out.println("Enter Name: ");
		String Name = in.next();
		System.out.println("Enter Price: ");
		int price = in.nextInt();
		System.out.println("Enter your Seller ID: ");
		int seller = in.nextInt();

		products New = new products(id, Name, price, seller);
		products_list.add(New);
		System.out.print("Product Added Successfully\n");
		products.main(null);
	}

	static void edit_product() {
		System.out.println("Enter Product id (numbers only): ");
		int id = in.nextInt();
		for (products i : products_list) {
			if (i.product_id == id) {
				products old = i;
				int valid;
				do {
					valid = 1;
					System.out.println(toString(i));
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
						products_list.add(Newn);
						System.out.println("Name changed successfully");
						break;
					case 2:
						System.out.println("Enter new Price: ");
						int Price = in.nextInt();
						products Newp = new products(i.product_id, i.product_name, Price, i.seller_id);
						products_list.add(Newp);
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

				products_list.remove(old);
				products.main(null);
			}
		}
	}

	static void delete_product() {
		System.out.println("Enter Product id (numbers only): ");
		int id = in.nextInt();
		for (products i : products_list) {
			if (i.product_id == id) {
				System.out.println(toString(i));
				System.out.println("Do you want to delete this Product (y/n):");
				String choice = in.next();
				if (choice.equals("y")) {
					products_list.remove(i);
					System.out.println("Product deleted Successfully");
					products.main(null);
				} else {
					products.main(null);
				}
			} else {
				System.out.println("Product not found");
				products.main(null);
			}
		}
	}

	static void view_all_products() {
		for (products i : products_list) {
			System.out.println("Product ID: " + i.product_id);
			System.out.println("Product Name: " + i.product_name);
			System.out.println("Product Price: " + i.product_price);
		}
	}

	static void view_your_products(int sellerid) {
		for (products i : products_list) {
			if (i.seller_id == sellerid) {
				System.out.println("Product ID: " + i.product_id);
				System.out.println("Product Name: " + i.product_name);
				System.out.println("Product Price: " + i.product_price);
				seller.afterlogin(sellerid);
			} else {
				System.out.println("No Products Found");
				seller.afterlogin(sellerid);
			}

		}
	}

	public static String toString(products i) {
		return "\nid: " + i.product_id + "\nName: " + i.product_name + "\nPrice: " + i.product_price;
	}

	public String get_product_name() {
		return product_name;
	}

	public void set_product_name(String itemName) {
		product_name = itemName;
	}

	public int get_product_id() {
		return product_id;
	}

	public void set_product_id(int itemid) {
		product_id = itemid;
	}

	public float get_product_price() {
		return product_price;
	}

	public void setItemPrice(int itemprice) {
		product_price = itemprice;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.Add Product");
		System.out.println("2.Edit Product");
		System.out.println("3.Delete Product");
		System.out.println("4.Back");
		int valid;
		try {
			do {
				valid = 1;
				int choice = in.nextInt();
				switch (choice) {
				case 1:
					products.add_product();
					break;
				case 2:
					products.edit_product();
					break;
				case 3:
					products.delete_product();
					break;
				case 4:
					seller.main(null);
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
