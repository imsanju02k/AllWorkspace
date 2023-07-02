package in.ineruon.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.util.HibernateUtil;

public class SelectApp {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");
			

			//Setting the parameter
			nativeQuery.setParameter(1, "yearly");
			
			
			
			//Executing to get the result
			List<Object[]> policies = nativeQuery.getResultList();
			
			//Processing the result
			System.out.println("PID\tPNAME\tPTYPE");
			policies.forEach(row -> {
				for (Object obj : row) {
					System.out.print(obj + "\t");
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
