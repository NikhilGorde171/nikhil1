package com.nik.aks.login;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String n=request.getParameter("txtUserName");
			String p=request.getParameter("txtPassword");
		
			PrintWriter out=response.getWriter();		
			Adminlogin al=new Adminlogin();
			try {
				Connection con1=al.connect();
				
				PreparedStatement ps=con1.prepareStatement("Select * from admin where uname=? and pass=?");
				ps.setString(1,n);
				ps.setString(2,p);
				
				ResultSet rs=ps.executeQuery();
				
				//ResultSet rs=stmt.executeQuery("select * from admin where uname="+n+" and pass="+p+"");
				
				
				if(rs.next()) {
					
					response.sendRedirect("http://localhost:8080/HotelOrderManagement/Tabsum.jsp");
				}
				else {
					
					//String m="Error in Username Or Password";
					//request.setAttribute("err", m);
					//out.print("<script type=\"text/javascript\">alert(" user or pass incorrect ");</script>");
					// out.println("location='waiter.html';");
					
					
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Username or password is incorrect');");
					out.println("location='login.jsp';");
					out.println("</script>");
					
					
					//out.println("<html><head></head><body onload=\"alert('Error in Username Or Password')\">  <a class=\"active\" href=\"http://localhost:8080/HotelOrderManagement/login.jsp\">Back</a></body></html>");
					//request.getRequestDispatcher("login.jsp").forward(request,response);
					
					
					
				}
				
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		
		
	}


	public Connection connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		//Statement stmt=con.createStatement();
		return con;
	}
	
	
	
	
}
