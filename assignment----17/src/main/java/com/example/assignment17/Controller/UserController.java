package com.example.assignment17.Controller;

import com.example.assignment17.ApiResponse.ApiResponse;
import com.example.assignment17.Model.User;
import com.example.assignment17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user,@PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated=userService.updateUser(id,user);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Updated Successfully"));
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }

    @DeleteMapping("/delete/{id}")
 public ResponseEntity deleteUsre(@PathVariable Integer id){
        Boolean isDelete=userService.deleteUser(id);
        if (isDelete){
            return ResponseEntity.status(200).body("Deleted");
        }
        return ResponseEntity.status(400).body("wrong ID");
    }


}
