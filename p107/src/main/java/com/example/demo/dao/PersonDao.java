package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Person;


@Repository
public interface PersonDao extends JpaRepository<Person,Integer> {
	  Person findByName(String name);
	  
	  Person findByNameAndPassword(String name, Integer password);
	
}


