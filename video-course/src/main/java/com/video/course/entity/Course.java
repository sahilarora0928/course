package com.video.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.video.course.core.BaseEntity;
import com.video.course.enums.CourseTypeEnum;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	@Column(name = "description")
	private String description;

	@Column(name = "rating")
	private String rating;

	@Column(name = "course_type")
	private CourseTypeEnum courseType;

	@Column(name = "video_location")
	private String videoLocation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public CourseTypeEnum getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseTypeEnum courseType) {
		this.courseType = courseType;
	}

	public String getVideoLocation() {
		return videoLocation;
	}

	public void setVideoLocation(String videoLocation) {
		this.videoLocation = videoLocation;
	}

}
