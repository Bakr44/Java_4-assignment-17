package com.example.assignment17.Repository;

import com.example.assignment17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
