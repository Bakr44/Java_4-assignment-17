package com.example.assignment17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Name cant be empty")
    @Size(min = 4,message = "Name must have at least 4 characters")
    private String name;

    @NotEmpty(message = "Username Cant be empty")
    @Size(min = 4, message = "Username must have at least 4 characters")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Password cant be empty")
    private String password;

    @NotEmpty(message = "Email Cant be empty")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Role is required")
    @Pattern(regexp = "^(user|admin)$", message = "Role must be user or admin")
    private String role;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be a positive number")
    private Integer age;



}
