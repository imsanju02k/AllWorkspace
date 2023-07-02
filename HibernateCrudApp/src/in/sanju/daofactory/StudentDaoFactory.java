package in.sanju.daofactory;

import in.sanju.dao.IStudentDao;
import in.sanju.dao.StudentDaoImp;

public class StudentDaoFactory {
	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao=null;
	public static IStudentDao getStudentDao() {
		if(studentDao==null) {
			studentDao=new StudentDaoImp();
		}
		return studentDao;
	}

}
