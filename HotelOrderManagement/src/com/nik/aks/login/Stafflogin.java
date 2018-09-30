package com.nik.aks.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Stafflogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String n=request.getParameter("txtUserName");
			String p=request.getParameter("txtPassword");
			PrintWriter out=response.getWriter();
			Stafflogin sl=new Stafflogin();
			
			try {
				Connection con1=sl.connect();
			
				
				PreparedStatement ps=con1.prepareStatement("select * from staff where uname=? and pass=?");
				ps.setString(1,n);
				ps.setString(2, p);
				
				ResultSet rs=ps.executeQuery();
				
				
				if(rs.next()) {
					
					response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
					
					
				}
				else {
					
					//String err="Error in Username Or PassWord";
					//request.setAttribute("err1",err);
					//request.getRequestDispatcher("login.jsp").forward(request,response);

					out.println("<script type=\"text/javascript\">");
					out.println("alert('Username or Password Incorrect');");
					out.println("location='login.jsp';");
					out.println("</script>");
					
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
