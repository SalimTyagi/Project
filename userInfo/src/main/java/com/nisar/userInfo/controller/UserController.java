package com.nisar.userInfo.controller;

import com.nisar.userInfo.dao.UserDto;
import com.nisar.userInfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    private ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> userDtoList= userService.fetchAllUser();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    private ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto userDtoResponse = userService.saveUser(userDto);
        return new ResponseEntity<>(userDtoResponse,HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    private ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        return userService.fetchUserById(id);
    }
}
