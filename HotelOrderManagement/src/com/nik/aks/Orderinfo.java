package com.nik.aks;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Orderinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("Text/Html");
		PrintWriter out=response.getWriter();
		
		if(request.getParameter("customername")!=null) {
		
			
		String n=request.getParameter("customername");
		int p=Integer.parseInt(request.getParameter("tableno"));
		String r=request.getParameter("mobileno");

		
		Orderinfo o=new Orderinfo();
		
		try {
			
			//for table no. primary key constraints
			Statement stmt=o.connect();
			
			ResultSet rs=stmt.executeQuery("Select distinct tableno from orderinfo");
			
			int p1;
			
			int v=0;
			while(rs.next()) {
				
			 p1=(int)rs.getInt("tableno");
			
				if(p1==p) {
					
					v=1;
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Table is Occupied');");
					out.println("location='waiter.html';");
					out.println("</script>");
						
				} //while
				
					
			}//try
		
		
			if(v==0) {
				
				HttpSession session=request.getSession();
				session.setAttribute("tableno",p);
				
				
				
				stmt.execute("insert into orderinfo(custname,tableno,mobileno)values('"+n+"',"+p+",'"+r+"')  ");
				
				response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
			
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
		}//1st if
		else {
			HttpSession session=request.getSession();
			session.setAttribute("tableno",0);
			
		}
		
		
		
		
		if(request.getParameter("tabno")!=null) {
			
			
				int p2=Integer.parseInt(request.getParameter("tabno"));	
					HttpSession session=request.getSession();
						
					session.setAttribute("tabno",p2);
					
					response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
					
				
				} //3rd if
		else {
			
			HttpSession session=request.getSession();
			
			session.setAttribute("tabno",0);
			
		}
		
		
		
		}//dopost							
		
		
	
	
	
	public Statement connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		Statement stmt=con.createStatement();
		return stmt;
	}

	
}
