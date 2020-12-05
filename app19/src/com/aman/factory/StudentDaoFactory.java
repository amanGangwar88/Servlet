package com.aman.factory;

import com.aman.dao.StudentDao;
import com.aman.dao.StudentDaoImpl;

public class StudentDaoFactory {
private static StudentDao std_Dao;
static {
	std_Dao=new StudentDaoImpl();
}
public static StudentDao getStudentDao() {
	return std_Dao;
}
}
