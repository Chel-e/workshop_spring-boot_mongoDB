package com.chele.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.chele.workshopmongo.domain.Post;
import com.chele.workshopmongo.domain.User;
import com.chele.workshopmongo.dto.AuthorDTO;
import com.chele.workshopmongo.repositories.PostRepository;
import com.chele.workshopmongo.repositories.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GTM"));
        postRepository.deleteAll();
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu Viagem", "Vou viajar para Sao Paulo, abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/03/2024"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1, post2));
        
    }
}
