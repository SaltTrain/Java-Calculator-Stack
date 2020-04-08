package group.project.calculator.stack;

import java.util.Stack;

public class Operand implements Token {
	/**
	 * holds digit value
	 * */
	
	/*instance variable**/
	private Double value;
	
	/*constructor**/
	public Operand(Double value) {this.value = value;}

	@Override
	public double execute(Stack stack) {
		// TODO Auto-generated method stub
		return 0;
	}

}
