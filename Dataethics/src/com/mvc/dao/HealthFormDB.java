package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mvc.bean.Healthform;
import com.mvc.util.ConnectionManager;

public class HealthFormDB {
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public void Insert(Healthform hf) throws ClassNotFoundException, SQLException{
		
		
		String sql	=	"INSERT INTO doctor_record (fname,lname,gender,age,phonenumber,ssn,address,general_sym," +
				"ent,cardio,symptoms,dpin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql1	=	"INSERT INTO admin_record (fname,lname,gender,age,phonenumber,ssn,address,general_sym," +
				"ent,cardio,symptoms,apin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2	=	"INSERT INTO patient_record (fname,lname,gender,age,phonenumber,ssn,address,general_sym," +
				"ent,cardio,symptoms,dpin,apin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement doc = conn.prepareStatement(sql);
		PreparedStatement admin = conn.prepareStatement(sql1);
		PreparedStatement patnt = conn.prepareStatement(sql2);
		doc.setString(1, hf.getFname());
		System.out.println(hf.getFname());
		doc.setString(2, hf.getLname());
		doc.setString(3, hf.getGender());
		doc.setString(4, hf.getAge());
		doc.setString(5, hf.getPnum_doctor());
		System.out.println(hf.getPnum_doctor());
		doc.setString(6, hf.getSsn_doctor());
		System.out.println(hf.getSsn_doctor());
		doc.setString(7, hf.getAddress());
		String general="";
		for(int i=0;i<hf.getGeneral().length;i++)
		{
			general=hf.getGeneral()[i]+" ";
		}
		doc.setString(8, general);
		String ent="";
		for(int i=0;i<hf.getEnt().length;i++)
		{
			ent=hf.getEnt()[i]+" ";
		}
		doc.setString(9, ent);
		String cardio="";
		for(int i=0;i<hf.getCardio().length;i++)
		{
			cardio=hf.getCardio()[i]+" ";
		}
		doc.setString(10, cardio);
		doc.setString(11, hf.getSymptoms_doctor());
		doc.setString(12, hf.getDpin());
		doc.executeUpdate();
		admin.setString(1, hf.getFname());
		System.out.println(hf.getFname());
		admin.setString(2, hf.getLname());
		admin.setString(3, hf.getGender());
		admin.setString(4, hf.getAge());
		admin.setString(5, hf.getPnum_admin());
		System.out.println(hf.getPnum_admin());
		admin.setString(6, hf.getSsn_admin());
		System.out.println(hf.getSsn_admin());
		admin.setString(7, hf.getAddress());
		general="";
		for(int i=0;i<hf.getGeneral().length;i++)
		{
			general=hf.getGeneral()[i]+" ";
		}
		admin.setString(8, general);
		ent="";
		for(int i=0;i<hf.getEnt().length;i++)
		{
			ent=hf.getEnt()[i]+" ";
		}
		admin.setString(9, ent);
		cardio="";
		for(int i=0;i<hf.getCardio().length;i++)
		{
			cardio=hf.getCardio()[i]+" ";
		}
		admin.setString(10, cardio);
		admin.setString(11, hf.getSymptoms_admin());
		admin.setString(12, hf.getApin());
		admin.executeUpdate();
		patnt.setString(1, hf.getFname());
		System.out.println(hf.getFname());
		patnt.setString(2, hf.getLname());
		patnt.setString(3, hf.getGender());
		patnt.setString(4, hf.getAge());
		patnt.setString(5, hf.getPnum_me());
		System.out.println(hf.getPnum_me());
		patnt.setString(6, hf.getSsn_me());
		System.out.println(hf.getSsn_me());
		patnt.setString(7, hf.getAddress());
		general="";
		for(int i=0;i<hf.getGeneral().length;i++)
		{
			general=hf.getGeneral()[i]+" ";
		}
		patnt.setString(8, general);
		ent="";
		for(int i=0;i<hf.getEnt().length;i++)
		{
			ent=hf.getEnt()[i]+" ";
		}
		patnt.setString(9, ent);
		cardio="";
		for(int i=0;i<hf.getCardio().length;i++)
		{
			cardio=hf.getCardio()[i]+" ";
		}
		patnt.setString(10, cardio);
		patnt.setString(11, hf.getSymptoms_me());
		patnt.setString(12, hf.getDpin());
		patnt.setString(13, hf.getApin());
		patnt.executeUpdate();
		//ConnectionManager.getInstance().close();		
}
}
