package group.project.calculator;

import java.util.Stack;

public class CosOperator extends Operator 
{
	/**
	 * CosOperator class
	 * 	used for assessing cos(x) operation for calculation
	 * */
	
	/**constructor*/
	public CosOperator() 
	{
		super("cos"); // passes string for notation
	}

	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = Math.cos(stack.pop().getValue()); // passes a Stack of Operand for calculation
		return result.toString(); // returns result
	}
}
