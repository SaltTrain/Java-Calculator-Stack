package group.project.calculator;

import java.util.Stack;

public class ArcCosOperator extends Operator 
{
	/**
	 * ArcCosOperator class
	 * 	used for assessing arccos(x) operation for calculation
	 * */
	
	/**constructor*/
	public ArcCosOperator() 
	{
		super("arccos"); // passes string for notation
	}
	
	/**method*/
	@Override
	public String execute(Stack<Operand> stack) 
	{
		Double result = Math.acos(stack.pop().getValue()); // passes a Stack of Operand for calculation
		return result.toString(); // returns result
	}

}
