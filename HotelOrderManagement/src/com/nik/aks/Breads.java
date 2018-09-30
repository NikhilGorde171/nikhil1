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


public class Breads extends HttpServlet {
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
	

		 Breads b1=new Breads();
		 try {
			Statement stmt1=b1.connect();
			

			if(a!=0) {
				
				stmt1.execute("insert into neworder values("+p+",57,'plain roti',"+a+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",57,'plain roti',"+a+");  ");
			}
			
			if(b!=0) {
				
				stmt1.execute("insert into neworder values("+p+",58,'butter roti',"+b+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",58,'butter roti',"+b+");  ");
				
			}			
			
			if(c!=0) {
				
				stmt1.execute("insert into neworder values("+p+",59,'plain naan',"+c+",True);  ");
			//	stmt1.execute("insert into kitchenorder values("+p+",59,'plain naan',"+c+");  ");
			}
			
			
			if(d!=0) {
				
				stmt1.execute("insert into neworder values("+p+",60,'butter naan',"+d+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",60,'butter naan',"+d+");  ");
			}
			 if(f!=0) {
				
				stmt1.execute("insert into neworder values("+p+",61,'bajra bhakari',"+f+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",61,'bajra bhakari',"+f+");  ");
			}
			
			 if(g!=0) {
				
				stmt1.execute("insert into neworder values("+p+",62,'plain paratha',"+g+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",62,'plain paratha',"+g+");  ");
			}
			
			
			 if(h!=0) {
				
				stmt1.execute("insert into neworder values("+p+",63,'chapati',"+h+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",63,'chapati',"+h+");  ");
			}
			
			 if(i!=0) {
				
				stmt1.execute("insert into neworder values("+p+",64,'jwari bhakari',"+i+",True);  ");
				//stmt1.execute("insert into kitchenorder values("+p+",64,'jwari bhakari',"+i+");  ");
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
			

				 Breads b1=new Breads();
				 try {
					Statement stmt1=b1.connect();
					

					if(a!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",57,'plain roti',"+a+",True);  ");
						
					}
					
					if(b!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",58,'butter roti',"+b+",True);  ");
						
					}			
					
					if(c!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",59,'plain naan',"+c+",True);  ");
						
					}
					
					
					if(d!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",60,'butter naan',"+d+",True);  ");
						
					}
					 if(f!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",61,'bajra bhakari',"+f+",True);  ");
						
					}
					
					 if(g!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",62,'plain paratha',"+g+",True);  ");
						
					}
					
					
					 if(h!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",63,'chapati',"+h+",True);  ");
						
					}
					
					 if(i!=0) {
						
						stmt1.execute("insert into neworder values("+p1+",64,'jwari bhakari',"+i+",True);  ");
						
					}
					
					response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
					
				} catch (ClassNotFoundException | SQLException e) {
				
					e.printStackTrace();
				}
			 
			 
			 
			 
			 
			 
			 
			 
			 
				}
			 
			 
			 
			 
			 
		 }//2nd if
		 
		 
	}

public Statement connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelorder","root","admin");  
		Statement stmt=con.createStatement();
		return stmt;
	}
		
}
