package com.aman.service;

import com.aman.dao.StudentDao;
import com.aman.factory.StudentDaoFactory;
import com.aman.to.StudentTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(StudentTO sto) {
		 StudentDao stdDao = StudentDaoFactory.getStudentDao();
		 String status=stdDao.add(sto);
		return status;
	}

	@Override
	public StudentTO searchStudent(String sid) {
		 StudentDao stdDao=StudentDaoFactory.getStudentDao();
		 StudentTO sto=stdDao.search(sid);
		 
		return sto;
	}

	@Override
	public StudentTO getStudent(String sid) {
		 
		return null;
	}

	@Override
	public String upadteStudent(StudentTO sto) {
		 
		return null;
	}

	@Override
	public String deleteStudent(String sid) {
		 
		return null;
	}

}
