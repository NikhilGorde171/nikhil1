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

public class Dessert extends HttpServlet {
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

		
		 Dessert s1=new Dessert();
		 try {
			Statement stmt1=s1.connect();
			

			if(a!=0) {
				
				stmt1.execute("insert into neworder values("+p+",33,'solkadhi',"+a+",True);  ");
				
			}
			
			if(b!=0) {
				
				stmt1.execute("insert into neworder values("+p+",34,'chocalate milkshake',"+b+",True);  ");
				
			}			
			
			if(c!=0) {
				
				stmt1.execute("insert into neworder values("+p+",35,'vanilla milkshake',"+c+",True);  ");
				
			}
			
			
			if(d!=0) {
				
				stmt1.execute("insert into neworder values("+p+",36,'cad[medium]',"+d+",True);  ");
				
			}
			 if(f!=0) {
				
				stmt1.execute("insert into neworder values("+p+",37,'cold coffee',"+f+",True);  ");
				
			}
			
			 if(g!=0) {
				
				stmt1.execute("insert into neworder values("+p+",38,'sweet plate',"+g+",True);  ");
				
			}
			
			
			 if(h!=0) {
				
				stmt1.execute("insert into neworder values("+p+",39,'ice-cream',"+h+",True);  ");
				
			}
			
			 if(i!=0) {
				
				stmt1.execute("insert into neworder values("+p+",40,'limbu-sarbat',"+i+",True);  ");
				
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

			
			 Dessert s1=new Dessert();
			 try {
				Statement stmt1=s1.connect();
				

				if(a!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",33,'solkadhi',"+a+",True);  ");
					
				}
				
				if(b!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",34,'chocalate milkshake',"+b+",True);  ");
					
				}			
				
				if(c!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",35,'vanilla milkshake',"+c+",True);  ");
					
				}
				
				
				if(d!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",36,'cad[medium]',"+d+",True);  ");
					
				}
				 if(f!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",37,'cold coffee',"+f+",True);  ");
					
				}
				
				 if(g!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",38,'sweet plate',"+g+",True);  ");
					
				}
				
				
				 if(h!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",39,'ice-cream',"+h+",True);  ");
					
				}
				
				 if(i!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",40,'limbu-sarbat',"+i+",True);  ");
					
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
