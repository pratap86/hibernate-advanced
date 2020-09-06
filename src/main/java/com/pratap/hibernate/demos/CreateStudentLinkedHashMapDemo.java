package com.pratap.hibernate.demos;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.entities.Student;

public class CreateStudentLinkedHashMapDemo {

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

			Student student = new Student("Shankar", "Narayan", "test@gmail.com");
			Map<String, Integer> marks = student.getMarks();
			marks.put("First", 333);
			marks.put("Second", 330);
			marks.put("Third", 344);
			marks.put("Fourth", 456);
			marks.put("Fifth", 480);
			marks.put("Sixth", 495);
			
		// 4. start a transaction
			session.beginTransaction();
			
		// 5. save the object
			System.out.println("saving the student and semester marks ..");
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
