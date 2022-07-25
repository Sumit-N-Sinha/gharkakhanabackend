package com.Gharkakhana.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FoodItemsDTO {
	private int foodId;
	@Pattern(regexp="^[A-Za-z]*$",message = "Name must contain only  alphabet")
	@Size(min=3,message="Name should be more then 2 letters")
	@Size(max=10,message="Name can not be more than 10 letters")
	@NotBlank(message="Name can not be Blank")
	private String name;
	private double price;
	private int quantity;
	private String image;


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
		return "FoodItemsDTO{" +
				"foodId=" + foodId +
				", name='" + name + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				", image='" + image + '\'' +
				'}';
	}
}
