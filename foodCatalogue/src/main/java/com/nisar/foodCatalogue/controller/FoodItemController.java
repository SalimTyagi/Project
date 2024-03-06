package com.nisar.foodCatalogue.controller;

import com.nisar.foodCatalogue.dao.FoodCataloguePage;
import com.nisar.foodCatalogue.dao.FoodItemDto;
import com.nisar.foodCatalogue.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto addedFoodItem = foodItemService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(addedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantWithFoodItemList(@PathVariable Integer id){
        FoodCataloguePage foodCataloguePage = foodItemService.fetchRestaurantWithFoodItemList(id);
        return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
    }
}
