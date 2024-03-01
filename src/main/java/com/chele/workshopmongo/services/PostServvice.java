package com.chele.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chele.workshopmongo.domain.Post;
import com.chele.workshopmongo.repositories.PostRepository;
import com.chele.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostServvice {
    @Autowired
    private PostRepository postRepository;
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException());
    }
    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 *60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
