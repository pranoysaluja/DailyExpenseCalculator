package com.ncu.login;
import java.util.*;
import java.io.*;


public class LoginVerification 
{
	public boolean chkpass(String user, String pass)
	{   
		Properties prop=new Properties();
		try{
		FileInputStream input=null;
		input=new FileInputStream("C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\constants\\constants.properties");
		prop.load(input); //loading Properties file
        String propusername=prop.getProperty("username"); //storing value of username form prop file to string varaible
        String proppassword=prop.getProperty("password"); //storing value of password form prop file to string varaible
		if(propusername.equals(user) && proppassword.equals(pass)) //cehcking if input args are same with prop values
		{
			return true;
		}
	  }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
}
}

/*
public class TestLogin{
    public static void main(String[] args) {
		LoginVerification check = new LoginVerification();
		NameValidator nv = new NameValidator();
		//Scanner sc = new Scanner(System.in);
		//int tries=3;


		Scanner s = new Scanner(System.in);
        int i=0,j=1;
        String username, password;
        while (i==0)
        {
            System.out.print("Enter username:");//username:user
			username = s.nextLine();
			nv.nameValidator(username);
            System.out.print("Enter password:");//password:user
			password = s.nextLine();
			nv.nameValidator(password);
            if(check.chkpass(username, password)){
                System.out.println("Authentication Successful");
                i++;
            }
            else{
                System.out.println("Wrong Username or Password!! Press 1 to try again and any other to exit");
                j=s.nextInt();
                    if(j==1){
                        System.out.println("Authentication Failed try again..." );
                    }
                    else{
                        break;
                    }
        
            }
            s.close();
        }



		// System.out.println("Enter Username");
		// String username = sc.nextLine();	
		// nv.nameValidator(username);
		// System.out.println("Enter Password");
		// String password = sc.nextLine();
		// nv.nameValidator(password);
		// if(check.chkpass(username, password))
		// 	System.out.println("login successful");
		// else{
			
		// 	for(int i= tries;i>0;i--){

		// 		System.out.printf("You have %d attempt remaining. \n", tries);
		// 		System.out.println("Enter Username");
		// 		username = sc.nextLine();	
		// 		nv.nameValidator(username);
		// 		System.out.println("Enter Password");
		// 		password = sc.nextLine();
		// 		nv.nameValidator(password);
		// 		if(check.chkpass(username, password)){
		// 			System.out.println("Login Successful");
		// 			break;
		// 		}
		// 		else
		// 			tries--;
		// 		if(tries==0){
		// 			System.out.println("Login failed");
		// 		}
		// 		}
		// 	}
	} 
		
}
*/