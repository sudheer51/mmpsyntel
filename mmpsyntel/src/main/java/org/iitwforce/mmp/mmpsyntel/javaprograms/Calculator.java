package org.iitwforce.mmp.mmpsyntel.javaprograms;

public class Calculator {
	
	public static int add(int a,int b )
	{
		int c= a-b;
		return c;
		
	}html
	public int subtract(int a,int b )
	{
		int c;
	
		if(a>b)
		{
		  c= a-b;
		}
		else
		{
			c = b-a;
		}
		return c;
		
	}
	public int multiply(int a,int b )
	{
		int c= a*b;
		return c;
		
	}
	public int divide(int a,int b )
	{
	
		int c= a/b;
		return c;
		
	}

}
