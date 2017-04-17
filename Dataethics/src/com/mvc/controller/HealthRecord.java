package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Healthform;
import com.mvc.dao.HealthFormDB;

/**
 * Servlet implementation class HealthRecord
 */
@WebServlet("/HealthRecord")
public class HealthRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		String gender = null;
		if(request.getParameter("rdoGender")!= null)
		{
		if(request.getParameter("rdoGender").equalsIgnoreCase("Male")){
			gender = "Male";
		}
		else if(request.getParameter("rdoGender").equalsIgnoreCase("Female")){
			gender = "Female";
		}
		}
		String age = request.getParameter("age");
		String pnum = request.getParameter("cellno");
		System.out.println("Pnum from health record servlet"+pnum);
		String pnum_permission[] = request.getParameterValues("mobile_permissions");
		String ssn = request.getParameter("ssn");
		System.out.println("Ssn from health rexcord servlet "+ssn);
		String ssn_permission[] = request.getParameterValues("ssn_permissions");
		String address = request.getParameter("address");
		String general[]= request.getParameterValues("general");
		String ent[] = request.getParameterValues("ent");
		String cardio[] = request.getParameterValues("cardio");
		String symptoms = request.getParameter("symptoms");
		String symptoms_permission[] = request.getParameterValues("symptoms_permissions");
		String dpin = request.getParameter("dpin");
		System.out.println("Doctor pin in servlet "+dpin);
		String apin = request.getParameter("apin");
		System.out.println("admin pin in servlet: "+apin);
		Healthform hf= new Healthform();
		hf.setFname(fname);
		hf.setLname(lname);
		hf.setGender(gender);
		hf.setAge(age);
		hf.setPnum_doctor("");
		hf.setPnum_me("");
		hf.setPnum_admin("");
		for(int i =0;i<pnum_permission.length;i++)
		{
			if(pnum_permission[i].equals("doctor"))
			{
				hf.setPnum_doctor(pnum);
			}
			if(pnum_permission[i].equals("me"))
			{
				hf.setPnum_me(pnum);
				System.out.println("pnum from servlet: "+hf.getPnum_me());
			}
			if(pnum_permission[i].equals("admin"))
			{
				hf.setPnum_admin(pnum);
			}
		}
		hf.setSsn_doctor("");
		hf.setSsn_me("");
		hf.setSsn_admin("");
		for(int i =0;i<ssn_permission.length;i++)
		{
			if(ssn_permission[i].equals("doctor"))
			{
				hf.setSsn_doctor(ssn);
				System.out.println("from servlet "+hf.getSsn_doctor());
			}
			if(ssn_permission[i].equals("me"))
			{
				hf.setSsn_me(ssn);
			}
			if(ssn_permission[i].equals("admin"))
			{
				hf.setSsn_admin(ssn);
			}
		}
		hf.setAddress(address);
		hf.setGeneral(general);
		hf.setEnt(ent);
		hf.setCardio(cardio);
		hf.setSymptoms_doctor("");
		hf.setSymptoms_me("");
		hf.setSymptoms_admin("");
		for(int i =0;i<symptoms_permission.length;i++)
		{
			if(symptoms_permission[i].equals("doctor"))
			{
				hf.setSymptoms_doctor(symptoms);
			}
			if(symptoms_permission[i].equals("me"))
			{
				hf.setSymptoms_me(symptoms);
			}
			if(symptoms_permission[i].equals("admin"))
			{
				hf.setSymptoms_admin(symptoms);
			}
		}
		hf.setDpin(dpin);
		hf.setApin(apin);
		HealthFormDB hfdb=new HealthFormDB();
		try {
			hfdb.Insert(hf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("PatientHome.jsp");
		rd.forward(request, response);
	}

}
