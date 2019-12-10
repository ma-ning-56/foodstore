package com.maning.foodstoreweb.web;

import com.maning.foodstoreweb.dto.auto.UserMapper;
import com.maning.foodstoreweb.model.entities.User;
import com.maning.foodstoreweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/archive")
public class FoodstoreController {
    @Autowired
    private UserService userService;

    @PostMapping("/queryUserCfg")
    public User queryUserCfg(@RequestBody String username){
        return userService.queryUserCfg(username);
    }


}
