package com.nikhil.mysqltry4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.nikhil.mysqltry3.principal;

//import com.nikhil.mysqltry3.principal;

public class pinfo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		pinfo p2=new pinfo();
		System.out.println("1-> update examrooms ");
		//System.out.println("2->update benches");

		System.out.println("Enter choice...!! ");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		
		switch(i){
		
		case 1:
			
				System.out.println("Enter new examrooms");
				int m=sc.nextInt();
				p2.update_examrooms(m);
				break;
				
		/*case 2:
			
				System.out.println("Enter new complaints");
				int s=sc.nextInt();
				p2.update_complaints(s);
				break;
			*/	
		};
		
		
	}
	
	
	public Statement connect() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","admin");  //here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement(); 
		return stmt;
	}//connect
	
	protected static void disp() throws ClassNotFoundException, SQLException {
		
		pinfo p1=new pinfo();  
		Statement stmt=p1.connect(); 
		ResultSet rs=stmt.executeQuery("select * from peon");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4));
	 
			}//display

	
	private void update_examrooms(int j) throws SQLException, ClassNotFoundException {
		
		pinfo p3 = new pinfo();
		System.out.println("enter peon id ");
		Scanner sc= new Scanner(System.in);
		int y=sc.nextInt();
		Statement stmt=p3.connect();
		stmt.execute("update peon set examrooms="+j+" where id="+y+" ");
		p3.disp();
	}//update_fund
	
	
}
