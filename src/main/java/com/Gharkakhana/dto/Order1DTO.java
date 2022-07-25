package com.Gharkakhana.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class Order1DTO {
	private int orderId;
	private double totalprice;
	@PastOrPresent(message = "Date cant be in future")
	@NotNull(message = "Date cant be null")
	private LocalDate date;
	private int id;
	@Valid
	private FoodItemsDTO foodItemsDTO;


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getCustomerId() {
		return id;
	}

	public void setCustomerId(int id) {
		this.id = id;
	}
	public FoodItemsDTO getFoodItemsDTO() {
		return foodItemsDTO;
	}

	public void setFoodItemsDTO(FoodItemsDTO foodItemsDTO) {
		this.foodItemsDTO = foodItemsDTO;
	}

	@Override
	public String toString() {
		return "Order1DTO{" +
				"orderId=" + orderId +
				", totalprice=" + totalprice +
				", date=" + date +
				", id=" + id +
				", foodItemsDTO=" + foodItemsDTO +

				'}';
	}
}
