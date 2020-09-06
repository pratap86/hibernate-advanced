package com.pratap.hibernate.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.pratap.hibernate.constants.Status;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;
	
	@Embedded // here @Embedded is optional, this is inferred because Address has @Embeddable
	private Address address;
	
	@ElementCollection
	@CollectionTable(name = "image", // defaults to student_images
		joinColumns = @JoinColumn( name="student_id" ))
	@Column(name = "file_name") // defaults to images
	private Set<String> images = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name = "book", joinColumns = @JoinColumn(name = "student_id"))
	@OrderColumn(name = "my_data_order")
	@Column(name = "book_name")
	private List<String> books = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "country", joinColumns = @JoinColumn(name = "student_id"))
	@MapKeyColumn(name = "country_code")
	@Column(name = "country_name")
	private Map<String, String> countries = new HashMap<>();
	
	
	@ElementCollection
	@CollectionTable(name = "semester_marks")
	@MapKeyColumn(name = "semester")
	@OrderBy("marks ASC")
	@Column(name = "marks")
	private Map<String, Integer> marks = new LinkedHashMap<>();
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "staus")
	private Status status;
	
	public Student() {}
	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}

	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// for debugging & logging
	@Override
	public String toString() {
		return String.format("Student [id=%s, firstName=%s, lastName=%s, email=%s]", id, firstName, lastName, email);
	}

}
