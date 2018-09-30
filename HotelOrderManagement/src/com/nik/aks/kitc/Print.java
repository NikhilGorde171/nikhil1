package com.nik.aks.kitc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.awt.print.*;
import javax.servlet.http.HttpSession;


public class Print extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		int p1=(int)session.getAttribute("tno");
		
		
		Print p=new Print();
		
		try {
			Statement stmt=p.connect();
			
			
			ResultSet rs=stmt.executeQuery("select neworder.name,neworder.quantity,price.price from neworder,price where neworder.tableno="+p1+" and neworder.menuid=price.menuid");
			
			
			
			
			
			
			GregorianCalendar gg=new GregorianCalendar();
			
			SimpleDateFormat dd=new SimpleDateFormat("dd/MM/YYYY");
			
			SimpleDateFormat ddd=new SimpleDateFormat("HH:mm");
			
			String header=""
					+"----------------------------------------------------------------------------------------------------\n;"
					+  "Date:"+dd.format(gg.getTime())+"                                                              Time:"+ddd.format(gg.getTime())+"\n;"
					+"      	                            *** Restaurant Bill Receipt ***                         \n;"
					+"----------------------------------------------------------------------------------------------------\n;"
					+"       Menu              	                       Qty                                       Amount   \n;"
					+"----------------------------------------------------------------------------------------------------\n;";
			
				int sum=0;
			//1st	
				
	/*		if(rs.next()) {
			
					String a1=rs.getString("name");
					int a2=rs.getInt("quantity");
					int a3=rs.getInt("price");
					int a4=a2*a3;
					sum=sum+a4;
				
			String amt=""
					+""+a1+"                "+a2+"                  "+a4+"\n;"
					+"\n";
			
				session.setAttribute("amt1", amt);
			}
			
			//2nd
			
			if(rs.next()) {
				
				String a1=rs.getString("name");
				int a2=rs.getInt("quantity");
				int a3=rs.getInt("price");
				int a4=a2*a3;
				sum=sum+a4;
			
		   String amt=""
				  +""+a1+"                "+a2+"                  "+a4+"\n;"
				+"\n";
		
			session.setAttribute("amt2", amt);
		}
		
			
		//3rd	
	if(rs.next()) {
				
				String a1=rs.getString("name");
				int a2=rs.getInt("quantity");
				int a3=rs.getInt("price");
				int a4=a2*a3;
				sum=sum+a4;
			
		   String amt=""
				  +""+a1+"                "+a2+"                  "+a4+"\n;"
				+"\n";
		
			session.setAttribute("amt3", amt);
		}
		
		//4th
	
	if(rs.next()) {
		
		String a1=rs.getString("name");
		int a2=rs.getInt("quantity");
		int a3=rs.getInt("price");
		int a4=a2*a3;
		sum=sum+a4;
	
   String amt=""
		          +""+a1+"                "+a2+"                  "+a4+"\n;"
		+"\n";

	session.setAttribute("amt4", amt);
}

	//5th
	if(rs.next()) {
		
		String a1=rs.getString("name");
		int a2=rs.getInt("quantity");
		int a3=rs.getInt("price");
		int a4=a2*a3;
		sum=sum+a4;
	
   String amt=""
		         +""+a1+"                "+a2+"                  "+a4+"\n;"
		+"\n";

	session.setAttribute("amt5", amt);
}
	
	*/
	//in while
	int i1=0;
	
	String str[]=new String[50];	
	
	while(rs.next()) {
		
		String a1=rs.getString("name");
		
		
		//for printing strings of equal size=30
		int l1=a1.length();
		int l2=30-l1;
		
		//creating empty char array of remaining length
		char barr[]=new char[30];
		for(int b1=0;b1<l2;b1++)
		{
			barr[b1]='\0';
			
		}
	
		
		
		String bs=new String(barr);
	
		
		//taking only specified vacant spaces to add to string since length of brrr is 30
		String sb1=bs.substring(0,l2-1);

		
		int a2=rs.getInt("quantity");
		int a3=rs.getInt("price");
		int a4=a2*a3;
		sum=sum+a4;
	
    str[i1]="  "+a1.concat(sb1)+  "                    "+a2+          "                                         "+a4+    "\n;";
		

    	i1++;
    	
	
}
		
	//not adding void spaces will print 'null' string in last empty spots
	for(int i3=0;i3<str.length;i3++)
	{
		
		if(str[i3]==null) {
			
			str[i3]="";
		}
		
	}
	
	
			
			
			String foot="\n;"
					+"----------------------------------------------------------------------------------------------------\n;"
					+"                                       Total amount: "+sum+    "                                    \n;"
					+"----------------------------------------------------------------------------------------------------\n;"
					+"****************************************************************************************************\n;"
					+"--------------------------------------Thanx For Visiting Our Restuarant-----------------------------\n;"
					+"****************************************************************************************************\n;";
					
			
		/*
			String amt1=(String)session.getAttribute("amt1");
			String amt2=(String)session.getAttribute("amt2");
			String amt3=(String)session.getAttribute("amt3");
			String amt4=(String)session.getAttribute("amt4");
			String amt5=(String)session.getAttribute("amt5");
			
		*/	String total="";
			int i2=0;
			while(i2<str.length) {
			total=total+str[i2];
			i2++;
			}
			//String zbill=header+amt1+amt2+amt3+amt4+amt5+foot;
			
			String zbill=header+total+foot;
			printnow.printCard(zbill);
			
			//delete 
			//Statement stmt1 =p.connect();
			stmt.execute("delete from orderinfo where tableno="+p1+"");
			stmt.execute("delete from neworder where tableno="+p1+"");
			
			
			response.sendRedirect("http://localhost:8080/HotelOrderManagement/Tabsum.jsp");
			
			
			session.invalidate();

		
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
