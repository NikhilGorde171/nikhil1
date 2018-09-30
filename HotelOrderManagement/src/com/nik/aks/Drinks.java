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


public class Drinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session=request.getSession();
		
		if(session.getAttribute("tableno")!=null) {
		
		int p=(int)session.getAttribute("tableno");
		
		if(p!=0) {
		
		int a,b,c,d,f,g,h,i=0;
		
		 a=Integer.parseInt(request.getParameter("a"));
		 b=Integer.parseInt(request.getParameter("b"));
		 c=Integer.parseInt(request.getParameter("c"));
		 d=Integer.parseInt(request.getParameter("d"));
		 f=Integer.parseInt(request.getParameter("e"));
		 g=Integer.parseInt(request.getParameter("f"));
		 h=Integer.parseInt(request.getParameter("g"));
		 i=Integer.parseInt(request.getParameter("h"));

		
		 Drinks d1=new Drinks();
		 
		 try {
			Statement stmt1=d1.connect();
			

			if(a!=0) {
				
				stmt1.execute("insert into neworder values("+p+",41,'coke',"+a+",True);  ");
				
			}
			
			if(b!=0) {
				
				stmt1.execute("insert into neworder values("+p+",42,'sprite',"+b+",True);  ");
				
			}			
			
			if(c!=0) {
				
				stmt1.execute("insert into neworder values("+p+",43,'mango-maza',"+c+",True);  ");
				
			}
			
			
			if(d!=0) {
				
				stmt1.execute("insert into neworder values("+p+",44,'mirinda',"+d+",True);  ");
				
			}
			 if(f!=0) {
				
				stmt1.execute("insert into neworder values("+p+",45,'seven-up',"+f+",True);  ");
				
			}
			
			 if(g!=0) {
				
				stmt1.execute("insert into neworder values("+p+",46,'thumbs-up',"+g+",True);  ");
				
			}
			
			
			 if(h!=0) {
				
				stmt1.execute("insert into neworder values("+p+",47,'punjabi lassi',"+h+",True);  ");
				
			}
			
			 if(i!=0) {
				
				stmt1.execute("insert into neworder values("+p+",48,'mineral water',"+i+",True);  ");
				
			}
			
			response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}
		}//1st if
		 
		 
		if(session.getAttribute("tabno")!=null) {
		
			int p1=(int)session.getAttribute("tabno");
		
			if(p1!=0) {
			
			int a,b,c,d,f,g,h,i=0;
			
			 a=Integer.parseInt(request.getParameter("a"));
			 b=Integer.parseInt(request.getParameter("b"));
			 c=Integer.parseInt(request.getParameter("c"));
			 d=Integer.parseInt(request.getParameter("d"));
			 f=Integer.parseInt(request.getParameter("e"));
			 g=Integer.parseInt(request.getParameter("f"));
			 h=Integer.parseInt(request.getParameter("g"));
			 i=Integer.parseInt(request.getParameter("h"));

			
			 Drinks d1=new Drinks();
			 
			 try {
				Statement stmt1=d1.connect();
				

				if(a!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",41,'coke',"+a+",True);  ");
					
				}
				
				if(b!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",42,'sprite',"+b+",True);  ");
					
				}			
				
				if(c!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",43,'mango-maza',"+c+",True);  ");
					
				}
				
				
				if(d!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",44,'mirinda',"+d+",True);  ");
					
				}
				 if(f!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",45,'seven-up',"+f+",True);  ");
					
				}
				
				 if(g!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",46,'thumbs-up',"+g+",True);  ");
					
				}
				
				
				 if(h!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",47,'punjabi lassi',"+h+",True);  ");
					
				}
				
				 if(i!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",48,'mineral water',"+i+",True);  ");
					
				}
				
				response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
				
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			}
		}
	}
	
public Statement connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		Statement stmt=con.createStatement();
		return stmt;
	}
	

}
