package group.project.calculator;

import java.util.Stack;


public class Operand 
{
	/**
	 * Operand Class
	 * 	converts string numbers into Double wrapper class
	 * */
	
	/**instance variable*/
	private Double value; // holds number for calculation
	
	/**Constructor*/
	public Operand(Stack<String> stack) 
	{
		this.value = execute1(stack); // takes stack and convert string to Double wrapper
	}

	/**methods*/
	public double execute1(Stack<String> stack) 
	{
		// execute1 takes a Stack of String and converts to Double wrapper
		return Double.parseDouble(stack.pop());
	}
	
	// getter for value
	public double getValue() 
	{
		return this.value.doubleValue();
	}
	
	
	

}
