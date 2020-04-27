package group.project.calculator;

import java.util.Stack;

public class SinOperator extends Operator
{
	/**
	 * SinOperator class
	 * 	used for assessing sin(x) operation for calculation
	 * */
	
	/**constructor*/
	public SinOperator() 
	{
		super("sin"); // passes string for notation
	}

	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = Math.sin(stack.pop().getValue()); // passes a Stack of Operand for calculation
		return result.toString(); // returns result	
	}
}
