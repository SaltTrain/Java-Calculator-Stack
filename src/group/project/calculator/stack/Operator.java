package group.project.calculator.stack;

public abstract class Operator implements Token {
	/**
	 * abstract class used for operation implementation
	 * */
	
	/**instance variable*/
	protected String notaion;
	
	/**constructor*/
	public Operator() {}
	
	/**methods*/
	public void printError(String error) {System.out.println(error);}

}
