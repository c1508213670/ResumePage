package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_lesson")
public class Lesson {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Integer id;
@Column(name = "username")
String username;
@Column(name = "name")
String name;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Column(name = "GPA")
String GPA;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public Lesson() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Lesson [id=" + id + ", username=" + username + ", name=" + name + ", GPA=" + GPA + "]";
}
public void setName(String name) {
	this.name = name;
}
public String getGPA() {
	return GPA;
}
public void setGPA(String gPA) {
	GPA = gPA;
}
}
