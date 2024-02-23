package com.nisar.resturant.listing.controller;

import com.nisar.resturant.listing.dao.RestaurantDTO;
import com.nisar.resturant.listing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> allRestaurant = restaurantService.findAllRestaurant();
        return new ResponseEntity<>(allRestaurant, HttpStatus.OK);
    }
}
