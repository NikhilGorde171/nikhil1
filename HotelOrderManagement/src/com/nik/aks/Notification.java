package com.nik.aks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


public class Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
				
		Notification no=new Notification();
		try {
			Statement stmt=no.connect();
		
			ResultSet rs=stmt.executeQuery("select * from readyfromkitchen");
		
			if(rs.next()) {
				int p1=rs.getInt(1);
			
				if(p1!=0) {
					
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Order For Table No: "+p1+" is Ready...!!!');");
					out.println("location='waiter.html';");
					out.println("</script>");
					
					
					stmt.execute("Delete from readyfromkitchen where tableno="+p1+"");
					//response.sendRedirect("http://localhost:8080/HotelOrderManagement/waiter.html");
					
				}
			
						
			}
			
			else {
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('No Pending Order From Kitchen...!!!');");
				out.println("location='waiter.html';");
				out.println("</script>");	
				//response.sendRedirect("http://localhost:8080/HotelOrderManagement/waiter.html");
			}
			
			
			//response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	
public Statement connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		Statement stmt=con.createStatement();
		return stmt;
	}
		
}
