package BankMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import java.io.*;
import java.sql.*;
import java.sql.SQLException;


public class CurdBank {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		
		try {
			
			Scanner myObj = new Scanner(System.in);
			Random rand = new Random(); 
			
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
			
			 System.out.println("Please Enter Your details");
				
				System.out.println("Please Enter Your Name");
				names=myObj.next();
			
				System.out.println("Please Enter Your dobs");
				dob=myObj.next();
				
				System.out.println("Please Enter Your Account Type you want to open?");
				accType=myObj.next();
				
				System.out.println("Please Enter Your Deposits");
				balance=myObj.nextDouble();
				
				System.out.println("Please Enter Your salary");
				salary=myObj.nextDouble();

				System.out.println("Please Enter 6 Digit Security Pin");
				secPin=myObj.nextLong();
				
				String start = "";
		        Random value = new Random();
				
				 int r1 = value.nextInt(10);
				    int r2 = value.nextInt(10);
				    start += Integer.toString(r1) + Integer.toString(r2);

				    System.out.println(start);
				    int count = 0;
				    int n = 0;
				    for(int m =0; m < 4;m++)
				    {
				        if(count == 4)
				        {
				            start +="";
				            count =0;
				        }
				        else 
				            n = value.nextInt(10);
				            start += Integer.toString(n);
				            count++;            

				    }
				 
				    long l=Long.parseLong(start);  
				 
					ids=l;	
					System.out.println("This is Your Permanent Account Number Please Remember It");
					System.out.println(ids);
					
		
			
			//PreparedStatement updateEmp=con.prepareStatement("Insert into newCustomer values(?,?,?)");
			PreparedStatement updateEmp=con.prepareStatement("insert into newCustomer "+ " (names,ids,dob,accType,balance,salary,secPin)" + " values (?, ?, ?, ?, ?, ?, ?)");
			//updateEmp.setInt(1,1);
			//updateEmp.setString(2,"Manoj");
			//updateEmp.setString(3,"BCA");
			
			updateEmp.setString(1, names);
			updateEmp.setLong(2, ids);
			updateEmp.setString(3, dob);
			updateEmp.setString(4, accType);
			updateEmp.setDouble(5, balance);
			updateEmp.setDouble(6, salary);
			updateEmp.setLong(7, secPin);
			
			
		
			
			updateEmp.executeUpdate();
			
			stmt=con.createStatement();
			
			String query="select * from newCustomer";
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("names ids dobs accTypes deposits salarys security");
			
			while(rs.next())	
{
			
			String name=rs.getString("names");
			long id=rs.getInt("ids");
			String dobs=rs.getString("dob");
			String accountType=rs.getString("accType");
			String bal=rs.getString("balance");
			String salarys=rs.getString("salary");
			String sec=rs.getString("secPin");
			
			System.out.println(id + " " + name + " " + dobs+ "  " + accountType + " " + bal + " " + salarys + "  " + sec);
			
					

}
			
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
				
			/*
			 while(rs2.next())	
				{
					
					
					int flag=1;
					System.out.println("You have 3 Attempt for successful login");
					
								
									if(pNum==rs2.getInt("secPin"))
									{
											if(number==rs2.getInt("ids"))
											{
													
													

												String name=rs2.getString("names");
												long id=rs2.getInt("ids");
												String dobs=rs2.getString("dob");
												String accountType=rs2.getString("accType");
												String bal=rs2.getString("balance");
												String salarys=rs2.getString("salary");
												long sec=rs2.getInt("secPin");
												
												System.out.println(id + " " + name + " " + dobs+ "  " + accountType + " " + bal + " " + salarys + "  " + sec);
										
												
											}
											else
											{
												
												System.out.println("Please Check Your Account No");
												flag=0;
											}
									}
									else
									{
											
											System.out.println("Please Check Your Account No and Security Pin");
											flag=0;
									}
							
								
								
					
					
						/*	String name=rs2.getString("names");
							long id=rs2.getInt("ids");
							String dobs=rs2.getString("dob");
							String accountType=rs2.getString("accType");
							String bal=rs2.getString("balance");
							String salarys=rs2.getString("salary");
							long sec=rs2.getInt("secPin");
							
							System.out.println(id + " " + name + " " + dobs+ "  " + accountType + " " + bal + " " + salarys + "  " + sec);
					
									

				}*/
			 
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
			 
			 /*
			 if (rs.next() == false) 
			 { 
				 
				 System.out.println("Please Check Your Account No and Security Pin");
				 
			 }
			 else
			 { 
				 
				 do 
				 { 
					 String name=rs2.getString("names");
						long id=rs2.getInt("ids");
						String dobs=rs2.getString("dob");
						String accountType=rs2.getString("accType");
						String bal=rs2.getString("balance");
						String salarys=rs2.getString("salary");
						long sec=rs2.getInt("secPin");
						
						System.out.println(id + " " + name + " " + dobs+ "  " + accountType + " " + bal + " " + salarys + "  " + sec);
				
					 
				 } while (rs.next()); 
			}*/

			 
			
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getName()+":" + e.getMessage());
			System.exit(0);
		}
		System.out.println("Sucess");
		// TODO Auto-generated method stub
	}

}
