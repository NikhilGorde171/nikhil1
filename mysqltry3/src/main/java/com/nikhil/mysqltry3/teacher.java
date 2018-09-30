package com.nikhil.mysqltry3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.nikhil.mysqltry5.*;
//import com.nikhil.mysqltry5.*;

class teacher extends Student {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		teacher t1=new teacher();
		principal p1=new principal();
		p1.connect();
		
		System.out.println("1-> update prenet students ");
		System.out.println("2->update passed students");
		
		System.out.println("3->update student marks");
		System.out.println("4->calculate avg student marks");
		
		System.out.println("Enter choice...!! ");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		
		switch(i){
		
		case 1:
			
				System.out.println("Enter new present stud RollNo.");
				int m=sc.nextInt();
				t1.update_present(m);
				break;
				
		case 2:
			
				//System.out.println("Enter new passed students");
				//int s=sc.nextInt();
				//p1.update_pass(s);
				//break;
				
		case 3:
				update_marks();
				break;
				
		case 4:
				Avg_marks();
				break;
			
		};//switch
		
		
		
		
	}//main
	
	private void update_present(int j) throws SQLException, ClassNotFoundException {
		
		principal p1 = new principal();
		Statement stmt=p1.connect();
		System.out.println("enter teacher id ");
		Scanner sc= new Scanner(System.in);
		int y=sc.nextInt();
		stmt.execute("update teacher set present_student="+j+" where id="+y+" ");
		teacher t1=new teacher();
		t1.display();
	}//update_fund
	
	public void display() throws ClassNotFoundException, SQLException {
		
		principal p1 = new principal();  
		Statement stmt=p1.connect(); 
		ResultSet rs=stmt.executeQuery("select * from teacher");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
	 
			}//display
	public void display_students() throws ClassNotFoundException, SQLException {
		
		
		display_student();
	}
	
}
