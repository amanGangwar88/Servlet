package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.aman.factory.ConnectionFactory;
import com.aman.to.StudentTO;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(StudentTO sto) {
		String status = ""; 
		try {
			 Connection con=ConnectionFactory.getConnection();
			 PreparedStatement pst=con.prepareStatement("select * from student where SID = ?");
			 pst.setString(1, sto.getSid());
			 ResultSet rs=pst.executeQuery();
			 boolean b=rs.next();
			 if(b==true) {
				 status="existed";
			 }else {
				 pst=con.prepareStatement("insert into student values(?,?,?)");
				 pst.setString(1, sto.getSid());
				 pst.setString(2, sto.getSname());
				 pst.setString(3, sto.getSaddr());
				 int rowCount=pst.executeUpdate();
				 if(rowCount ==1) {
					 status="success";
				 }else {
					 status="failure";
				 }
			 }
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return  status;
	}

	@Override
	public StudentTO search(String sid) {
		 StudentTO sto=getStudent(sid);
		return sto;
	}

	@Override
	public StudentTO getStudent(String sid) {
		StudentTO sto=null;
		try {
	           Connection con=ConnectionFactory.getConnection();
	           PreparedStatement pst=con.prepareStatement("select * from student where SID=?");
			pst.setString(1, sid);
			ResultSet rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true) {
				 sto=new StudentTO();
				sto.setSid(rs.getString("SID"));
				sto.setSname(rs.getString("SNAME"));
				sto.setSaddr(rs.getString("SADDR"));
				
			}else {
				sto=null;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return sto;
	}

	@Override
	public String update(StudentTO sto) {
		 
		return null;
	}

	@Override
	public String delete(String sid) {
		 
		return null;
	}

}
