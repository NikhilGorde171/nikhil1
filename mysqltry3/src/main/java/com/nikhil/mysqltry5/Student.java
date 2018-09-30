package com.nikhil.mysqltry5;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.math.*;

import com.nikhil.mysqltry4.*;

public class Student {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
	}
	
	protected static void update_marks() throws SQLException, ClassNotFoundException {
		
		Student s1=new Student();
		System.out.println("enter student id");
		Scanner sc=new Scanner(System.in);
		int z=sc.nextInt();
		
		System.out.println("enter marks of sub1");
		int a=sc.nextInt();
		System.out.println("enter marks of sub2");
		int b=sc.nextInt();
		System.out.println("enter marks of sub2");
		int c=sc.nextInt();
		
		pinfo p6=new pinfo();
		Statement stmt=p6.connect();
		stmt.execute("update student set sub1="+a+",sub2="+b+",sub3="+c+" where id="+z+"");
		
		s1.display_student();
		
	}//update_marks
	
	protected void display_student() throws ClassNotFoundException, SQLException {
		
		pinfo p6=new pinfo();
		Statement stmt=p6.connect();
		ResultSet rs=stmt.executeQuery("select * from student");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getBoolean(6));
	 
			}//display
	
	
	
	protected static void Avg_marks() throws ClassNotFoundException, SQLException{
		
	
		pinfo p6=new pinfo();
		Statement stmt=p6.connect();
		Student s1=new Student();
		System.out.println("enter student id");
		Scanner sc=new Scanner(System.in);
		int z=sc.nextInt();
		ResultSet rs=stmt.executeQuery("select sub1,sub2,sub3 from student where id="+z+"");  
		//while(rs.next())  
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getBoolean(6));
		//int a=rs.getInt(3);
		if(rs.next()) {
			
			int m1=rs.getInt("sub1");
			int m2=rs.getInt("sub2");
			int m3=rs.getInt("sub3");
			
			float m4=(m1+m2+m3)/3;
			System.out.println("avg mark of stud with id"+z+" = "+m4+"");
			
		}
		
		
		
	}//avg_marks 
	
	
	
	

}
