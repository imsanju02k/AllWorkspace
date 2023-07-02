package in.ineruon.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectApp4 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<String> nativeQuery = session.createSQLQuery("SELECT POLICYNAME FROM INSURANCEPOLICY WHERE TENURE>=:max AND TENURE<=:min");

			//Setting the parameter
			nativeQuery.setParameter("max", 15);
			nativeQuery.setParameter("min", 27);
			
			
			
			
			
			//Executing to get the result
			List<String> policies = nativeQuery.getResultList();
			
			//Processing the result
			policies.forEach(System.out::println);
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
