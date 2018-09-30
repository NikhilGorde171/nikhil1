package com.nik.aks;

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




public class Tabsumm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int a=Integer.parseInt(request.getParameter("tableno"));
		HttpSession session=request.getSession();
		session.setAttribute("tno",a);
		
			Tabsumm t1=new Tabsumm();
		
			try {
				Statement stmt1 =t1.connect();
			
			
			ResultSet rs=stmt1.executeQuery("select neworder.name,neworder.quantity,price.price from neworder,price where neworder.tableno="+a+" and neworder.menuid=price.menuid and neworder.status=false");
			
			//Map<String,Integer> map=new HashMap<String,Integer>();
			
			int[] arr1=new int[50];
			
			int[] arr2=new int[50];
			
			ArrayList<String> ar=new ArrayList<>();
			
			int i=0;
			int j=0;
			while(rs.next()) {
				
				
				ar.add(rs.getString("name"));
				
				//map.put(rs.getString("quantity"), rs.getInt("price"));
				arr1[i]=rs.getInt("quantity");	
				
				arr2[j]=rs.getInt("price");
				
				i++;
				j++;
			}
			
				request.setAttribute("arr1",arr1); //quantity
				request.setAttribute("arr2",arr2); //price
				request.setAttribute("al", ar); //menu name
				
				//request.setAttribute("map", map);
				
				request.getRequestDispatcher("Tabsum.jsp").forward(request,response);
				
			
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
