package com.pratap.hibernate.demos;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.entities.Student;

public class CreateStudentMapDemo {

	public static void main(String[] args) {

		// 1. create sessionfactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// 2. get session from sf
		Session session = factory.getCurrentSession();
		try {
		// 3. create the object

			Student student = new Student("Pratap", "Narayan", "test@gmail.com");
			Map<String, String> countries = student.getCountries();
			countries.put("IN", "India");
			countries.put("EN", "England");
			countries.put("US", "United States");
			countries.put("AUS", "Austrelia");
			countries.put("NE", "Netherland");
			
		// 4. start a transaction
			session.beginTransaction();
			
		// 5. save the object
			System.out.println("saving the student and countries ..");
			session.persist(student);
		
		// 6. commit the transaction
			session.getTransaction().commit();
			System.out.println("Done..");
		}
		finally {
		// 7. clean up the code
			session.close();
			factory.close();
		}
	}

}
