package in.ineruon.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class TestApp4 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			
			Query<Object[]> query = session.createQuery("select pname,price,qty  from  in.ineuron.model.Product where pname in (:prod1,:prod2)");// select * from product;

			
			//set values to named parameter 
			query.setParameter("prod1", "apple");
			query.setParameter("prod2", "rice");
			
			//execute the query 
			List<Object[]> products=query.list();
			
			System.out.println("pname\tprice\tqty");
			
			//process the list objects
			products.forEach(row->{
				for(Object object :row) {
					System.out.print(object+"\t");
				}
				System.out.println();
			});
			
			
			
			
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
