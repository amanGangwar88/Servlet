package com.aman.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aman.dto.Employee;

public class EmployeeService {
	Connection con;
	Statement st;
	ResultSet rs;
	Employee emp;
	public EmployeeService() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            st=con.createStatement();		     
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
  public Employee getEmployee(int eno) {
	  try {
		rs=st.executeQuery("select * from emp where ENO="+eno);
		boolean b=rs.next();
		if(b==true) {
			emp=new Employee(); 
			emp.setEno(rs.getInt("ENO"));
			emp.setEname(rs.getString("ENAME"));
			emp.setEsal(rs.getFloat("ESAL"));
			emp.setEaddr(rs.getString("EADDRS"));
		}else {
			emp=null;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return emp;
  }
  public String update(Employee emp) {
	  String status="";
	  try {
		st.executeUpdate("Update emp set ENAME= '"+emp.getEname()+"', ESAL= "+emp.getEsal()+", EADDRS= '"+emp.getEaddr()+"' where ENO= "+emp.getEno());
	    status="success";
	  } catch (Exception e) {
		  status="failure";
	    e.printStackTrace();	 
	}
	  return status;
  }
}
 