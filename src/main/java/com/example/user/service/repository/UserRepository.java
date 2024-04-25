package com.example.user.service.repository;

import com.example.user.service.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByName(String name);
    List<Users> findBySurname(String surname);
    List<Users> findByEmail(String email);
    List<Users> findByPhone(String phone);

}
