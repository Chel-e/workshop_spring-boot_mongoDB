package com.chele.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.chele.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ // o MongoRepository ja tem toda as funçoes CRUD que p´recisamos, prescisamos colocar o tipo da classe de dominio e o tipo do seu id 
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> findByTitle(String text);
    
    List<Post> findByTitleContainingIgnoreCase(String text);
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDateDate, Date maxDate);
}
