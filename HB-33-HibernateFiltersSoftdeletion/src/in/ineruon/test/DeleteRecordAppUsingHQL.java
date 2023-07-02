package in.ineruon.test;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.util.HibernateUtil;

public class DeleteRecordAppUsingHQL {

	
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction =null;
		boolean flag=false;
		int rowCount=0;
		
		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
			
			Query query=session.createQuery("update in.ineuron.model.BankAccount set status ='closed' where accno=:no");
			query.setParameter("no", 5263);
			rowCount=query.executeUpdate();
			
			flag=true;

			

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("object status changed to closed/blocked ==> soft deletion "+rowCount);
			}
			else {
				transaction.rollback();
				System.out.println("object status not changed .. " +rowCount);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
