package arithmetic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import arithmeticReader.ArithmeticReader;
import arithmeticReader.Operator;

public class TestArithmeticReader {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void readOperants123(){
		ArithmeticReader reader = new ArithmeticReader("123+1");
		assertEquals(123, reader.readOperant());
	}
	
	@Test
	public void readOperator(){
		ArithmeticReader reader = new ArithmeticReader("+1");
		Operator op = reader.readOperator();
		assertEquals(2, op.op(1,  1));
		assertEquals(1, reader.readOperant());
	}
	
	@Test
	public void readOperatorTimes(){
		ArithmeticReader reader = new ArithmeticReader("*1");
		Operator op = reader.readOperator();
		assertEquals(2, op.op(1,  2));
		assertEquals(1, reader.readOperant());
	}
	
	@Test
	public void endOfArithmetic(){
		ArithmeticReader reader = new ArithmeticReader("1");
		assertEquals(1, reader.readOperant());
		assertTrue(reader.endOfArithmetic());
	}
	
	@Test
	public void beginWithLeftBracket(){
		ArithmeticReader reader = new ArithmeticReader("(1");
		assertTrue(reader.beginWithLeftBracket());
	}
	
	@Test
	public void beginWithRightBracket(){
		ArithmeticReader reader = new ArithmeticReader(")+3");
		assertTrue(reader.beginWithRightBracket());
	}
}
