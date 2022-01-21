package com.example.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class Person {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Integer id;

@Column(name="name",length = 200)
String name ;
@Column(name="email")
String email;
@Column(name = "password")
Integer password;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getPassword() {
	return password;
}
public void setPassword(Integer password) {
	this.password = password;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}






}
