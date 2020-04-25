package group.project.calculator;

import java.util.Stack;

public class tanOperator extends Operator {

	public tanOperator() {
		super("tan");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Stack<Operand> stack) {
		Double result = Math.tan(stack.pop().getValue());
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
