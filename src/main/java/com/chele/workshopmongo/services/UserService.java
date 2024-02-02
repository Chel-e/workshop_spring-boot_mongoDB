package com.chele.workshopmongo.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chele.workshopmongo.domain.User;
import com.chele.workshopmongo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll () {
        return userRepository.findAll();
    }
}
