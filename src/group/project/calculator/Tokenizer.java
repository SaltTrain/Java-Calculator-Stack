package group.project.calculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Tokenizer {
	
	private HashMap<String, Operator> PEMDAS = new HashMap<String, Operator>();
	
	private static String[] order = {"cos","sin","tan","arccos","arcsin","arctan","!","^","/","*","+","-"};

	// constructor
	public Tokenizer() 
	{
		PEMDAS.put("cos", new cosOperator());
		PEMDAS.put("sin", new sinOperator());
		PEMDAS.put("tan", new tanOperator());
		PEMDAS.put("arccos", new arccosOperator());
		PEMDAS.put("arcsin", new arcsinOperator());
		PEMDAS.put("arctan", new arctanOperator());
		PEMDAS.put("!", new factorialOperator());
		PEMDAS.put("^", new exponentOperator());
		PEMDAS.put("/", new divideOperator());
		PEMDAS.put("*", new multiplyOperator());
		PEMDAS.put("+", new plusOperator());
		PEMDAS.put("-", new minusOperator());
	}
	
	// handles expression without parentheses
	public static String Pn(LinkedList<String> expression, Tokenizer o) 
	{
		HashMap<String, Operator> PEMDAS = o.getHashMap();
		String[] order = getOrder();
		String answer = "0";
		
		expression = PnPrep(expression, o);

		// loop through PEMDAS
		for(int i=0; i<order.length; i++) 
		{
			// loop through expression
			for(int j=1; j<expression.size(); j+=2) 
			{
				if(order[i].equals(expression.get(j))) 
				{
					switch (expression.get(j)) 
					{
					case "(":
					{
						// Parentheses
						LinkedList<String> temp = new LinkedList<String>(); // holds expression inside parentheses
						LinkedList<Integer> tempIndexes = new LinkedList<Integer>(); // hold indexes inside parentheses for removal after solution
						// takes care of parentheses first
						// 5 + ( 5 + 5 ) --> 5 + 10
						for (int k = j+1; k < expression.size(); k++) 
						{
							if(expression.get(k).equals(")")) 
							{
								tempIndexes.add(k);
								break;
							}
							else 
							{
								temp.add(expression.get(k));
								tempIndexes.add(k);
							}
						}
						answer = Pn(temp, o);
						expression.set(j, answer);
						// remove required index in reverse order
						for(int k=tempIndexes.size()-1; k>0; k--) 
						{
							expression.remove(tempIndexes.get(k).intValue());
						}
					}
					case "cos":
					{
						// Cos
						// grabs only the right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "sin":
					{
						// Sin
						// grabs only the right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "tan":
					{
						// Sin
						// grabs only the right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "arccos":
					{
						// arccos
						// grabs only the right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "arcsin":
					{
						// arcsin
						// grabs only the right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "arctan":
					{
						// arctan
						// grabs only the right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "!": 
					{
						// Factorial
						// grabs only the left number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						// feeds number and gets result from Operand execute
						answer = PEMDAS.get(expression.get(j)).execute(getOperandStack(leftNum));
						expression.set(j-1, answer); // assigns left number to the result
						expression.remove(j); // removes Operator from equation
						break;
					}
					case "^": 
					{
						// Exponent
						// grabs left and right(power) number 
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						Operand power = new Operand(getStringStack(expression.get(j+1)));
						Stack<Operand> opStack = getOperandStack(power);
						opStack.add(leftNum);
						answer = PEMDAS.get(expression.get(j)).execute(opStack);
						expression.set(j-1, answer);
						expression.remove(j+1); // removes power
						expression.remove(j); // removes exponent
						break;
					}
					case "/": 
					{
						// Division
						// grabs left and right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						Operand rightNum = new Operand(getStringStack(expression.get(j+1)));
						Stack<Operand> opStack = getOperandStack(rightNum);
						opStack.add(leftNum);
						answer = PEMDAS.get(expression.get(j)).execute(opStack);
						expression.set(j-1, answer);
						expression.remove(j+1); // removes the right number
						expression.remove(j); // removes the division sign
						break;
					}
					case "*": 
					{
						// Multiply
						// grabs left and right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						Operand rightNum = new Operand(getStringStack(expression.get(j+1)));
						Stack<Operand> opStack = getOperandStack(rightNum);
						opStack.add(leftNum);
						answer = PEMDAS.get(expression.get(j)).execute(opStack);
						expression.set(j-1, answer);
						expression.remove(j+1); // removes the right number
						expression.remove(j); // removes the multiplication sign
						break;
					}
					case "+": 
					{
						// Addition
						// grabs left and right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						Operand rightNum = new Operand(getStringStack(expression.get(j+1)));
						Stack<Operand> opStack = getOperandStack(rightNum);
						opStack.add(leftNum);
						answer = PEMDAS.get(expression.get(j)).execute(opStack);
						expression.set(j-1, answer);
						expression.remove(j+1); // removes the right number
						expression.remove(j); // removes the plus sign
						break;
					}
					case "-": 
					{
						// Subtract
						// grabs left and right number
						Operand leftNum = new Operand(getStringStack(expression.get(j-1)));
						Operand rightNum = new Operand(getStringStack(expression.get(j+1)));
						Stack<Operand> opStack = getOperandStack(rightNum);
						opStack.add(leftNum);
						answer = PEMDAS.get(expression.get(j)).execute(opStack);
						expression.set(j-1, answer);
						expression.remove(j+1); // removes the right number
						expression.remove(j); // removes the minus sign
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + expression.get(j));
					}
					
					if(expression.size()==1) 
					{
						return answer;
					}
					else 
					{
						return Pn(expression, o);
					}
					
				}
				
			}
		}
		return answer;
	}
	
	// handles parentheses
	public static LinkedList<String> PnPrep(LinkedList<String> expression, Tokenizer o) 
	{
		LinkedList<String> temp = new LinkedList<String>(); // holds expression inside parentheses
		LinkedList<Integer> tempIndexes = new LinkedList<Integer>(); // hold indexes inside parentheses for removal after solution
		// takes care of parentheses first
		for (int i = 0; i < expression.size(); i++) {
			
			if(expression.get(i).equals("(")) 
			{
				for (int k = i+1; k < expression.size(); k++) 
				{
					if(expression.get(k).equals(")")) 
					{
						tempIndexes.add(k);
						break;
					}
					else 
					{
						temp.add(expression.get(k));
						tempIndexes.add(k);
					}
				}
				expression.set(i, Pn(temp, o));
				break;
			}
		}
		
		// removes solved expression inside parentheses
		for (int j = tempIndexes.size()-1; j >= 0; j--) 
		{
			expression.remove(tempIndexes.get(j).intValue());
		}
		
		for(String i: expression) 
		{
			if (i.equals("(")) 
			{
				return PnPrep(expression, o);
			}
		}
		return expression;
		
	}
	
	// returns order of operation (key,value)
	private HashMap<String, Operator> getHashMap()
	{
		return this.PEMDAS;
	}
	
	// returns stack of String/s
	private static Stack<String> getStringStack(String num)
	{
		Stack<String> stringStack = new Stack<String>();
		stringStack.add(num);
		return stringStack;
	} 
	
	// returns stack of Operand
	private static Stack<Operand> getOperandStack(Operand num)
	{

		Stack<Operand> opStack = new Stack<Operand>();
		opStack.add(num);
		return opStack;
		
	}

	public static String[] getOrder() {
		return order;
	}

	public static void setOrder(String[] order) {
		Tokenizer.order = order;
	}
	
	
	
	
	

}
