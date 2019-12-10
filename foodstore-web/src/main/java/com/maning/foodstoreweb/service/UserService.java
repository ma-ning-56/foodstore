package com.maning.foodstoreweb.service;

import com.maning.foodstoreweb.model.entities.User;

public interface UserService {
    /**
     * 查询user是否存在且正确
     */
    User queryUserCfg(String username);
}
