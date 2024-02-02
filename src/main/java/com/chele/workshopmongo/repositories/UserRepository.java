package com.chele.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chele.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{ // o MongoRepository ja tem toda as funçoes CRUD que p´recisamos, prescisamos colocar o tipo da classe de dominio e o tipo do seu id 
    
}
