package com.nisar.userInfo.mapper;

import com.nisar.userInfo.dao.UserDto;
import com.nisar.userInfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User getUserFromUserDto(UserDto userDto);
    UserDto getUserDtoFromUser(User user);
}
