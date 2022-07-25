package com.Gharkakhana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Gharkakhana.entity.FoodItems;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItems, Integer>{
    @Query(value="select * from food_items f where f.food_name=name",nativeQuery = true)
    List<FoodItems> findByFoodName(@Param("name") String name);


}
