package group.project.calculator;

import java.util.Stack;

public class TanOperator extends Operator 
{
	/**
	 * TanOperator class
	 * 	used for assessing tan(x) operation for calculation
	 * */
	
	/**constructor*/
	public TanOperator() 
	{
		super("tan"); // passes string for notation
	}

	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = Math.tan(stack.pop().getValue()); // passes a Stack of Operand for calculation
		return result.toString(); // returns result	
	}
}
