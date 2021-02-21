package com.ncu.validators;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher; //for pattern Matching
import java.util.regex.Pattern;
import com.ncu.exceptions.*;


public class NameValidator
{
	public boolean nameValidator(String username){
	
		System.out.println("Validated");//+ username);
		InputStream input;
		Properties prop = new Properties(); //Obj of Properties File
		try{
			input = new FileInputStream("C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\constants\\constants.properties");
			prop.load(input); //Loading Properties file
			//validation checks :-
			emptyFileName(username);
			nameLength(username);
			specialCharacter(username);
		}
		catch(SpecialCharacterException e){
			System.out.println(prop.getProperty("specialCharacter"));
			e.printStackTrace();
			return false;
		}
		
		catch(NameLengthException e){
			System.out.println(prop.getProperty("nameLength"));
			e.printStackTrace();
			return false;
		}
		catch(FileNameException e){
			System.out.println(prop.getProperty("emptyNameMessage"));
			e.printStackTrace();
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	//Defining methods:-
void nameLength(String username)throws NameLengthException{
	int fileLength=12;
		String namelength = username;
		if(namelength.length()>fileLength)
			throw new NameLengthException("Username is Long");

}

void specialCharacter(String username) throws SpecialCharacterException{

	Pattern getPattern = Pattern.compile("[@#$%^&(,)_]");
	Matcher check = getPattern.matcher(username);
	boolean finalval = check.find();
	if (finalval == true) {
		throw new SpecialCharacterException("Cant Use Special character in Username");
	}
}
void emptyFileName( String filename) throws FileNameException {
	if (filename == "") {
		throw new FileNameException("Empty User Name");
	}
}

}

// class TestUsernameValidator
// {
// 	public static void main (String[] args)
// 	{
// 		NameValidator name = new NameValidator();
// 		name.nameValidator("asdfaddsfdsfa");
// 	}
// }