/**
 * Class that models a simple bank account.
 */

public class BankAccount
{
	private String name;
	private double balance;
	private int accountNumber;
	private static int nextNumber = 1;

	/** Default Constructor - Default values for our Instance Variables
	*	sets the accountNumber using nextNumber
	*	nextNumber gets incremented
	*/
	public BankAccount()
	{

	}

	/** Overloaded Constructor
	*	allows account holder name to be set
	*	sets the accountNumber using nextNumber
	*	nextNumber gets incremented
	*/
	public BankAccount(String accountHolder)
	{

	}

	public String getName()
	{

	}

	public int getAccountNumber()
	{

	}

	public double getBalance()
	{

	}

	/** Adds an amount to the balance on this account */
	public void deposit(double amount)
	{

	}

	/** Withdraws an amount from the balance on this account
	*	only if the account has sufficient funds for the withdrawl */
	public void withdraw(double amount)
	{

	}
}
