package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ViewDetailsDB;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String fname;
	public static String lname;
	public static String dpin;   
	public static String apin;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("admin post servlet");
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		apin=request.getParameter("apin");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(apin);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("admin get servlet");
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		apin=request.getParameter("apin");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(apin);
		ViewDetailsDB av= new ViewDetailsDB();
		try {
			int i=ViewDetailsDB.patAdminCheck(fname, lname, apin);
			if(i==1)
			{
				request.setAttribute("list", av.adminView(fname, lname, apin));
			}
			else{
				request.setAttribute("message", "Please enter the correcr details");
				RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
