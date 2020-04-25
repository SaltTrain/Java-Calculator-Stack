package group.project.calculator;

import java.util.Stack;

public class plusOperator extends Operator {

	
	
	public plusOperator() {
		super("+");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		Double result = stack.pop().getValue() + stack.pop().getValue();
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
