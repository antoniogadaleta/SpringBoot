package com.b2b.spring.boot.demo.controller.api;

import com.b2b.spring.boot.demo.DTO.NuovoUser;
import com.b2b.spring.boot.demo.DTO.UserRecord;
import com.b2b.spring.boot.demo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(path="/users")
@CrossOrigin(origins="http://localhost:8086")
public interface UserAPI {

    @GetMapping(path="/list", produces = "application/json")
    public ResponseEntity<ArrayList<UserRecord>> getAllUsers(HttpServletRequest request);

    @PostMapping(path="/nuovo", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> insert(HttpServletRequest request, @RequestBody NuovoUser oUser);

    @PutMapping(path="/{id}", produces="application/json", consumes="application/json")
    public ResponseEntity<?> update(HttpServletRequest request, @RequestBody NuovoUser oUser, @PathVariable Long id);

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable Long id);
}
