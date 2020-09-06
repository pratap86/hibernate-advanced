package com.pratap.hibernate.demos;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.entities.Student;

public class CreateStudentSetDemo {

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
			Set<String> images = student.getImages();
			images.add("photo1.jpg");
			images.add("photo2.jpg");
			images.add("photo3.jpg");
			images.add("photo4.jpg");
			images.add("photo4.jpg");
			
		// 4. start a transaction
			session.beginTransaction();
			
		// 5. save the object
			System.out.println("saving the student and images ..");
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
