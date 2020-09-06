package com.pratap.hibernate.inheritance.mapping.strategies.singletable.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.pratap.hibernate.constants.Courses;

@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {

	@Enumerated(EnumType.STRING)
	@Column(name = "course")
	private Courses course;

	public Student(String firstName, String lastName, String email, Courses course) {
		super(firstName, lastName, email);
		this.course = course;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}
	
}
