package com.Gharkakhana.service;

import java.util.List;

import com.Gharkakhana.dto.FoodItemsDTO;
import com.Gharkakhana.entity.FoodItems;

public interface FoodItemsService {
	public void addFoodItem(FoodItemsDTO foodItemsDTO);
	public List<FoodItems> getAllFoodItems();
	public void deleteFoodItem(int foodId);
	public void updateFoodItem(FoodItemsDTO foodItemsDTO, int foodId);
	public FoodItems getFoodById(int foodId);
}
