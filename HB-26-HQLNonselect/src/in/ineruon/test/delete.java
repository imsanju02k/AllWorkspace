package in.ineruon.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class delete {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction=null;
		int count=0;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
            transaction=session.beginTransaction();
            
			// Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("delete from in.ineuron.model.Product where pid=:id");// select * from product;

			//set the parameter values
			query.setParameter("id", 3);
			
			
			count=query.executeUpdate();
			flag=true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("no of rows afftected is :: " +count);
			}else {
				transaction.rollback();
				System.out.println("no of rows affected is :: " +count);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
