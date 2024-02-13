package com.chele.workshopmongo.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chele.workshopmongo.domain.User;
import com.chele.workshopmongo.dto.UserDTO;
import com.chele.workshopmongo.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> result = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(new UserDTO(userService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok().body("Deleted User");
    }
    
}
