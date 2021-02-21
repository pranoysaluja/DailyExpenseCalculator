package com.ncu.exceptions;

public class UnknownExpenseException extends Exception
{
	public UnknownExpenseException(String s)
	{
		super(s);
	}
}