package com.nikhil.mysqltry3;
import java.sql.*;
import java.util.*;
import com.nikhil.mysqltry4.*;

class principal extends pinfo{

			//private int id;
			//private String name;
			//private int school_fund;
			//private int complaints
		
			public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
				try {
					
					
					pinfo p2=new pinfo();
					principal p1 = new principal();
					System.out.println("1-> update school fund ");
					System.out.println("2->update complaints");
					System.out.println("3->access peon report");
					System.out.println("4->access teacher report");
					System.out.println("5->access student report");
					
					
					System.out.println("Enter choice...!! ");
					Scanner sc=new Scanner(System.in);
					int i=sc.nextInt();
					
					
					switch(i){
						
					case 1:
						
							System.out.println("Enter new school_fund");
							int m=sc.nextInt();
							p1.update_fund(m);
							break;
							
					case 2:
						
							System.out.println("Enter new complaints");
							int s=sc.nextInt();
							p1.update_complaints(s);
							break;
							
					case 3:
						
							disp();
							break;
							
					case 4:
							teacher t1=new teacher();
							t1.display();
							break;
							
					case 5:
							teacher t2=new teacher();
							t2.display_students();
							break;
					};
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}

			
			}//main

		
			
			public Statement connect() throws ClassNotFoundException, SQLException{
				
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","admin");  //here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement(); 
				return stmt;
			}//connect
			
			
			
			
			
			private void display() throws ClassNotFoundException, SQLException {
				
				principal p1 = new principal();  
				Statement stmt=p1.connect(); 
				ResultSet rs=stmt.executeQuery("select * from principal");  
				while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4));
			 
					}//display

			
			
			private void update_fund(int j) throws SQLException, ClassNotFoundException {
				
				principal p1 = new principal();
				Statement stmt=p1.connect();
				stmt.execute("update principal set school_funds="+j+"");
				p1.display();
			}//update_fund
	
			private void update_complaints(int k) throws ClassNotFoundException, SQLException {
				
				principal p1 = new principal();
				Statement stmt=p1.connect();
				stmt.execute("update principal set complaints="+k+"");
				p1.display();
			}//complaints
			
			
			
}//class
