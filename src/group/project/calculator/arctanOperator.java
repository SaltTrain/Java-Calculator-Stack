package group.project.calculator;

import java.util.Stack;

public class arctanOperator extends Operator{

	public arctanOperator() {
		super("arctan");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Stack<Operand> stack) {
		Double result = Math.atan(stack.pop().getValue());
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
