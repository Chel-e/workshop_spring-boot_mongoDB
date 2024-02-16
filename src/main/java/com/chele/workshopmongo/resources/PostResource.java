package com.chele.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chele.workshopmongo.domain.Post;
import com.chele.workshopmongo.services.PostServvice;

@RestController
@RequestMapping(value = "posts")
public class PostResource {
    @Autowired
    private PostServvice postServvice;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post>findById(@PathVariable String id) {
        return ResponseEntity.ok().body(postServvice.findById(id));
    }
}
