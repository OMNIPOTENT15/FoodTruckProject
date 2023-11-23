package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	public String name;
	public String foodType;
	public int rating;

	public FoodTruck() {
	}

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public String toString() {
		return "FoodTruck [name=" + name + ", foodType=" + foodType + ", rating=" + rating + "]";
	}

	public void displayTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}