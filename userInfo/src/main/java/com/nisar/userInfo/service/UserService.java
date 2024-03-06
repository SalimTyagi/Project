package com.nisar.userInfo.service;

import com.nisar.userInfo.dao.UserDto;
import com.nisar.userInfo.entity.User;
import com.nisar.userInfo.mapper.UserMapper;
import com.nisar.userInfo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> fetchAllUser() {
        List<User> userList= userRepository.findAll();
        return userList.stream()
                .map(UserMapper.INSTANCE::getUserDtoFromUser).toList();
    }

    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.getUserFromUserDto(userDto);
        userRepository.save(user);
        return UserMapper.INSTANCE.getUserDtoFromUser(user);
    }

    public ResponseEntity<UserDto> fetchUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            UserDto userDto= UserMapper.INSTANCE.getUserDtoFromUser(user.get());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
