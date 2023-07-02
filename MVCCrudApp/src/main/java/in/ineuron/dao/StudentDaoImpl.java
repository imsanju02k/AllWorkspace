package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

//Persistence logic using hibernate
public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();

	@SuppressWarnings("finally")
	@Override
	public String addStudent(Student student) {
		System.out.println(student);
		
		Transaction transaction = null;
		Boolean flag = false;
		try {
			transaction = session.beginTransaction();
			session.save(student);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				return "success";
			} else {
				transaction.rollback();
				return "failure";
			}
		}
	}
	
	@Override
	public Student searchStudent(Integer sid) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		return "";
	}

	@Override
	public String updateStudent(Student student) {
		return "";
	}

}
