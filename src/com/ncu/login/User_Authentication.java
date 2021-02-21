package com.ncu.login;
import java.util.*;
public class User_Authentication
{
    public static void main(String args[])
    {
        
        Scanner s = new Scanner(System.in);
        int i=0,j=1;
        String username, password;
        while (i==0)
        {
            s.nextLine();
            System.out.print("Enter username:");//username:user
            username = s.nextLine();
            System.out.print("Enter password:");//password:user
            password = s.nextLine();
            if(username.equals("user") && password.equals( "user")){
                System.out.println("Authentication Successful");
                i++;
            }
            else{
                System.out.println("want to exit program?  Press 1 to try again and any other to exit");
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
    }
}