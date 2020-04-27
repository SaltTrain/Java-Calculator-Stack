package group.project.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Arrays;
import java.util.LinkedList;

public class Calculator 
{
	/**
	 * Calculator class
	 * 	used to handle file and System.in input from users
	 * */
	
	/**instance variable*/
	public static String[] parsedExpression; // used String array to handle initial expression input

	/**JVM entry point*/
	public static void main(String[] args) throws IOException 
	{
		// handles equation from files
		File inputFile = new File("input.txt");
		File outputFile = new File("output.txt");
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			String line = "";
			while((line = br.readLine())!= null) // goes through each line and passes the equation
			{
				try
				{
					parsedExpression = parseExpression(line);
					LinkedList<String> equation = new LinkedList<String>(Arrays.asList(parsedExpression));
					String result = " = ".concat(Tokenizer.Pn(equation, new Tokenizer()));
					// writes result with equation to output.txt
					bw.write(line.concat(result));
					bw.newLine();
					bw.flush();
					
				} 
				catch (ExpressionFormatError e) 
				{
					System.err.println(e); // custom Exception for properly accepting expression layout from user 
				}
			}
			bw.close();
		}
		catch (FileNotFoundException e1) 
		{
			// prints exception
			e1.printStackTrace();
		}
		
		// reader for console system only
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		
		introMessage(); // prints introduction to console for user
		
		while (true)
		{
			try
			{
				// asks user for expression and than checks for proper spacing
				System.out.println("Please enter your expression:");
				String output = reader.readLine();
				if(output.equals("q")) // if user enters "q" than program quits
				{
					System.out.println("goodbye...");
					break;
				}
				parsedExpression = parseExpression(output);
				LinkedList<String> equation = new LinkedList<String>(Arrays.asList(parsedExpression));
				System.out.println(Tokenizer.Pn(equation, new Tokenizer()));
	
			} 
			catch (ExpressionFormatError e) 
			{
				System.err.println(e); // custom Exception for properly accepting expression layout from user 
			}
		}

	}
	
	// parses the inputed expression and checks for proper formatting
	public static String[] parseExpression(String expression) throws ExpressionFormatError, NumberFormatException
	{
		// parses expression 
		String[] expressionParsed = expression.trim().toLowerCase().split(" ");
		LinkedList<String> exceptionHandle = new LinkedList<String>();
		
		// checks parsed array for improper formatting 
		for (int i = 0; i < expressionParsed.length; i++) 
		{
			try { // number format exception
				if (expressionParsed[i].startsWith("cos") | expressionParsed[i].startsWith("sin") | expressionParsed[i].startsWith("tan")) 
				{
					String operator = expressionParsed[i].substring(0,3); // Operator sign
					String num = expressionParsed[i].replaceAll("[sintancos()]", ""); // number
					if(num.equals("p")) 
					{
						exceptionHandle.add(String.valueOf(Math.PI));
					}
					else 
					{
						exceptionHandle.add(num);
					}
					exceptionHandle.add(operator);
				} 
				else if (expressionParsed[i].startsWith("arccos") | expressionParsed[i].startsWith("arcsin") | expressionParsed[i].startsWith("arctan")) 
				{
					String operator = expressionParsed[i].substring(0,6); // Operator sign
					String num = expressionParsed[i].replaceAll("[arcsintancos()]", ""); // number
					if(num.equals("p")) 
					{
						exceptionHandle.add(String.valueOf(Math.PI));
					}
					else 
					{
						exceptionHandle.add(num);
					}
					exceptionHandle.add(operator);
				}
				else if (expressionParsed[i].endsWith("!")) 
				{
					exceptionHandle.add(expressionParsed[i].substring(0,expressionParsed[i].length()-1));
					exceptionHandle.add(expressionParsed[i].substring(expressionParsed[i].length()-1,expressionParsed[i].length()));
				}
				else if (expressionParsed[i].equals("pi")) 
				{
					exceptionHandle.add(String.valueOf(Math.PI));
				}
				else if (expressionParsed[i].length()>1 && (Double.isNaN(Double.valueOf(expressionParsed[i])) && !expressionParsed[i].equals("sin") && !expressionParsed[i].equals("cos") && !expressionParsed[i].equals("tan"))) 
				{
					throw new ExpressionFormatError("add spaces between each Operand and Operator");
				}
				else 
				{
					exceptionHandle.add(expressionParsed[i]);
				}
			} 
			catch (NumberFormatException e) 
			{
				throw new ExpressionFormatError("add spaces between each Operand and Operator");
			}
		}
		String[] returnArray = exceptionHandle.toArray(new String[exceptionHandle.size()]);
		return returnArray;
	}
	
	// displays introduction to console
	public static void introMessage() 
	{
		System.out.printf("%s %s %s %d %s %s\n\n","Welcome","to","Group",1,"Calculator","Program");
		System.out.println("These are the allowed Operators for our Calculator program:");
		System.out.printf("%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n","Parentheses","( )","Factorial","x!","Exponet","x ^ x","Division","x / x","Multiplication","x * x","Addition","x + x","Subtraction","x - x","Cos","cos(x)","Sin","sin(x)","Tan","tan(x)","ArcCos","arccos(x)","ArcSin","arcsin(x)","ArcTan","arctan(x)","Pi","pi");
		System.out.println("\nHere is an example of an inputed expression. \nEX: 2 ^ ( 4! + 5 / 5 * 2 ) * sin(2) / arcsin(5)");
		System.out.println("To exit program simply type: q\n");
	}
	
}

// custom exception for improper expression format
class ExpressionFormatError extends Exception 
{
	/**
	 * ExpressionFormatError class
	 * 	used for handling expression input format
	 * */
	private static final long serialVersionUID = 1L; // eclipse recommended

	public ExpressionFormatError(String message) 
	{
		super(message);
	}
}
