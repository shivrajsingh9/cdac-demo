package com.cdac.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.pojo.Question;

public class AppMain {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Question question = new Question();
		question.setDescr("what is SQL");
		question.setPostedDate("2022-08-03");
		question.setAnswer("Structured query language");
		
		session.save(question);
		
		transaction.commit();

		System.out.println("Question saved");
		
		sf.close();
	}

}
