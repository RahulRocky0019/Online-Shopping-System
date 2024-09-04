package Project;

import java.util.*;

public class check_out {

	private static String Address, Housenum, State, District;
	private static long Phoneno;
	private static int Pincode;

	static Scanner in = new Scanner(System.in);

	static void Details() {
		System.out.println("The delivery details for your order: ");
		System.out.println("Enter Delivery Address: ");
		Address = in.next();
		System.out.println("Enter House number: ");
		Housenum = in.next();
		System.out.println("Enter State:");
		State = in.next();
		System.out.println("Enter District:");
		District = in.next();
		System.out.println("Enter Phoneno: ");
		Phoneno = in.nextLong();
		System.out.println("Enter Pincode: ");
		Pincode = in.nextInt();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--Mode of Payment--" + "\n" + "Choose the option:" + "\n" + "1. Debit /Credit /ATM cards"
				+ "\n" + "2. Cash on Delivery (COD)" + "\n" + "3.Back");

		int Choice = in.nextInt();
		switch (Choice) {
		// Cards
		case 1:
			check_out.Details();
			System.out.print("Enter the name of the card holder:");
			String CardName = in.next();
			System.out.print("Enter the card number:");
			long CardNo = in.nextLong();
			System.out.println("Enter CVV (the three digit number printed on the back of the card):");
			int cvv = in.nextInt();
			System.out.print("Enter the expiry DD/MM/YYYY");
			int ExpDate = in.nextInt();
			System.out.println("Verify you delivery details");
			System.out.println(Address + "\n" + Housenum + "\n" + State + "\n" + District + "\n" + Phoneno + "\n"
					+ Pincode + "\n");
			System.out.println(CardName + "\n" + CardNo + "\n" + cvv + "\n" + ExpDate);
			System.out.println("1. To continue payment" + "\n" + "2. To stop payment" + "\n");
			int cardchoice = in.nextInt();
			if (cardchoice == 1) {
				System.out.println("-----------Your order is success----------");
				
				System.out.println("Exiting from program..\nThankyou for using this shopping system!");
				System.exit(0);
			} else {
				System.out.println("-----------Your order is cancelled-----------");
				cart.PrintInvoice();
			}
			break;

		// Cash on Delivery
		case 2:
			check_out.Details();
			System.out.println("Verify you delivery details");
			System.out.println(
					Address + "\n" + Housenum + "\n" + State + "\n" + District + "\n" + Phoneno + "\n" + Pincode);
			System.out.println("\n" + "1. To continue the COD" + "\n" + "2. To stop the COD" + "\n");
			int codchoice = in.nextInt();
			if (codchoice == 1) {
				System.out.println("-----------Your order is success----------");
				
				System.out.println("Exiting from program..\nThankyou for using this shopping system!");
				System.exit(0);

			} else {
				System.out.println("-----------Your order is cancelled-----------");
				cart.PrintInvoice();
			}
			break;

		case 3:
			cart.PrintInvoice();
			break;
		}
	}

}
