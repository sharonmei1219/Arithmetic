package arithmetic;

import java.util.Stack;

import arithmeticReader.ArithmeticReader;
import arithmeticReader.Operator;

public class Arithmetic {
	private Stack<Operator> operatorStack;
	private Stack<Integer> operantStack;
	private ArithmeticReader reader;
	
	public Arithmetic(String arithmetic){
		reader = new ArithmeticReader(arithmetic.trim());
		operatorStack = new Stack<Operator>();
		operantStack = new Stack<Integer>();
	}

	public int result() {
		while (!reader.endOfArithmetic()) {
			if (reader.beginWithNumber()) { // numbers
				operantStack.push(reader.readOperant());
			} else if (reader.beginWithLeftBracket()) { //"(" will push to stack any way
				operatorStack.push(reader.readOperator());
			} else if (reader.beginWithRightBracket()) {
				reduce(reader.readOperator());
				operatorStack.pop(); //pop "("
			} else {// +-*/
				Operator currentOperator = reader.readOperator();
				reduce(currentOperator);
				operatorStack.push(currentOperator);
			}
		}
		reduce(reader.end());
		return operantStack.pop();
	}

	private void reduce(Operator currentOne) {
		while (!operatorStack.empty() && operatorStack.peek().isGreaterOrEqualsTo(currentOne)) {
			int right = operantStack.pop();
			int left = operantStack.pop();
			int result = operatorStack.pop().op(left, right);
			operantStack.push(result);
		}
	}
}
