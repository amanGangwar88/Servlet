package com.aman.service;

import com.aman.to.StudentTO;

public interface StudentService {
public String addStudent(StudentTO sto);
public StudentTO searchStudent(String sid);
public StudentTO getStudent(String sid);
public String upadteStudent(StudentTO sto);
public String deleteStudent(String sid);
}
