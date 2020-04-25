package group.project.calculator;

import java.util.Stack;

public class arccosOperator extends Operator {

	public arccosOperator() {
		super("arccos");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Stack<Operand> stack) {
		Double result = Math.acos(stack.pop().getValue());
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
