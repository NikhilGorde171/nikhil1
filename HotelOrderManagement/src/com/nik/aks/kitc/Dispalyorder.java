package com.nik.aks.kitc;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Dispalyorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public String[] s1=new String[20];
		public int[] q1=new int[20];
		
		//public int quantity;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dispalyorder d1=new Dispalyorder();
		
		try {
			Connection con1=d1.connect();
			
			Statement stmt1=con1.createStatement();
			
			int a=Integer.parseInt(request.getParameter("tn"));
			
			//for done button send table no 
			
			HttpSession session=request.getSession();
			
			session.setAttribute("tbl", a);
			
			
			
			ResultSet rs=stmt1.executeQuery("Select name,quantity from kitchenorder where tableno="+a+"");
			/*Dispalyorder d2=new Dispalyorder();
			int i=0,j=0;
			while(rs.next()) {
				
				
				d2.s1[i]=(rs.getString("name"));
				d2.q1[j]=(rs.getInt("quantity"));
				i++;
				j++;
				
			}*/
			
			
			//System.out.println("length s1="+s1.length);
			
			//request.setAttribute("1", a);
			
			
			
			/* by arraylist
			
			
			ArrayList<String> list=new ArrayList<>();
			ArrayList<Integer> list1=new ArrayList<>();
			
			
			while(rs.next()) {
				
				list.add(rs.getString("name"));
				
			}
			
			while(rs.next()) {
				
				list1.add(rs.getInt("quantity"));
			}
			
			
			request.setAttribute("list",list);
			request.setAttribute("list1", list1);
			
			
		//	request.setAttribute("QuantityArray",q1);
	
			*/
			
			
			//by hashmap
			
			Map<String,Integer> map=new HashMap<String,Integer>();
			
			while(rs.next()) {
				
				
				map.put(rs.getString("name"), rs.getInt("quantity"));
				
				
			}
			
			
			
			request.setAttribute("map",map);
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
