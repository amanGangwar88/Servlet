package com.aman.factory;

import com.aman.service.StudentService;
import com.aman.service.StudentServiceImpl;

public class StudentServiceFactory {
private static StudentService std_Service;
static {
	std_Service=new StudentServiceImpl();
}
public static StudentService getStudentService() {
	return std_Service;
}
}
