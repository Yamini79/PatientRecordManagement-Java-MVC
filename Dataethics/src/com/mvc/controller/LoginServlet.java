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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ad_username="admin";
	public static final String ad_password="admin";
	public static final String doc_username="doctor";  
	public static final String doc_password="yamini";
	public static String userName;
	public static String passWord;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		userName	=	request.getParameter("Username");
		passWord	=	request.getParameter("Password");
		GetsSets set	=	new GetsSets();
		set.setUsername(userName);
		set.setPassword(passWord);
		int k=0;
		if(userName.equals(ad_username) && passWord.equals(ad_password))
		{
			k=1;
			response.sendRedirect("AdminHome.jsp");
		}
		if(userName.equals(doc_username) && passWord.equals(doc_password))
		{
			k=1;
			response.sendRedirect("DoctorHome.jsp");
		}
		if(k==0)
		{
		try {
			int checkUser	=	DbManager.checkUser(set);
			System.out.println(checkUser);
				if(checkUser == 1){
					k=1;
					HttpSession session=request.getSession();
					session.setAttribute(userName, passWord);	
					response.sendRedirect("PatientHome.jsp");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if (k==0){
			request.setAttribute("message", "Incorrect username/password! Please try again!");
			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}
	}

		
		
	}
