package com.example.demo.dao;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByNameAndPassword(String name,Integer password);
}
