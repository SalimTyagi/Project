package com.nisar.resturant.listing.controller;

import com.nisar.resturant.listing.dao.RestaurantDTO;
import com.nisar.resturant.listing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/fetchAll")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> allRestaurant = restaurantService.findAllRestaurant();
        return new ResponseEntity<>(allRestaurant, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
       RestaurantDTO restaurant= restaurantService.addRestaurant(restaurantDTO);
       return new ResponseEntity<>(restaurant,HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RestaurantDTO> getById(@PathVariable Integer id){
        return restaurantService.findRestaurantById(id);
    }


}
