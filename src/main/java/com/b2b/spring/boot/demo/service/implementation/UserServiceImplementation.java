package com.b2b.spring.boot.demo.service.implementation;

import com.b2b.spring.boot.demo.DTO.ModificaUser;
import com.b2b.spring.boot.demo.DTO.NuovoUser;
import com.b2b.spring.boot.demo.DTO.UserRecord;
import com.b2b.spring.boot.demo.entity.User;
import com.b2b.spring.boot.demo.mapper.UserMapper;
import com.b2b.spring.boot.demo.repository.UserRepository;
import com.b2b.spring.boot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<NuovoUser> getAllUsers() {
        return (List<NuovoUser>)  userRepo.findAll();
    }

    @Override
    public NuovoUser getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void insert(NuovoUser oUser) {
        if(oUser.getId()==null)
            userRepo.save(oUser);
    }

    @Override
    public UserRecord update(ModificaUser oUser) {
        User oUser1=userRepo.findById(oUser.id()).orElseThrow();
        oUser1=userMapper.partialUpdate(oUser1,oUser);
        oUser1=userRepo.save(oUser1);

//        if(oUser.getNome()!=null) {
//            oUser1.setNome(oUser.getNome());
//        }
//        if(oUser.getDettaglio()!=null)
//            oUser1.setDettaglio(oUser.getDettaglio());
//        if(oUser.getEmail()!=null)
//            oUser1.setEmail(oUser.getEmail());
        return userMapper.toRecord(oUser1);

    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);

    }
}
