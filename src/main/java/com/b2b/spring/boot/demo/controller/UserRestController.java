package com.b2b.spring.boot.demo.controller;

import com.b2b.spring.boot.demo.DTO.NuovoUser;
import com.b2b.spring.boot.demo.controller.api.UserAPI;
import com.b2b.spring.boot.demo.entity.User;
import com.b2b.spring.boot.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserRestController implements UserAPI {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<List<NuovoUser>> getAllUsers(HttpServletRequest request) {
        return new ResponseEntity<List<NuovoUser>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> insert(HttpServletRequest request, NuovoUser oUser) {
        userService.insert(oUser);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(HttpServletRequest request, NuovoUser oUser, Long id) {
        if(id!=null)
        {
            userService.update(oUser,id);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> delete(HttpServletRequest request, Long id) {
        userService.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
