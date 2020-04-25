package group.project.calculator;

import java.util.Stack;

public class factorialOperator extends Operator {

	
	
	public factorialOperator() {
		super("!");
		// TODO Auto-generated constructor stub
	}
	
	class Calculation
	{
	    double fact(double n)
	    {
	        double result;

	       if(n==1)
	         return 1;

	       result = fact(n-1) * n;
	       return result;
	    }
	}

	@Override
	public String execute(Stack<Operand> stack) {
		Calculation fact_num = new Calculation();
		// TODO Auto-generated method stub
		Double result = fact_num.fact(stack.pop().getValue());
		return result.toString();
	}

	@Override
	public double execute1(Stack<Operand> stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
