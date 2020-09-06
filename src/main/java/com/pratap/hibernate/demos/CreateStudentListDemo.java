package com.pratap.hibernate.demos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.entities.Student;

public class CreateStudentListDemo {

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
			List<String> books = student.getBooks();
			books.add("Book1");
			books.add("Book2");
			books.add("Book3");
			books.add("Book4");
			books.add("Book4");
			
		// 4. start a transaction
			session.beginTransaction();
			
		// 5. save the object
			System.out.println("saving the student and books ..");
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
