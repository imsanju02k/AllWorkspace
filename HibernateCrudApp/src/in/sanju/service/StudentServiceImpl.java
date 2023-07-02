package in.sanju.service;

import in.sanju.dao.IStudentDao;
import in.sanju.daofactory.StudentDaoFactory;
import in.sanju.dto.Student;

public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao stdDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.save(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.findById(sid);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.delete(sid);
	}

}
