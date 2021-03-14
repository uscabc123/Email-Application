package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String department;
	private int mailboxcapicity = 50;
	private int defaultpasswordlength = 10;
	private String alternativeEmail;
	private String email_prefix = ".abc.com";

	//constructor to receive first and last name
	public Email(String firstname, String lastname) {
		
		this.firstname = firstname;
		this.lastname = lastname;
	//	System.out.println("Email created: " + this.firstname + " " + this.lastname);
		//call a method to get the department input from the user
		this.department = setDepartment();
	//	System.out.println("Department: "+ this.department);
		//get random password
		this.password = randomPassword(defaultpasswordlength);
		System.out.println("Your password is: " + this.password);
		
		//combine element to generate email address
		email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + email_prefix;
	//	System.out.println("Your Email is: " + email);
	}

	//ask for the department from the user
	private String setDepartment(){
		System.out.println("Hi " + firstname + "! Please enter your department code:\n 1 for sales \n 2 for development \n 3 for accounting\n 0 for none\n Enter department code:");
		Scanner in = new Scanner(System.in);
		int dept_choice = in.nextInt();
		if (dept_choice == 1)
		{
			return "sales";
		}
		else if(dept_choice == 2)
		{
			return "development";
		}
		else if(dept_choice == 3)
		{
			return "accounting";
		}
		else
		{
			return "";
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()_+-=,./<>?";
		//array
		char[] password = new char[length];
		for(int i=0; i<length; i++)
		{
			int rand = (int) (Math.random()* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		return new String(password);
	}

	public String getNewPassword() {
		return password;
	}

	public void setNewPassword(String password) {
		this.password = password;
	}

	public int getMailboxcapicity() {
		return mailboxcapicity;
	}

	public void setMailboxcapicity(int mailboxcapicity) {
		this.mailboxcapicity = mailboxcapicity;
	}

	public String getAlternativeEmail() {
		return alternativeEmail;
	}

	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}
	
	public String showinfo()
	{
		return "Display Name :" + firstname + lastname + "\nEmail address:" + email + "\nMailbox capacity:" + mailboxcapicity +"mb";
	}
}
