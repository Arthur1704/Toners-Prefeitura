package com.prefeitura.tonerspref.Model.DataBase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.prefeitura.tonerspref.Model.DataBase.repositories.UserRepository;
import com.prefeitura.tonerspref.Model.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insert(User user) {
        try{
        userRepository.save(user);
        } catch (DataAccessException e){
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try{
        userRepository.save(user);
        } catch (DataAccessException e){
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try{
        userRepository.deleteById(id);
        } catch (DataAccessException e){
            e.printStackTrace();
        }
    }

    public User findById(Long id) {
        try{
        return userRepository.findById(id).orElse(null);
        } catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAll() {
        try{
        return userRepository.findAll();
        } catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean validateLogin(String name, String password) {
        try{
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
        } catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }
    }



}
