package in.ineruon.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class XMLJavaApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		int id = 3;

		try {

			Configuration configuration = new Configuration();

			configuration.configure();//HIBERNATE will search for hibernate.cfg.xml file
			
			// provided information about mapping file
			configuration.addAnnotatedClass(Student.class);

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			Student student = session.get(Student.class, id);

			if (student != null) {
				System.out.println("Before updation in the table :: " + student);
			} else {
				System.out.println("Record available for the given id :: " + id);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}


	}

}
