package com.pratap.hibernate.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.entities.Student;

public class GetStudentSemesterMarksDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int stdId = 106;
			Student savedStudent = session.get(Student.class, stdId);
			System.out.println("Print the student details..");
			System.out.println("student marks as per semester : " + savedStudent.getMarks());
			session.getTransaction().commit();

		} finally {

			session.close();
			factory.close();
		}
	}

}
