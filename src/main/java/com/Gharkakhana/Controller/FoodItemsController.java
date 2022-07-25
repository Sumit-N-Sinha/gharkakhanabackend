package com.Gharkakhana.Controller;

import com.Gharkakhana.dto.FoodItemsDTO;
import com.Gharkakhana.entity.FoodItems;
import com.Gharkakhana.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vendor")
public class FoodItemsController {
    @Autowired
    private FoodItemsService foodItemsService;

    @PostMapping("/create")
    public ResponseEntity<String> createAFood(@Valid @RequestBody FoodItemsDTO foodItemsDTO) {
        foodItemsService.addFoodItem(foodItemsDTO);
        return new ResponseEntity<>("Food Item Added Successfully", HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<FoodItems> fetchAllItems() {
        return foodItemsService.getAllFoodItems();
    }
    @GetMapping("/get/{fid}")
    public ResponseEntity<FoodItems> fetchFoodById(@PathVariable int fid) {
        FoodItems foodItems = foodItemsService.getFoodById(fid);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }
    @PutMapping("update/{fid}")
    public ResponseEntity<String> updateAFood(@RequestBody FoodItemsDTO foodItemsDTO, @PathVariable int fid) {
        foodItemsService.updateFoodItem(foodItemsDTO, fid);
        return new ResponseEntity<>("Food with id " + fid + "updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("delete/{fid}")
    public ResponseEntity<String> deleteAFood(@PathVariable int fid) {
        foodItemsService.deleteFoodItem(fid);
        return new ResponseEntity<>("Food with id " + fid + "deleted successfully", HttpStatus.OK);
    }
}

