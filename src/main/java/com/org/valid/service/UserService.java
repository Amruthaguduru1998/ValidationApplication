package com.org.valid.service;

import com.org.valid.dto.UserRequest;
import com.org.valid.entity.User;
import com.org.valid.exception.UserNotFoundException;
import com.org.valid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){
        User user=User.build(0,userRequest.getName(),userRequest.getEmail(),
                userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user= userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }
        else {
            throw new UserNotFoundException("user not found with id" +id);
        }
    }
}
