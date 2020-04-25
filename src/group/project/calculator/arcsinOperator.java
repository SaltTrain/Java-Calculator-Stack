package group.project.calculator;

import java.util.Stack;

public class arcsinOperator extends Operator {

	public arcsinOperator() {
		super("arcsin");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Stack<Operand> stack) {
		Double result = Math.asin(stack.pop().getValue());
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
