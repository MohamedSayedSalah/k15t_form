package com.k15t.pat.registration.controllers;


import com.k15t.pat.registration.services.UserService;
import io.swagger.api.UserRegistrationApi;
import io.swagger.model.UserDetails;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;
import java.util.concurrent.CompletableFuture;


@RestController
public class RegistrationController implements UserRegistrationApi {

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private UserService userService;

    @RequestMapping("/registration.html")
    public String registration() {

        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    }


    /**
     *
     * @param userDetails
     * map request body to Dto using swagger
     *
     *
     * @return 204
     */
    @RequestMapping(value="/register", method= RequestMethod.POST)
    @Override
    public CompletableFuture<ResponseEntity<Void>> register(@RequestBody UserDetails userDetails){
        userService.registerUser(userDetails);
       return  CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
