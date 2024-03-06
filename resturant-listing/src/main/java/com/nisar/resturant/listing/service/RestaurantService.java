package com.nisar.resturant.listing.service;

import com.nisar.resturant.listing.dao.RestaurantDTO;
import com.nisar.resturant.listing.entity.Restaurant;
import com.nisar.resturant.listing.mapper.RestaurantMapper;
import com.nisar.resturant.listing.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDTO);
        restaurantRepo.save(restaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant);
    }

    public ResponseEntity<RestaurantDTO> findRestaurantById(Integer id) {
         Optional<Restaurant> restaurant= restaurantRepo.findById(id);
         if(restaurant.isPresent()){
             RestaurantDTO restaurantDTO= RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get());
             return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
         }
         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
