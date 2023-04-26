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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "user_course",
		joinColumns = @JoinColumn(name="course_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> users;
	
	
	/*------ Constructor ------*/
	public Course() {}

	
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/*------ There's no need at the time being ------*/
//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}
//	public void setUpdateAt(Date updateAt) {
//		this.updateAt = updateAt;
//	}
	
	
	
	
}
