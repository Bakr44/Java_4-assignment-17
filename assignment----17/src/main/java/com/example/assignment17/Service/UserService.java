package com.example.assignment17.Service;

import com.example.assignment17.Model.User;
import com.example.assignment17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private User user1;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user) {
       User user1=userRepository.getById(id);
       if (user1==null){
           return false;
       }
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());
        user1.setAge(user.getAge());
        userRepository.save(user1);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User user1=userRepository.getById(id);
        if (user1==null){
            return false;
        }
        userRepository.delete(user1);
        return true;
    }


}
