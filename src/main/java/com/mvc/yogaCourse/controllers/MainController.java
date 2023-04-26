package com.mvc.yogaCourse.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.yogaCourse.models.Course;
import com.mvc.yogaCourse.models.LogUser;
import com.mvc.yogaCourse.models.User;
import com.mvc.yogaCourse.services.CourseService;
import com.mvc.yogaCourse.services.UserService;

@Controller
public class MainController {

	@Autowired private UserService uServ;
	@Autowired private CourseService cServ;
	
	public Object temp;
	
	/* ---- Render Login page ----*/
	@GetMapping("/")
	public String registrationAndLoginPage(
			@ModelAttribute("registerUser") User newUser
			, @ModelAttribute("logUser") LogUser logUser
			) {
		return "main";
	} 
	
	/* ---- Process registering / login ----*/
	@PostMapping("/register")
	public String registerUser(
			@ModelAttribute("logUser") LogUser logUser
			, @Valid @ModelAttribute("registerUser") User newUser
			, BindingResult result
			, HttpSession session
			) {
		
		User changedUser = uServ.register(newUser, result);
//		Perform additional validation (that was add in Service)
		if(result.hasErrors()) {
			return "main";
		}
//		User is already registered in the register method in the service file
		session.setAttribute("userId", changedUser.getId());
		return "redirect:/courses";
	}
	
	@PostMapping("/login")
	public String loginUser(
			@Valid @ModelAttribute("logUser") LogUser logUser
			, BindingResult result
			, HttpSession session
			, @ModelAttribute("registerUser") User newUser
			) {
		User foundUser = uServ.login(logUser, result);
		if(result.hasErrors()) {
			return "main";
		}
		session.setAttribute("userId", foundUser.getId());
		session.setAttribute("userName", foundUser.getUserName());
		System.out.println(foundUser.getId()); // <-- Note-------------
		return "redirect:/courses";
	}
	

	/* ---- Render Courses page ----*/
	@GetMapping("/courses")
	public String dashBoardPage(
			HttpSession session, Model model
			) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/"; // <-- send back to Login page
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("loggeredUser", uServ.findUserById(userId));
//		System.out.println(uServ.findUserById(userId)); // <-- Note-------------
		model.addAttribute("courses", cServ.getAllCourses());
		return "courses";
	}

	
	/* ---- Process logout ----*/
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
