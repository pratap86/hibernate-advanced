package com.pratap.hibernate.inheritance.mapping.strategies.mappedsuperclass.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INSTRUCTOR_MAPPED")
public class Instructor extends User {

	private Double salary;
	
	public Instructor(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
