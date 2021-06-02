package com.example.labadminservice.service;

import com.example.labadminservice.entity.User;
import com.example.labadminservice.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;

    public void insertUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.insert(user);
    }
}
