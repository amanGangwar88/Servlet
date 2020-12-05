package com.aman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aman.dto.StudentDto;
import com.aman.factory.ConnectionFactory;

public class StudentService {
		public void addStudent(StudentDto sto) {
			try {
				Connection con=ConnectionFactory.getConnection();
				PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?)");
				pst.setString(1, sto.getSid());
				pst.setString(2, sto.getSname());
				pst.setString(3, sto.getSaddr());
				
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public List<StudentDto> getAllStudents(){
			List<StudentDto> std_List=new ArrayList<StudentDto>();
			try {
				Connection con=ConnectionFactory.getConnection();
				 Statement st=con.createStatement();
				 ResultSet rs=st.executeQuery("select * from student");
				 while(rs.next()) {
					 StudentDto sto=new StudentDto();
					 sto.setSid(rs.getString("SID"));
					 sto.setSname(rs.getString("SNAME"));
					 sto.setSaddr(rs.getString("SADDR"));
					 std_List.add(sto);
				 }
			} catch (Exception e) {
	           e.printStackTrace();
			}
			return std_List;
		}
	}

