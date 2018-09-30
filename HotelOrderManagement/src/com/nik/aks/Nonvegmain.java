package com.nik.aks;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;




public class Nonvegmain extends HttpServlet {
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
		
		 
		 Nonvegmain n1=new Nonvegmain();
		
		
		 try {
			Statement stmt1=n1.connect();
			
			

			if(a!=0) {
				
				stmt1.execute("insert into neworder values("+p+",17,'chiken tikka masala',"+a+",True);  ");
				
			}
			
			if(b!=0) {
				
				stmt1.execute("insert into neworder values("+p+",18,'chicken keema',"+b+",True);  ");
				
			}			
			
			if(c!=0) {
				
				stmt1.execute("insert into neworder values("+p+",19,'chicken hyderabadi',"+c+",True);  ");
				
			}
			
			
			if(d!=0) {
				
				stmt1.execute("insert into neworder values("+p+",20,'chiken lasuni',"+d+",True);  ");
				
			}
			 if(f!=0) {
				
				stmt1.execute("insert into neworder values("+p+",21,'chiken handi',"+f+",True);  ");
				
			}
			
			 if(g!=0) {
				
				stmt1.execute("insert into neworder values("+p+",22,'anda curry',"+g+",True);  ");
				
			}
			
			
			 if(h!=0) {
				
				stmt1.execute("insert into neworder values("+p+",23,'mutton masala',"+h+",True);  ");
				
			}
			
			 if(i!=0) {
				
				stmt1.execute("insert into neworder values("+p+",24,'mutton bhuna',"+i+",True);  ");
				
			}
			
			response.sendRedirect("http://localhost:8080/HotelOrderManagement/");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
		}//1st if 
		}	 
		
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
			
			 
			 Nonvegmain n1=new Nonvegmain();
			
			
			 try {
				Statement stmt1=n1.connect();
				
				

				if(a!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",17,'chiken tikka masala',"+a+",True);  ");
					
				}
				
				if(b!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",18,'chicken keema',"+b+",True);  ");
					
				}			
				
				if(c!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",19,'chicken hyderabadi',"+c+",True);  ");
					
				}
				
				
				if(d!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",20,'chiken lasuni',"+d+",True);  ");
					
				}
				 if(f!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",21,'chiken handi',"+f+",True);  ");
					
				}
				
				 if(g!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",22,'anda curry',"+g+",True);  ");
					
				}
				
				
				 if(h!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",23,'mutton masala',"+h+",True);  ");
					
				}
				
				 if(i!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",24,'mutton bhuna',"+i+",True);  ");
					
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
