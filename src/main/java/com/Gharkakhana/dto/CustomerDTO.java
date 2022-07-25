package com.Gharkakhana.dto;


import javax.validation.constraints.*;

public class CustomerDTO {
	private int id;
	@Pattern(regexp="^[A-Za-z]*$",message = "Name must contain only  alphabet")
	@Size(min=3,message="Name should be more then 2 letters")
	@Size(max=10,message="Name can not be more than 10 letters")
	@NotBlank(message="Name can not be Blank")
	private String name;
	@NotBlank(message="Email  can not  be Blank")
	@Email(message="Please provide a valid email address")
	private String email;
	@NotBlank
	@Size(min=3, message = "Adress should be more than 2 letters")
	private String address;
	@Min(value = 10, message = "Phone must contain 10 digits")
	@Max(value = 10, message = "Phone must contain 10 digits")
	private long phone;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	

}
