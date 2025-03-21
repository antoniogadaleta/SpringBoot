package com.b2b.spring.boot.demo.service;

import com.b2b.spring.boot.demo.DTO.NuovoUser;
import com.b2b.spring.boot.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    public List<NuovoUser> getAllUsers();

    public NuovoUser getUserById(Long id);

    public void insert(NuovoUser oUser);

    public NuovoUser update(NuovoUser oUser, Long id);

    public void deleteById(Long id);

}
