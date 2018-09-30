package com.nik.aks;


import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;


public class Vegmain extends HttpServlet {
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
		
		
		
		
		Vegmain v1=new Vegmain();
		
		try {
			Statement stmt1=v1.connect();
			
			if(a!=0) {
				
				stmt1.execute("insert into neworder values("+p+",9,'panner buttor masala',"+a+",True);  ");
				
			}
			
			if(b!=0) {
				
				stmt1.execute("insert into neworder values("+p+",10,'paneer tikka',"+b+",True);  ");
				
			}			
			
			if(c!=0) {
				
				stmt1.execute("insert into neworder values("+p+",11,'paneer makhanwala',"+c+",True);  ");
				
			}
			
			
			if(d!=0) {
				
				stmt1.execute("insert into neworder values("+p+",12,'paneer rajwadi',"+d+",True);  ");
				
			}
			 if(f!=0) {
				
				stmt1.execute("insert into neworder values("+p+",13,'mashroom masala',"+f+",True);  ");
				
			}
			
			 if(g!=0) {
				
				stmt1.execute("insert into neworder values("+p+",14,'aloo muttor',"+g+",True);  ");
				
			}
			
			
			 if(h!=0) {
				
				stmt1.execute("insert into neworder values("+p+",15,'veg chili mili',"+h+",True);  ");
				
			}
			
			 if(i!=0) {
				
				stmt1.execute("insert into neworder values("+p+",16,'kaju curry',"+i+",True);  ");
				
			}
			
			response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
	
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}
		}//1stif
		
		
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
			
			
			
			
			Vegmain v1=new Vegmain();
			
			try {
				Statement stmt1=v1.connect();
				
				if(a!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",9,'panner buttor masala',"+a+",True);  ");
					
				}
				
				if(b!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",10,'paneer tikka',"+b+",True);  ");
					
				}			
				
				if(c!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",11,'paneer makhanwala',"+c+",True);  ");
					
				}
				
				
				if(d!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",12,'paneer rajwadi',"+d+",True);  ");
					
				}
				 if(f!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",13,'mashroom masala',"+f+",True);  ");
					
				}
				
				 if(g!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",14,'aloo muttor',"+g+",True);  ");
					
				}
				
				
				 if(h!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",15,'veg chili mili',"+h+",True);  ");
					
				}
				
				 if(i!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",16,'kaju curry',"+i+",True);  ");
					
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
