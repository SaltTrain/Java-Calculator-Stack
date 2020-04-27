package group.project.calculator;

public interface Token<T> {

	String execute(java.util.Stack<T> stack);
	
}
