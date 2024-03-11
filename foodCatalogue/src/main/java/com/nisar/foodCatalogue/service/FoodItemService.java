package com.nisar.foodCatalogue.service;

import com.nisar.foodCatalogue.dao.FoodCataloguePage;
import com.nisar.foodCatalogue.dao.FoodItemDto;
import com.nisar.foodCatalogue.dao.Restaurant;
import com.nisar.foodCatalogue.entity.FoodItem;
import com.nisar.foodCatalogue.mapper.FoodItemMapper;
import com.nisar.foodCatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepo foodItemRepo;
    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem = FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto);
        foodItemRepo.save(foodItem);
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem);
    }

    public FoodCataloguePage fetchRestaurantWithFoodItemList(Integer restaurantId) {
        List<FoodItem> foodItemList= fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantById(restaurantId);
        return createFoodCataloguePage(foodItemList,restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantById(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/getById/"+restaurantId,Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {

        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
