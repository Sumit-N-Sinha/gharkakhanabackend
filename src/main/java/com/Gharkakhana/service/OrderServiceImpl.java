package com.Gharkakhana.service;

import com.Gharkakhana.dto.Order1DTO;
import com.Gharkakhana.entity.FoodItems;
import com.Gharkakhana.entity.Order1;
import com.Gharkakhana.exception.OrderNotFoundException;
import com.Gharkakhana.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gharkakhana.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public void createOrder(Order1DTO order1DTO) {
		Order1 order2 = new Order1();
		order2.setTotalprice(order1DTO.getFoodItemsDTO().getPrice()*order1DTO.getFoodItemsDTO().getQuantity());
		order2.setDate(order1DTO.getDate());
		order2.setCustomerId(order1DTO.getCustomerId());

		FoodItems items = new FoodItems();
		items.setName(order1DTO.getFoodItemsDTO().getName());
		items.setPrice(order1DTO.getFoodItemsDTO().getPrice());
		items.setQuantity(order1DTO.getFoodItemsDTO().getQuantity());
		items.setImage(order1DTO.getFoodItemsDTO().getImage());
		order2.setFoodItems(items);
		orderRepository.save(order2);
	}

	@Override
	public void cancelOrder(int orderId) {
		Optional<Order1> optional = orderRepository.findById(orderId);
		if(optional.isPresent()) {
			orderRepository.deleteById(orderId);
		}
		else {
			throw new OrderNotFoundException("No oder to cancel with id: " + orderId);
		}


	}
	public List<Order1> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(int orderId) {
		Optional<Order1> optional = orderRepository.findById(orderId);
		if(optional.isPresent()) {
			orderRepository.deleteById(orderId);
		}
		else {
			throw new OrderNotFoundException("No oder to delete with id: " + orderId);
		}
	}

	@Override
	public void updateOrder(Order1DTO orderDTO, int id) {
		Optional<Order1> optional = orderRepository.findById(id);
		if (optional.isPresent()) {
			Order1 order1 = optional.get();
			order1.setTotalprice(orderDTO.getTotalprice());
			order1.setDate(orderDTO.getDate());
			order1.setCustomerId(orderDTO.getCustomerId());
			orderRepository.save(order1);
		}
		else {
			throw new OrderNotFoundException("No order to update with id: " + id);
		}

	}

	@Override
	public Order1 viewOrder(int oid) {
		Optional<Order1> optionalOrder = orderRepository.findById(oid);
		if (optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		else {
			throw new OrderNotFoundException("No order found with id:" + oid);
		}
	}

}
