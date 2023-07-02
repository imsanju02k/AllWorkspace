package in.ineruon.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.util.HibernateUtil;

public class InsertApp {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		int rowaffected=0;

		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
            
			NativeQuery nativeQuery=session.createSQLQuery("insert into insurancepolicy(policyName,policytype,tenure,company)values(?,?,?,?)");
			
			nativeQuery.setParameter(1, "prudential");
			nativeQuery.setParameter(2, "quarterly");
			nativeQuery.setParameter(3, "36");
			nativeQuery.setParameter(4, "ICICI");
			
			rowaffected=nativeQuery.executeUpdate();
			flag=true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("record inserted is :: " +rowaffected);
			}
			else {
				transaction.rollback();
				System.out.println("record not inserted");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
