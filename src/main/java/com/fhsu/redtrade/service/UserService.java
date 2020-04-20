package com.fhsu.redtrade.service;

import com.fhsu.redtrade.entity.User;
import com.fhsu.redtrade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public User findById(String id) {

        return userRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public User createUser(User user) {
        //without id, then create
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        // with id, then update
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }
}
