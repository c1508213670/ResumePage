package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LessonDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Lesson;
import com.example.demo.pojo.Person;
import com.example.demo.pojo.User;

@Controller
public class JPAPersonController {
	String global_name="";
	Integer global_password=0;
	@Autowired
	PersonDao personDao;
	@Autowired
	UserDao userDao;
	@Autowired
	LessonDao lessonDao;
	@Transactional
	@GetMapping(value = "/updatel")
	public String Updatelesson(@RequestParam("lessonname") String name,Model m)
	{
		Lesson mlesson=lessonDao.findByNameAndUsername(name, global_name);
		lessonDao.deleteByNameAndUsername(name, global_name);		
		m.addAttribute("lesson", mlesson);
//		List<Lesson> lessonList=lessonDao.findAll();
//		m.addAttribute("lessons",lessonList);
		return "updatelesson";
	}
	@Transactional
	@GetMapping(value = "/deletel")
	public String deletelesson(@RequestParam("lessonname") String name,Model m)
	{
		lessonDao.deleteByNameAndUsername(name, global_name);
		List<Lesson> lessonList=lessonDao.findByUsername(global_name);
		m.addAttribute("lessons",lessonList);
		Lesson ll=new Lesson();
		m.addAttribute("ylesson", ll);
		return "showlesson";
	}
	@PostMapping(value = "/selectlessons")
	public String selectlessons(@ModelAttribute("lesson") Lesson le ,Model m)
	{
		le.setUsername(global_name);
		lessonDao.save(le);
		List<Lesson> lessonList=lessonDao.findByUsername(global_name);
		if (lessonList.size()!=0) {
			m.addAttribute("lessons",lessonList);
		Lesson ll=new Lesson();
		m.addAttribute("ylesson", ll);
		return "showlesson";
		}
		else {
			Lesson lee= new Lesson();
			lee.setUsername(global_name);
			lee.setGPA("");
			lee.setName("");
			m.addAttribute("lesson",lee);
			System.out.println(lee);
			return "insertlesson";
		}
	}
	
	@PostMapping(value  = "/insertl")
	public String insertlesson(Model m)
	{
		Lesson le= new Lesson();
		le.setUsername(global_name);
		le.setGPA("");
		le.setName("");
		m.addAttribute("lesson",le);
		System.out.println(le);
		return "insertlesson";
	}
	
	@GetMapping(value = "/selectlessons")
	public String gselectlessons(Model m)
	{
		List<Lesson> lessonList=lessonDao.findByUsername(global_name);
		if (lessonList.size()!=0) {
			System.out.println(lessonList.get(0));
		m.addAttribute("lessons",lessonList);
		Lesson ll=new Lesson();
		m.addAttribute("ylesson", ll);
		return "showlesson";
		}
		else {
			Lesson le= new Lesson();
			le.setUsername(global_name);
			le.setGPA("");
			le.setName("");
			m.addAttribute("lesson",le);
			System.out.println(le);
			return "insertlesson";
		}
		
	}
	
	@PostMapping(value = "/selectlesson")
	public String selectlesson(@ModelAttribute("ylesson") Lesson les ,Model m)
	{
		System.out.println(les.getName());
		Lesson mlesson=lessonDao.findByNameAndUsername(les.getName(), global_name);
		if (mlesson!=null) {
		m.addAttribute("lesson",mlesson);
		System.out.println(mlesson.toString());
		return "showonelesson";	
		}
		else {
			List<Lesson> lessonList=lessonDao.findByUsername(global_name);
			System.out.println(lessonList.get(0));
			m.addAttribute("lessons",lessonList);
			Lesson ll=new Lesson();
			m.addAttribute("ylesson", ll);
			return "showlesson";
		}
		
	}
	
	
	@RequestMapping(value = "/load")
	public String mylogin(Model m)
	{
		
		Person lp=new Person();
		Person rp=new Person();
		m.addAttribute("l_Person",lp);
		m.addAttribute("r_Person", rp);
//		session.setAttribute("person", rp);
		return "index";
	}
	
//	@RequestMapping(value = "/")
//	public String mylogin1(HttpSession session,Model m)
//	{
//		
//		Person lp=new Person();
//		Person rp=new Person();
//		m.addAttribute("l_Person",lp);
//		m.addAttribute("r_Person", rp);
////		session.setAttribute("person", rp);
//		return "index";
//	}
	
