package group.project.calculator.stack;

import java.util.Stack;

interface Token {
	/**
	 * interface for operand and operator implementation
	 * */
	
	double execute(Stack stack);
	
}
