package com.Gharkakhana.service;


import com.Gharkakhana.dto.CustomerDTO;
import com.Gharkakhana.entity.Customer;
import com.Gharkakhana.entity.FoodItems;

import java.util.List;

public interface CustomerService {
	public void createCustomer(CustomerDTO customerDTO);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public void updateCustomer(CustomerDTO customerDTO, int id);
	public List<FoodItems> getByFood();
	public List<FoodItems> getPriceAsc();
	public List<FoodItems> getPriceDsc();
	public List<FoodItems> findByFood(String name);

}
