package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hbmLearning.Entity.Employee;
import jakarta.persistence.TypedQuery;

public class App {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Staart...");

		 TypedQuery<Employee> query =session.createNamedQuery("Employee.findEmployeeById",Employee.class);    
		 query.setParameter("id",1);      
		 List<Employee> employees=query.getResultList();
		 employees.forEach(System.out::println);
		tx.commit();
		session.close();
		sf.close();

	}

}
