package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {

	private FoodTruck[] fleet = new FoodTruck[5];

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {

		for (int i = 0; i < 5; i++) {

			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the name for food truck " + (i + 1) + ":");
			String n = sc.next();
			sc.nextLine();

			if (n.equals("quit") || n.equals("Quit") || n.equals("QUIT")) {
				break;

			} else {
				System.out.println("Please enter the type of food for your food truck: ");
				String food = sc.next();
				sc.nextLine();

				System.out.println("Please enter the rating for your foot truck from 1 to 10: ");
				int r = sc.nextInt();
				sc.nextLine();

				fleet[i] = new FoodTruck(n, food, r);
				fleet[i].displayTruck();
				System.out.println();
				System.out.println();
			}
		}
		getMenu();
	}

	public void getMenu() {

		Scanner sb = new Scanner(System.in);
		System.out.println("\t----------------------------------------------------\n"
				+ "\t\tWelcome to the FOOD TRUCK menu!\n\n\n" + "\tEnter (1) for the list of food truck names.\n\n"
				+ "\tEnter (2) for the average ratings of the food trucks.\n\n"
				+ "\tEnter (3) to display the highest rating food trucks.\n\n" + "\tEnter (4) to quit.\n\n"
				+ "\t----------------------------------------------------\n");
		int num = sb.nextInt();
		if (num <= 0 || num > 4) {
			System.err.println("Please select a valid menu option.");
			System.err.println();
			getMenu();
		} else {
			switch (num) {
			case 1:
				truckNames();
				getMenu();
				break;
			case 2:
				averageRating();
				getMenu();
				break;
			case 3:
				maxRating();
				getMenu();
				break;
			case 4:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}

	public void truckNames() {
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] == null) {
				getMenu();
			}
			System.out.println(fleet[i].getName());
		}
	}

	public void averageRating() {
		int total = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] == null) {
				getMenu();
			} else {
				total += fleet[i].getRating();

			}
		}
		System.out.println("The average rating is: " + (total / fleet.length));
	}

	public void maxRating() {
		int max = 0;
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] == null) {
				getMenu();
			} else if (fleet[i].getRating() > max) {
				max = fleet[i].getRating();
			}
		}
		System.out.println("The max rating is: " + max);

	}
}
