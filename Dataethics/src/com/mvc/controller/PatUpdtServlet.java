package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Healthform;
import com.mvc.dao.DbManager;

/**
 * Servlet implementation class PatUpdtServlet
 */
@WebServlet("/PatUpdtServlet")
public class PatUpdtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatUpdtServlet() {
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
	 	String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dpin = request.getParameter("dpin");
		System.out.println("dpin from patupdt servelt: "+dpin);
		String apin = request.getParameter("apin");
		System.out.println("dpin from patupdt servelt: "+apin);
		Healthform hf = new Healthform();
		hf.setFname(fname);
		hf.setLname(lname);
		hf.setDpin(dpin);
		hf.setApin(apin);
		try{
		DbManager.updtQueries(hf);
		System.out.println("came into try");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("PatientHome.jsp");
		rd.forward(request, response);
		}
}
