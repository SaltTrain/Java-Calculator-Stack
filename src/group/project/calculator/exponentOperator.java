package group.project.calculator;

import java.util.Stack;

public class exponentOperator extends Operator {

	
	
	public exponentOperator() {
		super("^");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		Double result = Math.pow(stack.pop().getValue(),stack.pop().getValue());
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
