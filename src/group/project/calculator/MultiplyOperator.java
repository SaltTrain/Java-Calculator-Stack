package group.project.calculator;

import java.util.Stack;

public class MultiplyOperator extends Operator 
{
	/**
	 * MultiplyOperator class
	 * 	used for assessing x * x operation for calculation
	 * */
	
	/**constructor*/
	public MultiplyOperator() 
	{
		super("*"); // passes string for notation
	}
	
	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = stack.pop().getValue() * stack.pop().getValue(); // passes a Stack of Operand for calculation
		return result.toString(); // returns result
	}
}
