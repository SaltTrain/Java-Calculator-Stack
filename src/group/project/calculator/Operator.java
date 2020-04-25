package group.project.calculator;

public abstract class Operator implements Token<Operand> {
	
	protected String notation;
	
	public Operator(String notation) 
	{
		this.notation = notation;
	}
	
	public void printError(String error) {};

}
