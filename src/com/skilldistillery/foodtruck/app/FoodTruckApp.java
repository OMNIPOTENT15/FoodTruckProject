package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;

import java.util.Scanner;

public class FoodTruckApp {

	private FoodTruck[] fleet = new FoodTruck[5];

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {

			System.out.println("Please enter the name for Food Truck " + (i + 1) + ":");
			String n = sc.next();
			sc.nextLine();

			if (n.equals("quit") || n.equals("Quit") || n.equals("QUIT")) {
				break;
			}

			System.out.println("Please enter the type of food for your food truck: ");
			String food = sc.next();
			sc.nextLine();

			System.out.println("Please enter the rating for your foot truck from 1 to 10: ");
			int r = sc.nextInt();
			sc.nextLine();
			if (r < 0 || r > 10) {
				System.err.println("Please enter an number from 0 to 10: ");
				run();
			}

			fleet[i] = new FoodTruck(n, food, r);
			fleet[i].displayTruck();
			System.out.println();
			System.out.println();
		}
		getMenu();
		sc.close();

	}

	public void getMenu() {

		Scanner sb = new Scanner(System.in);
		System.out.println("\t----------------------------------------------------\n"
				+ "\t\tWelcome to the FOOD TRUCK menu!\n\n\n" + "\tEnter (1) for the list of food truck names.\n\n"
				+ "\tEnter (2) for the average ratings of the food trucks.\n\n"
				+ "\tEnter (3) to display the highest rating food trucks.\n\n" + "\tEnter (4) to quit.\n\n"
				+ "\t----------------------------------------------------\n");
		int num = sb.nextInt();
		if (num > 0 && num < 5) {
			switch (num) {
			case 1:
				System.out.println(truckNames());
				getMenu();
			case 2:
				System.out.println(averageRating());
				getMenu();

			case 3:
				System.out.println(maxRating());
				getMenu();

			case 4:
				System.out.println("Goodbye!");
				System.exit(0);
				break;

			default:
				getMenu();
			}
		} else {
			System.err.println("Please select a valid menu option.");
			System.err.println();
			getMenu();
		}

	}

	public String truckNames() {
		String tn = "";
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				String truck = "Food Truck " + (i + 1) + ": " + fleet[i].getName() + "\n";
				tn += truck;
			} else if (fleet[i] == null) {
				break;
			}
		}
		return tn;
	}

	public int averageRating() {

		int divisor = 0;
		int total = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				total += fleet[i].getRating();
				divisor = fleet.length;
			}
			if (fleet[i] == null) {
				divisor = i;
				return (total / divisor);
			}
		}
		return (total / divisor);
	}

	public String maxRating() {
		String maxTruck = "";
		int max = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				if (fleet[i].getRating() > max) {
					max = fleet[i].getRating();
					maxTruck = fleet[i].toString();
				}
			} else if (fleet[i] == null) {
				if (fleet[i - 1].getRating() > max) {
					max = fleet[i - 1].getRating();
					maxTruck = fleet[i - 1].toString();
				}
				break;
			} else {
				getMenu();

			}

		}
		return maxTruck;

	}
}
