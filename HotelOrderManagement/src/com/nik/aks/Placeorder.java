package com.nik.aks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Placeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session=request.getSession();
		int a=(int)session.getAttribute("tableno");
		
		
		
		
		Placeorder p1=new Placeorder();
		try {
			Statement stmt1=p1.connect();
			
		
			
			stmt1.execute("INSERT INTO kitchenorder SELECT * from neworder WHERE tableno="+a+" and status=True");
			
			
			
			response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		session.invalidate();
		
	}

	public Statement connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		Statement stmt=con.createStatement();
		return stmt;
	}
	
}
