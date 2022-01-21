package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Lesson;



public interface LessonDao extends JpaRepository<Lesson,Integer> {
	Lesson findByNameAndUsername(String name,String userName);
	void deleteByNameAndUsername(String name,String userName);
	List<Lesson> findByUsername(String userName);
}
