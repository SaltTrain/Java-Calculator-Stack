package group.project.calculator;

import java.util.Stack;

public class FactorialOperator extends Operator 
{
	/**
	 * ExponentOperator class
	 * 	used for assessing x ^ x operation for calculation
	 * */
	
	/**constructor*/
	public FactorialOperator() 
	{
		super("!"); // passes string for notation
	}
	
	/**methods*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = FactN(stack.pop().getValue()); // passes number for recursion
		return result.toString(); //  returns result
	}
	
	private double FactN(double n) // recursive solution
	{
	    double result = 1.0; // holds solution for factorial 1 or passed number
	
	   if(n==1) // factorial 1 is 1
	     return result;
	
	   result = FactN(n-1) * n; // processes next number for factorial
	   return result; // returns result
	}
}
