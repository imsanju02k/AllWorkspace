package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.model.PremiumInsurancePolicy;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private HibernateUtil() {
	}

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(InsurancePolicy.class)
				.addAnnotatedClass(PremiumInsurancePolicy.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

}
