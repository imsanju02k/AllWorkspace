package in.ineruon.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateMySQLUtil;

public class InsertRecordApp2 {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer sid = null;

		try {
			session = HibernateMySQLUtil.getSession();
			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student = new Student();

				student.setSaddress("SRH");
				student.setSage(31);
				student.setSname("Bhuvi");

				sid = (Integer) session.save(student);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + sid);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}

			HibernateMySQLUtil.closeSession(session);
			HibernateMySQLUtil.closeSessionFactory();
		}

	}

	}


