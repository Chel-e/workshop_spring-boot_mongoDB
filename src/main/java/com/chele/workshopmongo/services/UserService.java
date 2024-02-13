package com.chele.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chele.workshopmongo.domain.User;
import com.chele.workshopmongo.dto.UserDTO;
import com.chele.workshopmongo.repositories.UserRepository;
import com.chele.workshopmongo.services.exceptions.ObjectNotFoundException;
    

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        if (id == null) {
            throw new ObjectNotFoundException();
        }
        Optional<User> obj = userRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new ObjectNotFoundException();
        }
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO UserDTO) {
        return new User(UserDTO.getId(), UserDTO.getName(), UserDTO.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);

    }
}
