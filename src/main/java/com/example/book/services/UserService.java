package com.example.book.services;

import com.example.book.entity.User;
import com.example.book.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
