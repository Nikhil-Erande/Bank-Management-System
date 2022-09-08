package BankMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;


public class fetchBank {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		
		try {
			
			Scanner myObj = new Scanner(System.in);
	 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank","root","");
			
			System.out.println("Opened Database Successfully");
			String names;
			long ids;
			 String dob;			
			 String accType;
			double balance;
			 double salary;
			 long secPin;
		

			stmt=con.createStatement();
			
	
			
			System.out.println("Enter The Account No and Security Pin To Check The Details ");
			System.out.println("Enter The Account No");
			long number=myObj.nextLong();
			System.out.println("Enter The 6 Digit Security Pin");
			long pNum=myObj.nextLong();
			
			 String query2 = "SELECT * FROM newCustomer WHERE ids= ? and secPin= ?";
			 PreparedStatement fetchRec = con.prepareStatement(query2);
			 fetchRec.setLong(1, number);
			 fetchRec.setLong(2, pNum);
			 ResultSet rs2= fetchRec.executeQuery();
				
			
			 
			 if (!rs2.next() ) {
				 System.out.println("Please Check Your Account No and Security Pin");
				} 
			 else {

				    do {
				    	String name=rs2.getString("names");
						long id=rs2.getInt("ids");
						String dobs=rs2.getString("dob");
						String accountType=rs2.getString("accType");
						String bal=rs2.getString("balance");
						String salarys=rs2.getString("salary");
						long sec=rs2.getInt("secPin");
						
						System.out.println(id + " " + name + " " + dobs+ "  " + accountType + " " + bal + " " + salarys + "  " + sec);
				    } while (rs2.next());
				}
			 
			
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getName()+":" + e.getMessage());
			System.exit(0);
		}
		System.out.println("Sucess");
		
	}

}
