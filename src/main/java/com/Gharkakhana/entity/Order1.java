package com.Gharkakhana.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private double totalprice;
	private LocalDate date;
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodId", unique = false)
	private FoodItems foodItems;

	public Order1() {

	}

	public Order1(int orderId, double totalprice, LocalDate date, int id, FoodItems foodItems) {
		this.orderId = orderId;
		this.totalprice = totalprice;
		this.date = date;
		this.id=id;
		this.foodItems = foodItems;
	}

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
	public FoodItems getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(FoodItems foodItems) {
		this.foodItems = foodItems;
	}
}
