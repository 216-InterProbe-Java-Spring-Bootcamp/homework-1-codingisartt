package com.tubanurbalci.userproductproject.repository;

import com.tubanurbalci.userproductproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

}
