package in.sanju.servicefactory;

import in.sanju.service.IStudentService;
import in.sanju.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private StudentServiceFactory() {}
	
	
	private static IStudentService studentService=null;
	
	public static IStudentService getStudentService() {
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		return studentService;
	}

}
