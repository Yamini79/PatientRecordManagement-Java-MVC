package com.mvc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.GetsSets;
import com.mvc.bean.Healthform;
import com.mvc.util.ConnectionManager;

public class DbManager {
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public static void Insert(GetsSets set) throws ClassNotFoundException, SQLException{
		
		
		String sql	=	"INSERT INTO registration (fname,lname,gender,username,password) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, set.getFname());
		pstmt.setString(2, set.getLname());
		pstmt.setString(3, set.getGender());
		pstmt.setString(4, set.getUsername());
		pstmt.setString(5, set.getPassword());
		pstmt.executeUpdate();
		//ConnectionManager.getInstance().close();		
}
	public static int checkUser(GetsSets get) throws ClassNotFoundException, SQLException{
		
		String sql	=	"SELECT COUNT(*) FROM registration WHERE username=? AND password=?";
		PreparedStatement pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1, get.getUsername());
		pstmt.setString(2, get.getPassword());
		ResultSet rs	=	pstmt.executeQuery();
		
		int count = 0;
		while(rs.next()){
			count	=	rs.getInt(1);
		}
		return count;
		
	}
	public static String[] getFnameLname(GetsSets get) throws ClassNotFoundException, SQLException{
		
		String sql	=	"SELECT fname,lname FROM registration WHERE username=? AND password=?";
		PreparedStatement pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1, get.getUsername());
		pstmt.setString(2, get.getPassword());
		ResultSet rs	=	pstmt.executeQuery();
		String name[]={};
		while(rs.next()){
			name[0]=rs.getString(1);
			name[1]=rs.getString(2);
		}
		return name;
		
	}
	public static void updtQueries(Healthform hf) throws ClassNotFoundException, SQLException{
		
		String patsql	=	"update patient_record set dpin=?,apin=? WHERE fname=? AND lname=?";
		PreparedStatement patstmt	=	conn.prepareStatement(patsql);
		patstmt.setString(3, hf.getFname());
		patstmt.setString(4, hf.getLname());
		patstmt.setString(1, hf.getDpin());
		patstmt.setString(2, hf.getApin());
		patstmt.executeUpdate();
		String docsql	=	"update doctor_record set dpin=? WHERE fname=? AND lname=?";
		PreparedStatement docstmt	=	conn.prepareStatement(docsql);
		docstmt.setString(2, hf.getFname());
		docstmt.setString(3, hf.getLname());
		docstmt.setString(1, hf.getDpin());
		docstmt.executeUpdate();
		String adminsql	=	"update admin_record set apin=? WHERE fname=? AND lname=?";
		PreparedStatement adstmt	=	conn.prepareStatement(adminsql);
		adstmt.setString(2, hf.getFname());
		adstmt.setString(3, hf.getLname());
		adstmt.setString(1, hf.getApin());
		adstmt.executeUpdate();		
	}
}
