import java.io.*;
import java.util.Scanner;
class customer
{
	private String name;
	private long accno;
	private float balance;
	public customer(String n,long a,float b)
	{
		name=n;
		accno=a;
		balance=b;
	}
	public void withdraw(long amount)throws BankException
	{
		if(balance-amount<=500)
		{
			throw new BankException(accno,balance);
		}
		balance-=amount;
		System.out.println("Available Balance:--------"+balance);
		
	}
}
 class BankException extends Exception
{
	private long account;
	private float balance;
	public BankException(long a,float b)
	{
		this.account=a;
		this.balance =b;
	}
	public void inform()
	{
		System.out.println("Account No:---"+account);
		System.out.println("Balance:---"+balance);
	}
}
class bank
{
	public static void main(String[]args)throws IOException
	{
		String str;
		long a,w;
		float b;
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.println("Enter the Customer Name:----");
		str=br.readLine();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the account number:----");
		a=s.nextLong();
		System.out.println("Enter the Balance:----");
		b=s.nextFloat();
		System.out.println("Enter the amount to be withdrawn:----");
		w=s.nextLong();
		try
		{
			customer c=new customer(str,a,b);
			c.withdraw(w);
		}
		catch(BankException ex)
		{
			System.out.println("Transaction failed!!!!!!!!!!!!");
			ex.inform();
		}
	}
}