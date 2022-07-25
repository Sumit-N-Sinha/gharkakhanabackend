package com.Gharkakhana.service;

import com.Gharkakhana.entity.FoodItems;
import com.Gharkakhana.exception.CustomerNotFoundException;
import com.Gharkakhana.exception.FoodItemNotFoundException;
import com.Gharkakhana.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gharkakhana.dto.CustomerDTO;
import com.Gharkakhana.entity.Customer;
import com.Gharkakhana.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private FoodItemRepository foodItemRepository;

	@Override
	public void createCustomer(CustomerDTO customerDTO) {
		Customer c = new Customer();
		c.setName(customerDTO.getName());
		c.setEmail(customerDTO.getEmail());
		c.setAddress(customerDTO.getAddress());
		c.setPhone(customerDTO.getPhone());

		
		customerRepository.save(c);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new CustomerNotFoundException("No customer found with id:" + id);
		}
	}

	@Override
	public void updateCustomer(CustomerDTO customerDTO, int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			Customer c = optional.get();
			c.setName(customerDTO.getName());
			c.setAddress(customerDTO.getAddress());
			c.setEmail(customerDTO.getEmail());
			c.setPhone(customerDTO.getPhone());
			customerRepository.save(c);
		}
		else {
			throw new CustomerNotFoundException("No customer to update with id:" + id);
		}

	}
	@Override
	public List<FoodItems> getPriceAsc() {
		List<FoodItems> food = foodItemRepository.findAll();
		List<FoodItems> foodDTOList  = food.stream().map(f->{
			FoodItems foodDTO = new FoodItems();
			foodDTO.setName(f.getName());
			foodDTO.setPrice(f.getPrice());
			foodDTO.setQuantity(f.getQuantity());
			return foodDTO;
		}).collect(Collectors.toList());

		List<FoodItems> fd = foodDTOList.stream().sorted(Comparator.comparing(FoodItems::getPrice)).collect(Collectors.toList());
		return fd;
	}

	@Override
	public List<FoodItems> getPriceDsc() {
		List<FoodItems> food = foodItemRepository.findAll();
		List<FoodItems> foodDTOList = new ArrayList<>();
		foodDTOList = food.stream().map(f->{
			FoodItems foodDTO = new FoodItems();
			foodDTO.setFoodId(f.getFoodId());
			foodDTO.setName(f.getName());
			foodDTO.setPrice(f.getPrice());
			foodDTO.setQuantity(f.getQuantity());
			foodDTO.setImage(f.getImage());
			return foodDTO;
		}).collect(Collectors.toList());

		List<FoodItems> fd = foodDTOList.stream().sorted(Comparator.comparing(FoodItems::getPrice).reversed()).collect(Collectors.toList());
		return fd;
	}
	@Override
	public List<FoodItems> getByFood() {
		List<FoodItems> foodList = new ArrayList<>();
		foodItemRepository.findAll().forEach(foodList::add);
		return foodList;

	}

	@Override
	public List<FoodItems> findByFood(String name) {
		List<FoodItems> foodItem= foodItemRepository.findByFoodName(name);
		if(!foodItem.isEmpty())
			foodItemRepository.findByFoodName(name);
		else
			throw new FoodItemNotFoundException("Search Operation failed \n No food Found with id: "+name);
		return foodItem;

	}



}
