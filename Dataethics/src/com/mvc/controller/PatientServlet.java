package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.GetsSets;
import com.mvc.dao.DbManager;
import com.mvc.dao.ViewDetailsDB;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("patient get servlet");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		System.out.println("Parameters from Login page");
		System.out.println(LoginServlet.userName);
		System.out.println(LoginServlet.passWord);
		System.out.println(fname);
		System.out.println(lname);
		ViewDetailsDB av= new ViewDetailsDB();
		try {
					request.setAttribute("list", av.patientView(LoginServlet.userName,LoginServlet.passWord));	
					RequestDispatcher rd= request.getRequestDispatcher("patientresults.jsp");
					rd.forward(request, response);				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
