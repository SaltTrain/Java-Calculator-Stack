package group.project.calculator;

import java.util.Stack;

public class Operand implements Token<String> {
	
	private Double value;
	
	public Operand(Stack<String> stack) 
	{
		this.value = execute1(stack);
	}

	@Override
	public double execute1(Stack<String> stack) 
	{
		// TODO Auto-generated method stub
		return Double.parseDouble(stack.pop());
	}
	
	public double getValue() 
	{
		return this.value.doubleValue();
	}

	@Override
	public String execute(Stack<String> stack) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
