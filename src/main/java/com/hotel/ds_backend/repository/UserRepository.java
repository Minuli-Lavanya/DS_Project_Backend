package com.hotel.ds_backend.repository;

import com.hotel.ds_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    public User findTopByOrderByUserIdDesc();
}
