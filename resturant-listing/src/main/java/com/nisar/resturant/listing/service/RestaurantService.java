package com.nisar.resturant.listing.service;

import com.nisar.resturant.listing.dao.RestaurantDTO;
import com.nisar.resturant.listing.entity.Restaurant;
import com.nisar.resturant.listing.mapper.RestaurantMapper;
import com.nisar.resturant.listing.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurant() {
        List<Restaurant> restaurantList= restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList= restaurantList.stream()
                .map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto)
                .toList();

        return restaurantDTOList;
    }
}
