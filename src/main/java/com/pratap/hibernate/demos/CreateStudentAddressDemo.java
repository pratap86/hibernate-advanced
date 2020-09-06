package com.pratap.hibernate.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pratap.hibernate.constants.AddressType;
import com.pratap.hibernate.constants.Status;
import com.pratap.hibernate.entities.Address;
import com.pratap.hibernate.entities.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {

		// 1. create sessionfactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Address.class)
								.buildSessionFactory();
		
		// 2. get session from sf
		Session session = factory.getCurrentSession();
		try {
		// 3. create the object

			Student student = new Student("Shankar", "Sharma", "sharma.shankar@gmail.com");
			student.setStatus(Status.INACTIVE);

			Address homeAddress = new Address("GB Road", "Noida", "210301", AddressType.HOME);
		// 4. start a transaction
			session.beginTransaction();
			
		// 5. save the object
			student.setAddress(homeAddress);
			System.out.println("saving the student and address ..");
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
