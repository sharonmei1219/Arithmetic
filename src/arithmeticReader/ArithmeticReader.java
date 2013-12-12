package arithmeticReader;

public class ArithmeticReader {
	private String arithmetic;
	
	public ArithmeticReader(String arithmetic) {
		this.arithmetic = new String(arithmetic);
	}

	public int readOperant() {
		int endOfOperant = endOfOperant();
		int result = Integer.parseInt(arithmetic.substring(0, endOfOperant).trim());
		arithmetic = arithmetic.substring(endOfOperant).trim();
		return result;
	}
	
	private int endOfOperant(){
		for(int index = 0; index < arithmetic.length(); index ++){
			if(arithmetic.charAt(index) < '0' || arithmetic.charAt(index)>'9')
				return index;
		}
		return arithmetic.length();
	}

	public Operator readOperator() {
		String op = new String(Character.toString(arithmetic.charAt(0)));
		arithmetic = arithmetic.substring(1).trim();
		return createOperator(op);
	}

	public boolean endOfArithmetic() {
		if(arithmetic.equals(""))
			return true;
		return false;
	}

	public boolean beginWithNumber() {
		if(arithmetic.charAt(0) >= '0' && arithmetic.charAt(0) <= '9')
			return true;
		return false;
	}

	public boolean beginWithLeftBracket() {
		if(arithmetic.charAt(0) == '(')
			return true;
		return false;
	}

	public boolean beginWithRightBracket() {
		if(arithmetic.charAt(0) == ')')
			return true;
		return false;
	}
	
	private Operator createOperator(String op) {
		if (op.equals("+"))
			return new Operator(new Plus(), 1);
		else if (op.equals("*"))
			return new Operator(new Times(), 2);
		else if (op.equals("/"))
			return new Operator(new Divide(), 2);
		else if (op.equals("-"))
			return new Operator(new Minus(), 1);
		else if(op.equals("("))
			return new Operator(new NullOp(), 0);
		else // ")"
			return new Operator(new NullOp(), 1);
	}
	
	public Operator end(){
		return new Operator(new NullOp(), 1);
	}

}
