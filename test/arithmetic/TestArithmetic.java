package arithmetic;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class TestArithmetic {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOnePlusOne() {
		assertEquals(2, new Arithmetic("1 + 1").result());
	}
	
	@Test
	public void testOnTwoTimesThree(){
		assertEquals(6, new Arithmetic("2 * 3").result());
	}
	
	@Test
	public void testSixDivByThree(){
		assertEquals(2, new Arithmetic("6/3").result());
	}
	
	@Test
	public void testTwoMinusOne(){
		assertEquals(1, new Arithmetic("2 - 1").result());
	}
	
	@Test
	public void testPlusAfterAnotherPlus(){
		assertEquals(3, new Arithmetic("1 + 1 + 1").result());
	}
	
	@Test
	public void test1Plus2Times3(){
		assertEquals(7, new Arithmetic("1 + 2*3").result());
	}
	
	@Test
	public void testOnePlusOneWithBrackets(){
		assertEquals(2, new Arithmetic("(1+1)").result());
	}
	
	@Test
	public void test2TimesTheSumOfOnePlusOne(){
		assertEquals(4, new Arithmetic("2*(1+1)").result());
	}
}
