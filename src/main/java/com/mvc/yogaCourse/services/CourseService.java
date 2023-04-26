package com.mvc.yogaCourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.yogaCourse.models.Course;
import com.mvc.yogaCourse.repositories.CourseRepo;

@Service
public class CourseService {
	
	@Autowired CourseRepo cRepo;
	
	public List<Course> getAllCourses() {
		return cRepo.findAll();
	}
	
	public Course getCourseById(Long id) {
		return cRepo.findById(id).orElse(null);
	}
	
	public Course saveAndUpdateCourse(Course course) {
		return cRepo.save(course);
	}
	
	public void deleteCourse(Long id) {
		cRepo.deleteById(id);
	} 
}
