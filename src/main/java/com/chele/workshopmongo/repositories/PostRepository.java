package com.chele.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chele.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ // o MongoRepository ja tem toda as funçoes CRUD que p´recisamos, prescisamos colocar o tipo da classe de dominio e o tipo do seu id 
    List<Post> findByTitleContainingIgnoreCase(String text);
}
