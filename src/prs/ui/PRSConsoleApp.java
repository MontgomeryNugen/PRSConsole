package prs.ui;

import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.business.ProductDB;
import prs.util.Console;

public class PRSConsoleApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the PRS Console App - JDBC\n");
		ProductDB pdb = new ProductDB();
		String command = "";
		while (!command.equals("99")) {
			displayMenu();
			command = Console.getString("Enter Command: ");
			if (command.equals("1")) {
				List<Product> products = pdb.getAll();
				for (Product p : products) {
					System.out.println(p);
				}
				System.out.println();

			} else if (command.equals("2")) {
				String criteria = Console.getString("Search by (I)tem  or (V)endor?", "i", "v");
				if (criteria.equalsIgnoreCase("i")) {
					int pid = Console.getInt("Enter Item Number: ");
					Product product = pdb.getProduct(pid);
					System.out.println(product);
				} else if (criteria.equalsIgnoreCase("v")) {
//					int vendorID = Console.getInt("Enter Vendor Number: ");
//					Product product = pdb.getVendor(vendorID);
//					System.out.println(product);
				}

				System.out.println();

			} else if (command.equals("3")) {
				int vid = Console.getInt("Enter Vendor ID: ");
				String partNum = Console.getString("Enter Part Number: ");
				String name = Console.getString("Enter Part Name: ");
				double price = Console.getInt("Enter Part Price: ");
				Product product = new Product(vid, partNum, name, price);

				if (pdb.add(product)) {
					System.out.println("Product added successfully.");
				} else {
					System.out.println("Error adding product.");
				}
			} else if (command.equals("4")) {
				int pid = Console.getInt("Enter Product ID: ");
				String newName = Console.getString("Enter New Name: ");
				Product product = new Product(vid, partNum, name, price);

				if (pdb.add(product)) {
					System.out.println("Product updated successfully.");
				} else {
					System.out.println("Error updating product.");
				}
			} else if (command.equals("5")) {
				int pid = Console.getInt("Enter Product ID: ");
				String newName = Console.getString("Enter New Name: ");
				Product product = new Product(vid, partNum, name, price);

				if (pdb.add(product)) {
					System.out.println("Product deleted successfully.");
				} else {
					System.out.println("Error deleting product.");
				}
				System.out.println();

			}
			System.out.println("Goodbye!");
		}
	}

	private static void displayMenu() {
		StringBuilder sb = new StringBuilder("Command Menu: \n");
		sb.append("1 - List All Products\n");
		sb.append("2 - Get a Product or Vendor\n");
		sb.append("3 - Add a Product\n");
		sb.append("4 - Update a Product\n");
		sb.append("5 - Remove a Product\n");
		sb.append("99 - Exit\n");
		System.out.println(sb.toString());
	}
}
