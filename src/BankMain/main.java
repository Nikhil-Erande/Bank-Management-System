package BankMain;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class main {
	


	public static void main(String[] args) throws SQLException {
		
		
		Scanner myObj = new Scanner(System.in);
		Random rand = new Random(); 
		Connection con=null;
		Statement stmt=null;
			
		inner:for(;;)
		{
		System.out.println("Hello User");
		
		System.out.println("Please Enter Your Choice");
		System.out.println("1.New User");
		System.out.println("2.Old User");
		System.out.println("3.Exit");
		int i=myObj.nextInt();
		switch(i)
		{
		
		case 1:
			System.out.println("********Bank Management******");
			System.out.println("Hello New User");
			try {
				
				
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

					    //System.out.println(start);
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
						
			
				PreparedStatement updateEmp=con.prepareStatement("insert into newCustomer "+ " (names,ids,dob,accType,balance,salary,secPin)" + " values (?, ?, ?, ?, ?, ?, ?)");
				
				
				updateEmp.setString(1, names);
				updateEmp.setLong(2, ids);
				updateEmp.setString(3, dob);
				updateEmp.setString(4, accType);
				updateEmp.setDouble(5, balance);
				updateEmp.setDouble(6, salary);
				updateEmp.setLong(7, secPin);
				
				
			
				
				updateEmp.executeUpdate();
				
				stmt=con.createStatement();
		
			
				
			}
			catch(Exception e)
			{
				System.out.println(e.getClass().getName()+":" + e.getMessage());
				System.exit(0);
			}
			System.out.println("Sucess");
			// TODO Auto-generated method stub
			
			
		//	stmt.close();
			//con.close();
			
			break;
		case 2:
			
				
		
			try {
				 
					
					int p;
					double w;
					double d;
					int c;
					long secu1;
					 long secu2;
					 long secu3;
					 int flag=1;
					 
				
					 c=flag;
				
			 
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank","root","");
					System.out.println("Opened Database Successfully");
				

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
						
					   	String name;
						long id;
						String dobs;
						String accountType;
						Double bal;
						String salarys;
						long seco;
					 
					 if (!rs2.next() ) {
						 System.out.println("Please Check Your Account No and Security Pin");
						 break;
						} 
					 else {
						 System.out.println("id      " +   " name       "  + " dobs      "  + " accType    "    +  " bal    "  + " salarys   ");
						    do {
						    	
						    	name=rs2.getString("names");
								id=rs2.getInt("ids");
								dobs=rs2.getString("dob");
								accountType=rs2.getString("accType");
								bal=rs2.getDouble("balance");
								salarys=rs2.getString("salary");
								seco=rs2.getInt("secPin");
								
								System.out.println(id + "   "   +name +  "  " + dobs   + "   "   +  accountType   + "  "    + bal     +   "  "   + salarys   +   "    "   +seco);
						    } while (rs2.next());
						 
					
					 if(c==1)
						{	
						
					
						outer:for(;;)
						{
							System.out.println("\n");
							System.out.println("********Bank Management******");
							System.out.println("Please Enter Accordingly");
							System.out.println("1.Withdraw");
							System.out.println("2.Deposit");
							System.out.println("3.Checked Current Balance");
							System.out.println("4.Log Out");
							p=myObj.nextInt();
						switch(p)
						{
						
						case 1:
							System.out.println("Please Enter 6 digit Security Pin Number");
							secu2=myObj.nextLong();
							
							if(bal!=0)
							{
							if(seco==secu2)
							{
									System.out.println("How Much Money You want to withdrawn");
									w=myObj.nextDouble();
									if(bal<w)
									{
										System.out.println("You cant Withdrawn More Than Your Balance");
										break;
									}
									double wid=bal-w;
									String query3="UPDATE newCustomer SET balance=? WHERE secPin=? and ids=?";
									PreparedStatement updateRec = con.prepareStatement(query3);
									updateRec.setDouble(1,wid);
									updateRec.setLong(2,secu2);
									updateRec.setLong(3, id);
									System.out.println("Money Withdrawn SuccessFully");	
									int z= updateRec.executeUpdate();
									System.out.println(z + " Records Updated");
							
									String query4 = "SELECT balance FROM newCustomer WHERE ids= ? and secPin= ?";
									PreparedStatement fetchbal1 = con.prepareStatement(query2);
									fetchbal1.setLong(1, id);
									fetchbal1.setLong(2, secu2);
							 		ResultSet rs3= fetchbal1.executeQuery();
							
								
							 
							 		while(rs3.next())	
							 		{
											
							 			double temp=rs3.getDouble("balance");
							 			System.out.println("Current Balance is:- " + temp);	
							 			bal=temp;				

							 		}
								
							
							 		break;
							}
							else
							{
									System.out.println("Please Check Your Security Pin");
									break;
							}
							}
							else
							{
								System.out.println("Your Balance is zero...You cant Withdrawn");
								break;
							}
							
						case 2:
							
							System.out.println("Please Enter 6 digit Security Pin Number");
							secu3=myObj.nextLong();
							
							if(seco==secu3)
							{
									System.out.println("How Much Money You want to Deposit");
									d=myObj.nextDouble();
									double dep=bal+d;
									String query3="UPDATE newCustomer SET balance=? WHERE secPin=? and ids=?";
									PreparedStatement updateRec = con.prepareStatement(query3);
									updateRec.setDouble(1,dep);
									updateRec.setLong(2,secu3);
									updateRec.setLong(3, id);
									System.out.println("Money Deposited SuccessFully");	
									int l= updateRec.executeUpdate();
									System.out.println(l + " Records Updated");
							
									String query4 = "SELECT balance FROM newCustomer WHERE ids= ? and secPin= ?";
									PreparedStatement fetchbal2 = con.prepareStatement(query4);
									fetchbal2.setLong(1, id);
									fetchbal2.setLong(2, secu3);
									ResultSet rs4= fetchbal2.executeQuery();
							
								
							 
									while(rs4.next())	
									{
											
										double temp=rs4.getDouble("balance");
										System.out.println("Current Balance is:- " + temp);	
										bal=temp;				

									}
								
							
						
									break;
							}
							else
							{
									System.out.println("Please Check Your Security Pin");
									;
							}
							
						
						case 3:
							
								System.out.println("Please Enter 6 digit Security Pin Number");
								secu1=myObj.nextLong();
							
							if(seco==secu1)
							{
							
						
									String query5 = "SELECT balance FROM newCustomer WHERE ids= ? and secPin= ?";
									PreparedStatement fetchbal5 = con.prepareStatement(query5);
									fetchbal5.setLong(1, id);
									fetchbal5.setLong(2, secu1);
									ResultSet rs5= fetchbal5.executeQuery();
							
								
							 
									while(rs5.next())	
									{
											
											double temp=rs5.getDouble("balance");
											System.out.println("Current Balance is:- " + temp);	
											bal=temp;				

									}
								
							
						
									break;
							}
							else
							{
									System.out.println("Please Check Your Security Pin");
									break;
							}
							
							
						case 4:
							 
							break outer; // breaks the while-loop
		            
						
							
							}
						 
						}
					  }
							continue inner;
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getClass().getName()+":" + e.getMessage());
					System.exit(0);
				}
				System.out.println("Sucess");
				
		
			
				
				
			
		case 3:
			System.out.println("Thank You for visiting us.");
			return;
		
				
			}
			
		
		}
	
		
	}

}
