package BankMain;

public class newCustomer {
	
	
	public String name;
	public long id;
	public String dob;
	public String accType;
	public double deposit;
	public double salary;
	private long securityPin;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getSecurityPin() {
		return securityPin;
	}
	public void setSecurityPin(long securityPin) {
		this.securityPin = securityPin;
	}
	
	public newCustomer(String name, long id, String dob, String accType, double deposit, double salary,long securityPin) {
		super();
		this.name = name;
		this.id = id;
		this.dob = dob;
		this.accType = accType;
		this.deposit = deposit;
		this.salary = salary;
		this.securityPin = securityPin;
	}
	
		
		public int display(long accountNo,long sec)
		{	
			int flag=1;
			System.out.println("You have 3 Attempt for successful login");
			
					
					
							if(sec==this.securityPin)
							{
									if(accountNo==this.id)
									{
											
											
											System.out.println("The Account No is :- "  + this.id);	
											System.out.println("The Customer name is :- "  + this.name);
											System.out.println("The Customer balance is :- "  +  this.deposit);
											
										
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
					
							return flag;
			}
			
		
	
	public newCustomer() {
		super();
		
	}
	
	public void deposit(double dep,long sec)
	{
		if(sec==this.securityPin)
		{
				if(dep>0)
				{
					this.deposit=this.deposit+dep;
					System.out.println("Deposited Successfull Rs." +dep);
				}
				else
				{
					System.out.println("Cannot Deposit Rs." + dep);
				}		
		}
		else
		{
				
				System.out.println("Please Check Your Account No and Security Pin");
				
		}

	}


public void withdrawn(double width,long sec)
	{
	
	if(sec==this.securityPin)
	{
		if(width>0)
		{
			this.deposit=this.deposit-width;
			System.out.println("Withdrawn Successfully Rs." +width);
		}
		else
		{
			System.out.println("Cannot Widthdrawn Rs." + width);
		}		
	}
	else
	{
			
			System.out.println("Please Check Your Account No and Security Pin");
			
	}
	}

public double Current_bal(long sec)	
	{
		
		if(sec==this.securityPin)
		{
		return this.deposit;
		}
		else
		{
			return -1;
		}

	
	}
	
	
}
