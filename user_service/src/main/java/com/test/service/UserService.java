package com.test.service;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserService {
    User gerUserById(int uid);
}
