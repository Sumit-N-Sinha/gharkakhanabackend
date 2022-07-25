package com.Gharkakhana.Controller;

import com.Gharkakhana.entity.Customer;
import com.Gharkakhana.entity.FoodItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Gharkakhana.dto.CustomerDTO;
import com.Gharkakhana.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createACustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		customerService.createCustomer(customerDTO);
		return new ResponseEntity<>("Customer created", HttpStatus.OK);
	}
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {
		return customerService.getAllCustomers();
	}
	@GetMapping("/get/{cid}")
	public ResponseEntity<Customer> fetchCustomerById(@PathVariable int cid) {
		Customer customer = customerService.getCustomerById(cid);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	@PutMapping("/update/{cid}")
	public ResponseEntity<String> updateACustomer(@RequestBody CustomerDTO customerDTO, @PathVariable int cid) {
		customerService.updateCustomer(customerDTO, cid);
		return new ResponseEntity<>("customer with given id updated successfully", HttpStatus.OK);
	}
	@GetMapping("/price/asc")
	public List<FoodItems> priceInAsc() {
		return customerService.getPriceAsc();
	}
	@GetMapping("/price/desc")
	public List<FoodItems> priceInDesc() {
		return customerService.getPriceDsc();
	}
	@GetMapping("/food")
	public List<FoodItems> findByyFood() {
		return customerService.getByFood();
	}
	@GetMapping("/{name}")
	public List<FoodItems> findFoodByName(@PathVariable("name") String name) {
		return customerService.findByFood(name);
	}

}
