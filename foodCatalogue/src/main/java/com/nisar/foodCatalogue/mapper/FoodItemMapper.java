package com.nisar.foodCatalogue.mapper;

import com.nisar.foodCatalogue.dao.FoodItemDto;
import com.nisar.foodCatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);
    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
}
