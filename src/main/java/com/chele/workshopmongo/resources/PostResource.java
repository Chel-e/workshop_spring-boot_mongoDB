package com.chele.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chele.workshopmongo.domain.Post;
import com.chele.workshopmongo.resources.util.URL;
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
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postServvice.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
        @RequestParam(value = "text", defaultValue = "") String text,
        @RequestParam(value = "minDate", defaultValue = "") String minDate,
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate
        ) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = postServvice.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
