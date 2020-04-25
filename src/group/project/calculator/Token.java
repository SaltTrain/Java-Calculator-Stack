package group.project.calculator;

public interface Token<T> {

	String execute(java.util.Stack<T> stack);
	
	double execute1(java.util.Stack<T> stack);
	
}
