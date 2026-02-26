package com.nhanthanhle.research.identity_service.service;

import com.nhanthanhle.research.identity_service.dto.request.UserCreationRequest;
import com.nhanthanhle.research.identity_service.dto.request.UserUpdateRequest;
import com.nhanthanhle.research.identity_service.entity.User;
import com.nhanthanhle.research.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(UserCreationRequest request) {
        User newUser = new User();
        // handle trung ten
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User existed");
        }
        newUser.setDob(request.getDob());
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());

        return userRepository.save(newUser);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public User updateUser(Long id, UserUpdateRequest request) {

        User user = getUser(id);
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setDob(request.getDob());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
