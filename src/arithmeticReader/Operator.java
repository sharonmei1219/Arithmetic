package arithmeticReader;

public class Operator {
	private int priority;
	private Operate op;
	public Operator(Operate op, int priority){
		this.op = op;
		this.priority = priority;
	}
	
	public boolean isGreaterOrEqualsTo(Operator otherOperator){
		return this.priority >= otherOperator.priority;
	}
	
	public int op(int leftOperand, int rightOperand){
		return op.op(leftOperand, rightOperand);
	}
}
