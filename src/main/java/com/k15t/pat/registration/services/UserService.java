package com.k15t.pat.registration.services;

import com.k15t.pat.registration.exceptions.ApiException;
import com.k15t.pat.registration.mappers.UserMapper;
import com.k15t.pat.registration.models.User;
import com.k15t.pat.registration.utils.MessageCode;
import io.swagger.model.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userDetailsDto
     * map userDetailsDto to actual User object using map Struct library
     */
    public void registerUser(UserDetails userDetailsDto){
        if (userMapper.mapFromUserDetailsDtoToUser(userDetailsDto) == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, MessageCode.FAILED_TO_DESERIALIZE_REQUEST_BODY);
        }
        User newUSer =  userMapper.mapFromUserDetailsDtoToUser(userDetailsDto);
    }

}

