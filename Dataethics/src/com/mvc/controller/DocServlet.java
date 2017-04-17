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
 * Servlet implementation class DocServlet
 */
@WebServlet("/DocServlet")
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doc get servlet");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dpin=request.getParameter("dpin");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(dpin);
		ViewDetailsDB av= new ViewDetailsDB();
		try {
			int i=ViewDetailsDB.patDocCheck(fname, lname, dpin);
			if(i==1)
			{
				request.setAttribute("list", av.doctorView(fname, lname, dpin));
			}
			else
			{
				request.setAttribute("message", "Please enter the correcr details");
				RequestDispatcher rd = request.getRequestDispatcher("DocView.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("docresults.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
