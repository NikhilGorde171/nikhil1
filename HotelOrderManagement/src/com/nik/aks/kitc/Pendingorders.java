package com.nik.aks.kitc;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Pendingorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pendingorders p1= new Pendingorders();
		
		//response.sendRedirect("http://localhost:8080/HotelOrderManagement/kitchen.html");
		try {
			
		
			Connection con1=p1.connect();
			
			Statement stmt1=con1.createStatement();
			
			//PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			int a1=0;
			ResultSet rs1=stmt1.executeQuery("Select count(distinct tableno) from kitchenorder");
			if(rs1.next()) {
			a1=rs1.getInt(1);
			}
			
			
			ResultSet rs=stmt1.executeQuery("Select distinct tableno from kitchenorder");
			int arr1[]=new int[a1];
			
			
			for(int i=0;i<arr1.length;i++)
			{
				
				rs.next();
				arr1[i]=rs.getInt("tableno");
				
				
			}
			
			
			
			
	/*	 ArrayList<String> al1= new ArrayList<>();
			while(rs.next()) {
				
				al1.add("name");
				
			}
		*/	
			
			/* method-1
			int i=1;
			int a[]=new int[10];
			
			while(rs.next()) {
				
				
				a[i]=Integer.parseInt(rs.getString(1));
				i++;
			}
			
			int size=a.length;
			for(int j=1;j<=size;j++) {
			
				System.out.println(a[j] );
			
			}
			
			request.setAttribute("ar",a);
			request.getRequestDispatcher("Kitchen.jsp").forward(request,response); */
			
			
			/*if(rs.next()) {
				int i=rs.getInt(1);
				request.setAttribute("a",i);
			
			}
			
			if(rs.next()) {
				int j=rs.getInt(1);
				request.setAttribute("b",j);
				
			}
			
			if(rs.next()) {
				int k=rs.getInt(1);
				request.setAttribute("c",k);
				
			}
			
			if(rs.next()) {
				int l=rs.getInt(1);
				request.setAttribute("d",l);
				
			}
			
			if(rs.next()) {
				int m=rs.getInt(1);
				request.setAttribute("e",m);
				
			}
			
			if(rs.next()) {
				int n=rs.getInt(1);
				request.setAttribute("f",n);
				
			}
			
			if(rs.next()) {
				int o=rs.getInt(1);
				request.setAttribute("g",o);
				
			}
			if(rs.next()) {
				int p=rs.getInt(1);
				request.setAttribute("h",p);
				
			}
			
			if(rs.next()) {
				int q=rs.getInt(1);
				request.setAttribute("i",q);
				
			}
			if(rs.next()) {
				int r=rs.getInt(1);
				request.setAttribute("j",r);
				
			}

				*/
			//request.setAttribute("al1", al1);
			request.setAttribute("arr1", arr1);
			request.getRequestDispatcher("Kitchen.jsp").forward(request,response);
			
						con1.close();
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
