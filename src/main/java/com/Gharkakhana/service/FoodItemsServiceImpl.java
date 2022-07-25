package com.Gharkakhana.service;

import java.util.List;
import java.util.Optional;

import com.Gharkakhana.exception.FoodItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gharkakhana.dto.FoodItemsDTO;
import com.Gharkakhana.entity.FoodItems;
import com.Gharkakhana.repository.FoodItemRepository;
@Service
public class FoodItemsServiceImpl implements FoodItemsService {
	@Autowired
	private FoodItemRepository foodItemRepository;
	

	@Override
	public void addFoodItem(FoodItemsDTO foodItemsDTO) {
		FoodItems f = new FoodItems();
		f.setName(foodItemsDTO.getName());
		f.setPrice(foodItemsDTO.getPrice());
		f.setQuantity(foodItemsDTO.getQuantity());
		f.setImage(foodItemsDTO.getImage());
		
		foodItemRepository.save(f);
		
	}

	@Override
	public List<FoodItems> getAllFoodItems() {
		return foodItemRepository.findAll();
	}

	@Override
	public void deleteFoodItem(int foodId) {
		Optional<FoodItems> optional = foodItemRepository.findById(foodId);
		if(optional.isPresent()) {
			foodItemRepository.deleteById(foodId);
		}
		else{
			throw new FoodItemNotFoundException("No food to delete with id: " + foodId);
		}
		
	}

	@Override
	public void updateFoodItem(FoodItemsDTO foodItemsDTO, int foodId) {
		Optional<FoodItems> optionalFoodItems = foodItemRepository.findById(foodId);
		if(optionalFoodItems.isPresent()) {
			FoodItems items = optionalFoodItems.get();
			items.setName(foodItemsDTO.getName());
			items.setPrice(foodItemsDTO.getPrice());
			items.setQuantity(foodItemsDTO.getQuantity());
			items.setImage(foodItemsDTO.getImage());


			foodItemRepository.save(items);
		}
		else {
			throw new FoodItemNotFoundException("No food found to update with id:" + foodId);
		}
	}

	@Override
	public FoodItems getFoodById(int foodId) {
		Optional<FoodItems> fi = foodItemRepository.findById(foodId);
		if(fi.isPresent()) {
			return fi.get();
		}
		else {
			throw new FoodItemNotFoundException("No food found with id:" + foodId);
		}
	}

}
