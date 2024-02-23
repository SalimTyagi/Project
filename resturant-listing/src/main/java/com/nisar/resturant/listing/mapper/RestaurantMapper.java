package com.nisar.resturant.listing.mapper;

import com.nisar.resturant.listing.dao.RestaurantDTO;
import com.nisar.resturant.listing.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    Restaurant mapRestaurantDtoToRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO mapRestaurantToRestaurantDto(Restaurant restaurant);
}
