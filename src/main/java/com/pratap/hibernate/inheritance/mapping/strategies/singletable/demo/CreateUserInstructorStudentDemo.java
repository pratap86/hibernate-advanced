package com.pratap.hibernate.inheritance.mapping.strategies.singletable.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.constants.Courses;
import com.pratap.hibernate.inheritance.mapping.strategies.singletable.entities.Instructor;
import com.pratap.hibernate.inheritance.mapping.strategies.singletable.entities.Student;

public class CreateUserInstructorStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("Pratap", "Narayan", "pratap.narayan@gmail.com", Courses.HIBERNATE);
			
			Instructor instructor = new Instructor("Ram", "Charan", "charam.ram@yahoo.com", 36899.00);
			
			session.beginTransaction();
			
			System.out.println("Going to save student and instructor");
			session.save(student);
			session.persist(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done ..");
		} finally {
			session.close();
			factory.close();
		}
	}

}
