package com.mvc.yogaCourse.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.yogaCourse.models.Course;
import com.mvc.yogaCourse.services.CourseService;
import com.mvc.yogaCourse.services.UserService;

@Controller
public class NewCourseController {

	@Autowired private UserService uServ;
	@Autowired private CourseService cServ;
	
	/* ---- Render Login page ----*/
	@GetMapping("/course/new")
	public String newCoursePage(@ModelAttribute("newCourse") Course course) {
		return "newCourseForm";
	}
	
	@PostMapping("/course/new")
	public String addingNewCourse(
			@Valid @ModelAttribute("newCourse") Course Course
			, BindingResult res
			) {
		if(res.hasErrors()) {
			return "newCourseForm";
		}
		cServ.saveAndUpdateCourse(Course);
		return "redirect:/courses";
	}
}
