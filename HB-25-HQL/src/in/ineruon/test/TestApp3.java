package in.ineruon.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class TestApp3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			
			Query<Integer> query = session.createQuery("select price from  in.ineuron.model.Product where pname in (:prod1,:prod2)");// select * from product;

			
			//set values to named parameter 
			query.setParameter("prod1", "apple");
			query.setParameter("prod2", "rice");
			
			//execute the query 
			List<Integer> products=query.getResultList();
			
			System.out.println("price");
			
			//process the list objects
			products.forEach(System.out::println);
			
			
			
			
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
