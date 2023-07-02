package in.ineruon.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp {

	
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
            transaction=session.beginTransaction();
            
            BankAccount account=new BankAccount();
            account.setAccno(1254);
            session.delete(account);
            
            session.delete(account);
            
            flag=true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("object status changed to closed / blocked ==> soft deletion");
			}
			else {
				transaction.rollback();
				System.out.println("object status not changed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
