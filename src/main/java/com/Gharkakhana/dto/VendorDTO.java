package com.Gharkakhana.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class VendorDTO {
	private int vendorId;
	@Pattern(regexp="^[A-Za-z]*$",message = "Name must contain only  alphabet")
	@Size(min=3,message="Name should be more then 2 letters")
	@Size(max=10,message="Name can not be more than 10 letters")
	@NotBlank(message="Name can not be Blank")
	@NotNull(message = "Name cant be null")
	private String name;
	private String status;
	private int orderId;


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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "VendorDTO{" +
				"vendorId=" + vendorId +
				", name='" + name + '\'' +
				", status='" + status + '\'' +
				", orderId='" + orderId + '\'' +
				'}';
	}
}
