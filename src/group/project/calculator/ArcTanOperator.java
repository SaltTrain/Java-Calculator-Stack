package group.project.calculator;

import java.util.Stack;

public class ArcTanOperator extends Operator
{
	/**
	 * ArcTanOperator class
	 * 	used for assessing arcsin(x) operation for calculation
	 * */
	
	/**constructor*/
	public ArcTanOperator() 
	{
		super("arctan"); // passes string for notation
	}

	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = Math.atan(stack.pop().getValue()); // passes a Stack of Operand for calculation
		return result.toString(); // returns result
	}
}
