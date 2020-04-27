package group.project.calculator;

import java.util.Stack;

public class ArcSinOperator extends Operator 
{
	/**
	 * ArcSinOperator class
	 * 	used for assessing arcsin(x) operation for calculation
	 * */
	
	/**constructor*/
	public ArcSinOperator() 
	{
		super("arcsin"); // passes string for notation
	}

	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = Math.asin(stack.pop().getValue()); // passes a Stack of Operand for calculation
		return result.toString(); // returns result
	}
}
