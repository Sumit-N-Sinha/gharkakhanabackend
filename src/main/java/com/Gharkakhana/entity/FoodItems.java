package com.Gharkakhana.entity;

import javax.persistence.*;

@Entity
public class FoodItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;

	private String name;
	private double price;
	private int quantity;
	private String image;
	
	public FoodItems() {
		
	}
	
	public FoodItems(int foodId, String name, double price, int quantity, String image) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "FoodItems [foodId=" + foodId + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", image="
				+ image + "]";
	}
	
	
	

}
