package com.drag;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k=i+j;
		
		PrintWriter out = res.getWriter();
		out.println("result is "+ k);
		
		//We can call the SquareServlet by two ways
		//req Dispatcher and Redirect
		
		//passing k along with the req object
		
		req.setAttribute("k",k);
		
		//Using Request Dispatcher
		
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);
	}
}
