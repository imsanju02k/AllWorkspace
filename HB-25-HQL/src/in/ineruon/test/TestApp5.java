package in.ineruon.test;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp5 {

	@SuppressWarnings({ "unchecked", "unused", "resource" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			
			Query<Product> query = session.createQuery("from in.ineuron.model.Product where pid=:id");// select * from product;

			System.out.println("enter the id of the product");
			int id=new Scanner(System.in).nextInt();
			
			//set values to named parameter 
			query.setParameter("id", id);
			
			
			//execute the query 
			//List<Product> products=query.list();M-1
			//Product product=query.uniqueResult();
			
			Optional<Product> optinal=query.uniqueResultOptional();
			if(optinal.isPresent()) {
				Product product=optinal.get();
				System.out.println(product);
			}
			else {
				System.out.println("record is not available for the give id "+id);
			}
			
			
			
			
//			//process the list objects
//			if(product!=null) {
//				
//				System.out.println(product);
//			}else {
//				System.out.println("record not avaialbe for the give id:: "+id);
//			}
//			
			
			
			
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
