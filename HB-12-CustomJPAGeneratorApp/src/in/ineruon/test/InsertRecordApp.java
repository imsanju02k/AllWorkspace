package in.ineruon.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		Integer id=null;
		
		try {
			
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			
			if(transaction!=null) {
				Student student=new Student();
				student.setSaddress("RCB");
				student.setSage(22);
				student.setSname("ABD");
				
				id=(Integer) session.save(student);
				flag=true;
				
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("objec inserted to the database with the id :: "+id);
			}
			else {
				transaction.rollback();
				System.out.println("object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
