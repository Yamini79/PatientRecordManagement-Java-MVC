package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.GetsSets;
import com.mvc.dao.DbManager;

import java.sql.SQLException;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
	 	String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		String gender = null;
		if(request.getParameter("Gender").equalsIgnoreCase("Male")){
			gender = "Male";
		}
		else if(request.getParameter("Gender").equalsIgnoreCase("Female")){
			gender = "Female";
		}
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		
		GetsSets sets = new GetsSets();
		sets.setFname(fname);
		sets.setLname(lname);
		sets.setGender(gender);
		sets.setUsername(username);
		sets.setPassword(password);
		try{
		DbManager.Insert(sets);
		System.out.println("came into try");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
		}
}

