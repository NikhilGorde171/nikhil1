package com.nik.aks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Orderinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Orderinfo() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("Text/Html");
		PrintWriter out=response.getWriter();
		
		String n=request.getParameter("customername");
		int q=Integer.parseInt(request.getParameter("orderid"));
		int p=Integer.parseInt(request.getParameter("tableno"));
		String r=request.getParameter("mobileno");
		
		System.out.println("show values custname="+n);
	}

}
