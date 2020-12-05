package com.aman.dao;

import com.aman.to.StudentTO;

public interface StudentDao {
  public String add(StudentTO sto);
  public StudentTO search(String sid);
  public StudentTO getStudent(String sid);
  public String update(StudentTO sto);
  public String delete(String sid);
}
