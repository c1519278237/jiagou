package com.example.cxy.achitectureclass.dao;

import com.example.cxy.achitectureclass.common.dao.LogicDAO;
import com.example.cxy.achitectureclass.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends LogicDAO<User,Long> {
    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    User findUserByUsername(@Param("username") String username);

}