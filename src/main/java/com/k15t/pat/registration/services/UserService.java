package com.k15t.pat.registration.services;

import com.k15t.pat.registration.mappers.UserMapper;
import com.k15t.pat.registration.models.User;
import io.swagger.model.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public void registerUser(UserDetails userDetailsDto){
      User newUSer =  userMapper.mapFromUserDetailsDtoToUser(userDetailsDto);
    }
}

