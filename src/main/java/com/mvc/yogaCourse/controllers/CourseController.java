package com.mvc.yogaCourse.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.yogaCourse.models.Course;
import com.mvc.yogaCourse.services.CourseService;
import com.mvc.yogaCourse.services.UserService;

@Controller
public class CourseController {

	@Autowired private UserService uServ;
	@Autowired private CourseService cServ;
	
	/* ---- New Course Form ----*/
	@GetMapping("/course/new")
	public String newCoursePage(
			@ModelAttribute("newCourse") Course course,
			 HttpSession session
			, Model model
			) {
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("loggeredUser", uServ.findUserById(userId)); 

//		model.addAttribute("users", uServ.getAllUsers());
//		System.out.println(session.getAttribute("userName")); // <-- Note-------------
		return "newCourseForm";
	}
	
	@PostMapping("/course/new")
	public String addingNewCourse(
			@Valid @ModelAttribute("newCourse") Course Course
			, BindingResult res
			, HttpSession session // <-- Note
			, Model model
			) {
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("loggeredUser", session.getAttribute("userName"));
//		System.out.println(session.getAttribute("userName")); // <-- Note-------------
		if(res.hasErrors()) {
//			System.out.println(res);// <-- Note
//			System.out.println(session.getAttribute("userName")); // <-- Note
			model.addAttribute("newCourse", cServ.getAllCourses()); // <-- to remain on the page
			return "newCourseForm";
		}
		cServ.saveAndUpdateCourse(Course); // <-- save
		return "redirect:/courses";
	}
	
	
	/* ---- Edit Course Form ----*/
	@GetMapping("/course/{id}/edit")
	public String editCoursePage(
			@PathVariable("id") Long id
			, HttpSession session, Model model
			) {
		model.addAttribute("course", cServ.getCourseById(id));
		model.addAttribute("loggeredUser", session.getAttribute("userName"));
		return "edit";
	}
	
	@PutMapping("/course/{id}/edit")
	public String processEditCourse(
			@PathVariable("id") Long id
			, @Valid @ModelAttribute("course") Course course
			, BindingResult res
			, Model model
			) {
		if(res.hasErrors()) {
//			System.out.println(res);// <-- Note
			model.addAttribute("course", cServ.getAllCourses()); // <-- to remain on the page
			return "edit";
		}
		cServ.saveAndUpdateCourse(course);
		return "redirect:/courses";
	}
	
	
	/* ---- Render Edit Course Form ----*/
	@GetMapping("/course/{id}")
	public String courseDetailsPage(
			@PathVariable("id") Long id
			, HttpSession session, Model model
			) {
		model.addAttribute("course", cServ.getCourseById(id));
		return "details";
	}
	
	/* ---- Delete Course ----*/
	@DeleteMapping("/course/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id, Model model) {
		model.addAttribute("course", cServ.getCourseById(id));
		return "redirect:/";
	}
}
