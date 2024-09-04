package Project;

import java.util.*;

public class cart {

	static ArrayList<products> cartItems = new ArrayList<products>();
	static Scanner in = new Scanner(System.in);
	static float total = 0;

	public static void AddToCart(products i) {
		cartItems.add(i);
	}

	public static void after_add_cart() {
		System.out.println("Do you want to continue or checkout? ");
		System.out.println("1.Checkout\n2.Log out");
		int schoice = in.nextInt();
		switch (schoice) {
		case 1:
			cart.PrintInvoice();
			break;
		case 2:
			customer.main(null);
			break;
		}
	}

	public static void RemoveItem(int id) {
		for (products i : cartItems) {
			if (i.get_product_id() == id) {
				float price = i.get_product_price();
				total -= price;
				cartItems.remove(i);
			} else {
				System.out.println("No such item in cart");
				cart.PrintInvoice();
			}
		}
		cart.PrintInvoice();
	}

	public static float TotalPrice() {
		total = 0;
		for (products i : cartItems) {
			float price = i.get_product_price();
			total += price;
		}
		return total;
	}

	public static void PrintInvoice() {
		System.out.println("-----BILL-----");
		for (products i : cartItems) {
			System.out.println(i.get_product_id());
			System.out.println(i.get_product_name());
			System.out.println(i.get_product_price());
		}
		System.out.println("Total Amount = " + TotalPrice());
		System.out.println("Do you want to continue to payment or remove items in cart?");
		System.out.println("1.Make Payment\n2.Edit Cart");
		int schoice2 = in.nextInt();
		switch (schoice2) {
		case 1:
			check_out.main(null);
			break;
		case 2:
			System.out.println("Enter id of the item to be removed");
			int idremove = in.nextInt();
			cart.RemoveItem(idremove);
			break;
		}
	}

}
