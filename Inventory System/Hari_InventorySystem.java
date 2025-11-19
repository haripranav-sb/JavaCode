package InventoryManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Hari_InventorySystem {
	
	public static double roundTwoPlaces(double originalNumber) {
		double roundedNumber = Math.round(originalNumber * 100.0) / 100.0;
		return roundedNumber;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Product> inventory = new ArrayList<>();
		ArrayList<Product> cart = new ArrayList<>();

		try {
			Scanner fileScanner = new Scanner(new File("/Users/harip/eclipse-workspace/Lab12/src/inventory.csv"));
			
			//Skip header line
			if (fileScanner.hasNextLine()) {
				fileScanner.nextLine();
			}
			
			//Read each line
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] parts = line.split(",");
				
				Product currentProduct = new Product(parts[0], parts[1], parts[2], parts[3]);
				inventory.add(currentProduct);
			}
			
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found!");
		}
		
		//Print Inventory
		System.out.println("Welcome to the Inventory Management System!\n");
        System.out.println("Available Products:\n");
        for (int i = 0; i<inventory.size(); i++) {
        	System.out.println((i+1) + ". " + inventory.get(i).toString());
        }
        
        //Shopping Screen
        while (true) {
        	
        	//Validate SKU input
            System.out.print("\nEnter SKU to purchase (or 'done' to checkout): ");
            Scanner input = new Scanner(System.in);
            String SKUInput = input.nextLine().trim();

            if (SKUInput.equalsIgnoreCase("done")) {
            	break;
            }

            Product selected = null;
            int selectedIndex = -1;
            for (Product p : inventory) {
                if (p.getSKU().equalsIgnoreCase(SKUInput)) {
                    selected = p;
                    selectedIndex = inventory.indexOf(p);
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Invalid SKU! Please try again.");
                continue;
            }
            
            //Validate quantity input
            int quantity = -1;
            boolean validInput = false;
            
            while (!validInput) {
                try {
                    System.out.print("Enter quantity: ");
                    quantity = input.nextInt();
                    input.nextLine();

                    if (quantity <= 0) {
                        System.out.println("Please enter a positive number.");
                    } else if (quantity > selected.getQuantity()) {
                        System.out.println("Insufficient stock! Only " + selected.getQuantity() + " available.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    input.nextLine();
                }
            }
            
            //Update inventory and show the users action
            Product selectedItem = new Product(selected.getSKU(), quantity, selected.getPrice(), selected.getDescription());
            cart.add(selectedItem);
            inventory.set(selectedIndex, new Product(selected.getSKU(), inventory.get(selectedIndex).getQuantity()-quantity, selected.getPrice(), selected.getDescription()));
            System.out.println("Added to cart: " + quantity + "x " + selected.getDescription() + " @ $" + selected.getPrice() + " each");
            
        }
        
        //Display receipt
        System.out.println("\n================== RECEIPT ==================");
        double subtotal = 0;
        
        for(Product p: cart) {
        	double itemTotal = p.getPrice() * p.getQuantity();
        	subtotal += itemTotal;
        	System.out.println(p.getQuantity() + "x " + p.getDescription() + " $" + p.getPrice());
        }
        System.out.println();
        
        System.out.println("Subtotal: $" + roundTwoPlaces(subtotal));
        System.out.println("Sales Tax (7%): $" + roundTwoPlaces((subtotal*0.07)) + "\n");
        System.out.println("TOTAL: $" + roundTwoPlaces(((subtotal*0.07) + subtotal)));
        System.out.println("====================================");
        
        System.out.println("Inventory Updated Sucessfully");
        System.out.println("Thank you for shopping");
        
        //Update inventory file
        try {
        	PrintWriter writer = new PrintWriter(new FileOutputStream("/Users/harip/eclipse-workspace/Lab12/src/updated_inventory.csv"));
        	  
        	// Write header
        	writer.println("SKU,Quantity,Price,Description");

        	// Write data lines
        	for (Product p: inventory) {
        		writer.println(p.getSKU() + "," + p.getQuantity() + "," + p.getPrice() + "," + p.getDescription());
        	}
        	writer.close();
        } catch (FileNotFoundException e) {
        	System.out.println("Error: Cannot write to file!");
        }
	}
}

