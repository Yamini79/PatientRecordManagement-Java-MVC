package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.GetsSets;
import com.mvc.bean.Healthform;
import com.mvc.util.ConnectionManager;


public class ViewDetailsDB {
	private static Connection conn = ConnectionManager.getInstance().getConnection();
public static int patDocCheck(String f_name,String l_name,String a_pin) throws ClassNotFoundException, SQLException{
		
		String sql	=	"SELECT COUNT(*) FROM doctor_record WHERE fname=? AND lname=? and dpin=?";
		PreparedStatement pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1, f_name);
		pstmt.setString(2, l_name);
		pstmt.setString(3, a_pin);
		ResultSet rs	=	pstmt.executeQuery();
		
		int count = 0;
		while(rs.next()){
			count	=	rs.getInt(1);
		}
		return count;
		
	}
public static int patAdminCheck(String f_name,String l_name,String d_pin) throws ClassNotFoundException, SQLException{
	
	String sql	=	"SELECT COUNT(*) FROM admin_record WHERE fname=? AND lname=? and apin=?";
	PreparedStatement pstmt	=	conn.prepareStatement(sql);
	pstmt.setString(1, f_name);
	pstmt.setString(2, l_name);
	pstmt.setString(3, d_pin);
	ResultSet rs	=	pstmt.executeQuery();
	
	int count = 0;
	while(rs.next()){
		count	=	rs.getInt(1);
	}
	return count;
	
}
	public List<Healthform> adminView(String f_name,String l_name,String a_pin) throws SQLException
	{
		System.out.println(f_name);
		System.out.println(a_pin);
		List<Healthform> li=new ArrayList<Healthform>();
		PreparedStatement stmt = conn.prepareStatement("select * from admin_record where fname=? and lname=? and apin=?");
		stmt.setString(1, f_name);
		stmt.setString(2, l_name);
		stmt.setString(3, a_pin);
		ResultSet rs= stmt.executeQuery();
		while(rs.next())
		{
			System.out.println("from result set in View DB");
			Healthform h= new Healthform();
			h.setFname(rs.getString("fname"));
			System.out.println(h.getFname());
			h.setLname(rs.getString("lname"));
			System.out.println(h.getLname());
			h.setGender(rs.getString("gender"));
			System.out.println(h.getGender());
			h.setAge(rs.getString("age"));
			h.setPnum_admin(rs.getString("phonenumber"));
			h.setSsn_admin(rs.getString("ssn"));
			h.setAddress(rs.getString("address"));
			h.setGeneral_view(rs.getString("general_sym"));
			h.setEnt_view(rs.getString("ent"));
			h.setCardio_view(rs.getString("cardio"));
			h.setSymptoms_admin(rs.getString("symptoms"));
			li.add(h);
		}
		return li;
	}
	
	public List<Healthform> doctorView(String f_name,String l_name,String d_pin) throws SQLException
	{
		System.out.println(f_name);
		System.out.println(d_pin);
		List<Healthform> li=new ArrayList<Healthform>();
		PreparedStatement stmt = conn.prepareStatement("select * from doctor_record where fname=? and lname=? and dpin=?");
		stmt.setString(1, f_name);
		stmt.setString(2, l_name);
		stmt.setString(3, d_pin);
		ResultSet rs= stmt.executeQuery();
		while(rs.next())
		{
			System.out.println("from result set in doctor View DB");
			Healthform h= new Healthform();
			h.setFname(rs.getString("fname"));
			System.out.println(h.getFname());
			h.setLname(rs.getString("lname"));
			System.out.println(h.getLname());
			h.setGender(rs.getString("gender"));
			System.out.println(h.getGender());
			h.setAge(rs.getString("age"));
			h.setPnum_doctor(rs.getString("phonenumber"));
			h.setSsn_doctor(rs.getString("ssn"));
			h.setAddress(rs.getString("address"));
			h.setGeneral_view(rs.getString("general_sym"));
			h.setEnt_view(rs.getString("ent"));
			h.setCardio_view(rs.getString("cardio"));
			h.setSymptoms_doctor(rs.getString("symptoms"));
			li.add(h);
		}
		return li;
	}
	public List<Healthform> patientView(String uname,String pwd) throws SQLException
	{
		System.out.println(uname+" from patient view");
		List<Healthform> li=new ArrayList<Healthform>();
		PreparedStatement stmt1=conn.prepareStatement("select fname,lname from registration where username=? and password=?");
		stmt1.setString(1, uname);
		stmt1.setString(2, pwd);
		ResultSet rs1=stmt1.executeQuery();
		String f_name="";
		String l_name="";
		while (rs1.next())
		{
			f_name=rs1.getString(1);
			l_name=rs1.getString(2);
		}
		PreparedStatement stmt = conn.prepareStatement("select * from patient_record where fname=? and lname=?");
		stmt.setString(1, f_name);
		stmt.setString(2, l_name);
		ResultSet rs= stmt.executeQuery();
		while(rs.next())
		{
			System.out.println("from result set in doctor View DB");
			Healthform h= new Healthform();
			h.setFname(rs.getString("fname"));
			System.out.println(h.getFname());
			h.setLname(rs.getString("lname"));
			System.out.println(h.getLname());
			h.setGender(rs.getString("gender"));
			System.out.println(h.getGender());
			h.setAge(rs.getString("age"));
			h.setPnum_me(rs.getString("phonenumber"));
			h.setSsn_me(rs.getString("ssn"));
			h.setAddress(rs.getString("address"));
			h.setGeneral_view(rs.getString("general_sym"));
			h.setEnt_view(rs.getString("ent"));
			h.setCardio_view(rs.getString("cardio"));
			h.setSymptoms_me(rs.getString("symptoms"));
			h.setDpin(rs.getString("dpin"));
			h.setApin(rs.getString("apin"));
			li.add(h);
		}
		return li;
	}
}
