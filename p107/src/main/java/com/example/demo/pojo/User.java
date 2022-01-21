package com.example.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="c_user")
public class User {

	@Id
	@Range(min=0,message="ID不能小于0")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@NotEmpty(message="用户名不能为空")
	@Column(name="name",length = 200)
	String name ;
	@NotEmpty(message="学校不能为空")
	@Column(name="school")
	String school;
	@Pattern(regexp="[1][3,5,7,8][0-9]{9}",
			message="电话号格式不对,第1位为1，第2位为3,5,7,8，长度为11位")
	@Column(name = "phone")
	String phone;
	@Pattern(regexp="[0-9]{10}",
			message="学号格式不对,应全为数字且长度为10位")
	@Column(name = "sno")
	String sno;
	@NotEmpty(message="用户名不能为空")
	@Column(name="email")
	String email;
	@NotEmpty(message="专业不能为空")
	@Column(name = "subject")
	String subject;
	@Pattern(regexp="[大][一,二,三,四]",
			message="年级格式不对,输入为大一到大四")
	@Column(name = "grade")
	String grade;
	@Pattern(regexp="[1-4][.][0-9]{0,}",
			message="绩点格式不对,应该为0~4间的实数")
	@Column(name = "GPA")
	String GPA;
	@NotEmpty(message="音乐爱好不能为空")
	@Column(name = "music")
	String music;
	@NotEmpty(message="获奖情况不能为空")
	@Column(name = "price")
	String price;
	@Pattern(regexp="(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]",
			message="请输入正确的图片地址")
	@Column(name = "picturesrc",columnDefinition = "text")
	String picturesrcString;
	@Column(name = "password")
	Integer password;
	
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public String getPicturesrcString() {
		return picturesrcString;
	}
	public void setPicturesrcString(String picturesrcString) {
		this.picturesrcString = picturesrcString;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	public String getPrice() {
		return price;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getGPA() {
		return GPA;
	}
	public void setGPA(String gPA) {
		GPA = gPA;
	}
	public void setPrice(String price) {
		this.price = price;
	}
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", school=" + school + ", phone=" + phone + ", sno=" + sno
				+ ", email=" + email + ", subject=" + subject + ", grade=" + grade + ", GPA=" + GPA + ", music=" + music
				+ ", price=" + price + ", picturesrcString=" + picturesrcString + ", password=" + password + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
