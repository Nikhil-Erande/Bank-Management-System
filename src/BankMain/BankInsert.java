package BankMain;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;
public class BankInsert {
	static newCustomer n1;
	public static void main(String[] args) {
	
		try
		{
		Scanner myObj = new Scanner(System.in);
		Random rand = new Random(); 
		
		
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);	
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
			System.out.println("Hello New User");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank","root","");
			Statement myStmt=con.createStatement();
			String names;
			long ids;
			 String dobs;			String accTypes;
			double deposits;
			 double salarys;
			 long security;
			 long secu1;
			 long secu2;
			 long secu3;
			 
				System.out.println("Please Enter Your details");
				
				System.out.println("Please Enter Your Name");
				names=myObj.next();
			
				System.out.println("Please Enter Your dobs");
				dobs=myObj.next();
				
				System.out.println("Please Enter Your Account Type you want to open?");
				accTypes=myObj.next();
				
				System.out.println("Please Enter Your Deposits");
				deposits=myObj.nextDouble();
				
				System.out.println("Please Enter Your salary");
				salarys=myObj.nextDouble();

				System.out.println("Please Enter 6 Digit Security Pin");
				security=myObj.nextLong();
				
				String start = "";
		        Random value = new Random();

		    //Generate two values to append to 'BE'
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
			
			String sql = "insert into newCustomer "
					+ " (names,ids,dob,accType,balance,salary,secPin)" + " values (?, ?, ?, ?, ?, ?, ?)";
			//n1=new newCustomer(names,ids,dobs,accTypes,deposits,salarys,security);
			
			myStmt= con.prepareStatement(sql);
			((PreparedStatement) myStmt).setString(1, names);
			((PreparedStatement) myStmt).setLong(2, ids);
			((PreparedStatement) myStmt).setString(3, dobs);
			((PreparedStatement) myStmt).setString(4, accTypes);
			((PreparedStatement) myStmt).setDouble(5, deposits);
			((PreparedStatement) myStmt).setDouble(6, salarys);
			((PreparedStatement) myStmt).setLong(7, security);
			
			myStmt.executeUpdate(sql);
			
			myStmt.close();
			con.close();
			
			break;
		}


	}

}
		catch(Exception e)
		{
			
			System.out.println("Connection Error");
		}

	}
	
}