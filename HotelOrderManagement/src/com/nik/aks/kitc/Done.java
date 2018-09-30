package com.nik.aks.kitc;


import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.swing.Icon;


public class Done extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int p=(int)session.getAttribute("tbl");
		//PrintWriter out=response.getWriter();
			Done d1=new Done();
		
			try {
				Statement stmt1=d1.connect();
				//boolean a;
				stmt1.execute("delete from kitchenorder where tableno="+p+"");
				stmt1.execute("Update neworder set status=False where tableno="+p+"");
				stmt1.execute("Insert into readyfromkitchen values("+p+")");
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
			//request.setAttribute("rtab",p);
			response.sendRedirect("http://localhost:8080/HotelOrderManagement/Kitchen.jsp");
	}

public Statement connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		Statement stmt=con.createStatement();
		return stmt;
	}
	
}
