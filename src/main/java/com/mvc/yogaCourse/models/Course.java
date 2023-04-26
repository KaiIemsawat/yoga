package com.mvc.yogaCourse.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
	

	/*------ Variable ------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @NotBlank(message="Course name is required!")
    @Size(min=3, max=30, message="Course name must be between 3 and 30 characters")
    private String courseName;
    
    @NotBlank(message="Name is required!")
    @Size(min=3, max=30, message="Name  must be between 3 and 30 characters")
    private String instructorName;
    
    @NotBlank(message="Day is required!") // <--- might not need since it's has Sunday by default
    private String dayOfWeek;
    
    
    @NotNull(message="Need value input")
//    @Min(value=1, message="Price need to be over 1") // <--- Might not need due to HTML setup
//    @Max(value=100, message="Price can't exceed 100") // <--- Might not need due to HTML setup
    private Double price;
    
    @NotBlank(message="Time is required!")
    private String time;
    
    
    @NotBlank(message="Description is required!")
    @Size(min=3, max=400, message="Description must be between 3 and 400 characters")
    private String description;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;
	
	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
	}
	
	/*------ DB Setup ------*/
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user; // <--- This name needs to be matched with 'mappedBy' in '@OneToMany'
	
	
	/*------ Constructor ------*/
	public Course() {}

	
	public Course(
			@NotBlank(message = "Course name is required!") @Size(min = 3, max = 30, message = "Course name must be between 3 and 30 characters") String courseName,
			@NotBlank(message = "Name is required!") @Size(min = 3, max = 30, message = "Name  must be between 3 and 30 characters") String instructorName,
			@NotBlank(message = "Day is required!") String dayOfWeek,
			@NotNull(message = "Need value input") Double price, @NotBlank(message = "Time is required!") String time,
			@NotBlank(message = "Description is required!") @Size(min = 3, max = 400, message = "Description must be between 3 and 400 characters") String description,
			User user) {
		this.courseName = courseName;
		this.instructorName = instructorName;
		this.dayOfWeek = dayOfWeek;
		this.price = price;
		this.time = time;
		this.description = description;
		this.user = user;
	}

	/*------ Getters and Setters ------*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}


	public Date getUpdateAt() {
		return updateAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}


	/*------ There's no need at the time being ------*/
//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}
//	public void setUpdateAt(Date updateAt) {
//		this.updateAt = updateAt;
//	}
	
	
	
	
}
