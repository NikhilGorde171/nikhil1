package com.nik.aks;

import javax.servlet.http.*;
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

public class Starter extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		
		//int p=Integer.parseInt(z);
	
		if(session.getAttribute("tableno")!=null) {
		
			
			int p=(int)session.getAttribute("tableno");
			
			if(p!=0) {
				
				
				
		int a,b,c,d,f,g,h,i=0;
		
		 a=Integer.parseInt(request.getParameter("TS"));
		 b=Integer.parseInt(request.getParameter("VCS"));
		 c=Integer.parseInt(request.getParameter("VNS"));
		 d=Integer.parseInt(request.getParameter("SCS"));
		 f=Integer.parseInt(request.getParameter("PS"));
		 g=Integer.parseInt(request.getParameter("MP"));
		 h=Integer.parseInt(request.getParameter("NVS"));
		 i=Integer.parseInt(request.getParameter("CF"));
		
		/* System.out.println("a="+a);
		 System.out.println("b="+b);
		 System.out.println("c="+c);
		 System.out.println("d="+d);
		 System.out.println("f="+f);
		 System.out.println("g="+g);
		 System.out.println("h="+h);
		 System.out.println("i="+i);
		*/
		 
		 
		Starter s1=new Starter();
		try {
			Statement stmt1=s1.connect();
			
			
			if(a!=0) {
				
				stmt1.execute("insert into neworder values("+p+",1,'tomato soup',"+a+",True);  ");
				
			}
			
			if(b!=0) {
				
				stmt1.execute("insert into neworder values("+p+",2,'veg clear soup',"+b+",True);  ");
				
			}			
			
			if(c!=0) {
				
				stmt1.execute("insert into neworder values("+p+",3,'Veg noodle Soup',"+c+",True);  ");
				
			}
			
			
			if(d!=0) {
				
				stmt1.execute("insert into neworder values("+p+",4,'sweet corn soup',"+d+",True);  ");
				
			}
			 if(f!=0) {
				
				stmt1.execute("insert into neworder values("+p+",5,'paneer sisxtyfive',"+f+",True);  ");
				
			}
			
			 if(g!=0) {
				
				stmt1.execute("insert into neworder values("+p+",6,'masala papad',"+g+",True);  ");
				
			}
			
			
			 if(h!=0) {
				
				stmt1.execute("insert into neworder values("+p+",7,'non veg soup',"+h+",True);  ");
				
			}
			
			 if(i!=0) {
				
				stmt1.execute("insert into neworder values("+p+",8,'chicken fry',"+i+",True);  ");
				
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
			
			 a=Integer.parseInt(request.getParameter("TS"));
			 b=Integer.parseInt(request.getParameter("VCS"));
			 c=Integer.parseInt(request.getParameter("VNS"));
			 d=Integer.parseInt(request.getParameter("SCS"));
			 f=Integer.parseInt(request.getParameter("PS"));
			 g=Integer.parseInt(request.getParameter("MP"));
			 h=Integer.parseInt(request.getParameter("NVS"));
			 i=Integer.parseInt(request.getParameter("CF"));
			
			/* System.out.println("a="+a);
			 System.out.println("b="+b);
			 System.out.println("c="+c);
			 System.out.println("d="+d);
			 System.out.println("f="+f);
			 System.out.println("g="+g);
			 System.out.println("h="+h);
			 System.out.println("i="+i);
			*/
			 
			 
			Starter s1=new Starter();
			try {
				Statement stmt1=s1.connect();
				
				
				if(a!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",1,'tomato soup',"+a+",True);  ");
					
				}
				
				if(b!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",2,'veg clear soup',"+b+",True);  ");
					
				}			
				
				if(c!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",3,'Veg noodle Soup',"+c+",True);  ");
					
				}
				
				
				if(d!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",4,'sweet corn soup',"+d+",True);  ");
					
				}
				 if(f!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",5,'paneer sisxtyfive',"+f+",True);  ");
					
				}
				
				 if(g!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",6,'masala papad',"+g+",True);  ");
					
				}
				
				
				 if(h!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",7,'non veg soup',"+h+",True);  ");
					
				}
				
				 if(i!=0) {
					
					stmt1.execute("insert into neworder values("+p1+",8,'chicken fry',"+i+",True);  ");
					
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
