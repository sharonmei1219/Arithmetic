package arithmeticReader;

public class Times implements Operate {

	@Override
	public int op(int operant1, int operant2) {
		return operant1 * operant2;
	}
}
