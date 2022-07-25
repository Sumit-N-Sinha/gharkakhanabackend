package com.Gharkakhana.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vendorId;
	private String name;
	private String status;
	private int orderId;
	public Vendor() {

	}

	public Vendor(int vendorId, String name, String status, int orderId) {
		this.vendorId = vendorId;
		this.name = name;
		this.status = status;
		this.orderId = orderId;
	}

	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Vendor{" +
				"vendorId=" + vendorId +
				", name='" + name + '\'' +
				", status='" + status + '\'' +
				", orderId='" + orderId + '\'' +
				'}';
	}
}