	@GetMapping(value = "/music")
	public String show_music(@RequestParam("musicstr") String musicString,Model m)
	{
		String[] musicstrings=musicString.split("，");
		m.addAttribute("musics", musicstrings);
		return "hobby";
	}
	
	@GetMapping(value = "/price")
	public String show_price(@RequestParam("pricestr") String priceString,Model m)
	{
		String[] pricestrings=priceString.split("，");
		m.addAttribute("prices", pricestrings);
		return "prize";
	}
	
//	@GetMapping(value = "/content")
//	public String show_content(@RequestParam("contentstr") String priceString,Model m)
//	{
//		String[] pricestrings=priceString.split(",");
//		m.addAttribute("prices", pricestrings);
//		return "prize";
//	}
//	
	@PostMapping(value = "/load")
	public String checkregister(@ModelAttribute(value = "l_Person") Person p1,@ModelAttribute(value = "r_Person") Person p, HttpSession session,Model m)
	{
		Person dPerson=personDao.findByNameAndPassword(p1.getName(), p1.getPassword());
		if (dPerson!=null)
		{
		System.out.println("1333331");
		session.setAttribute("person", dPerson);
		User u=userDao.findByNameAndPassword(dPerson.getName(),dPerson.getPassword() );
			if(u !=null){
				m.addAttribute("user",u);
				global_password=u.getPassword();
				global_name=u.getName();
				return "mypage";
			}
			else {
				return "index";
			}
		}
		if (p.getName()!=null && p.getPassword()!=null && p.getEmail()!=null)
		{
		System.out.println("1111");
		session.setAttribute("person", p);
		Person dp=personDao.save(p);
		User u=new User();
		u.setEmail(p.getEmail());
		u.setName(p.getName());
		global_password=p.getPassword();
		global_name=p.getName();
		m.addAttribute("user",u);
		return "registerform";
		}
		return "index";
	}
	
	
//	@RequestMapping(value = "/lpage",method = RequestMethod.POST)
//	public String lmypage(@ModelAttribute(value = "Person") Person p,Model m)
//	{
//		Person dPerson=Dao.findByNameAndPassword(p.getName(), p.getPassword());
//		
//		return "";
//	}
	@Transactional
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String update_id(Model m)
	{
		User dUser=userDao.findByNameAndPassword(global_name,global_password);
		if (dUser!=null) {
			userDao.deleteById(dUser.getId());	
			m.addAttribute("user", dUser);
			return "registerform";
		}
		return "mypage";
	}
	
//	@RequestMapping(value = "/mpage",method = RequestMethod.POST)
//	public String show_mypage (@ModelAttribute(value = "user") User u,Model m )
//	{
//		u.setPassword(global_password);
//		User dUser=userDao.save(u);
//		m.addAttribute("user", u);
//		return "mypage";
//	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, SessionStatus sessionStatus){
	    session.invalidate();
	    sessionStatus.setComplete();
	    global_name="";
	    global_password=0;
	    return "redirect:/load";
	}
	
	@PostMapping(value="/reg")
	public String reg(@ModelAttribute(value = "user") User u,@Valid User user,BindingResult result,Model
	model) {
	if(result.hasErrors()){
		u.setPassword(global_password);
		model.addAttribute("user", u);
		return "registerform";
	}
	u.setPassword(global_password);
	User dUser=userDao.save(u);
	model.addAttribute("user",u);
	return "mypage";
	}


	
//	@RequestMapping(value = "/perfectid",method = RequestMethod.POST)
//	public String Complete_information(@ModelAttribute(value = "r_Person") Person p ,HttpSession session,Model m)
//	{
//
//			
////		String name=res.getParameter("name");
////		String email=res.getParameter("email");
////		Integer password=Integer.valueOf(res.getParameter("password"));
//		
//		Person p1=personDao.save(p);
//		User u=new User();
//		u.setEmail(p.getEmail());
//		u.setName(p.getName());
//		u.setPassword(p.getPassword());
//		m.addAttribute("user",u);
//		
//		return "registerform";
//	}


}
