package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import numbertextoop.Number;
import numbertextoop.Triplet;

import org.junit.Test;

/**
 * @author sanjeev JUnit Test class for Number.java
 */

public class NumberTest {

  @Test
	public void testNegativeNumber() {
		assertTrue(new Number(-1).getNum() < 0);
	}

	@Test
	public void testToString() {
		Number number = new Number(123456789);
		assertEquals(
				"One Hundred and Twenty Three Million Four Hundred and Fifty Six Thousand Seven Hundred and Eighty Nine  ",
				number.toString());

		Number negNumber = new Number(-123456789);
		assertEquals(
				"Negative One Hundred and Twenty Three Million Four Hundred and Fifty Six Thousand Seven Hundred and Eighty Nine  ",
				negNumber.toString());

		Number zerosNumber = new Number(2000089);
		assertEquals("Two Million  Eighty Nine  ", zerosNumber.toString());

		number = new Number(0);
		assertEquals("Zero", number.toString());

	}

	/**
	 * To test private method buildTriplets(). Could use reflection as well to
	 * test private method
	 */
	@Test
	public void testGetTriplets() {
		Number number = new Number(123789);
		assertEquals(2, number.getTriplets().size());

		int[] triplets = new int[] { 123, 789 };
		int i = 0;
		for (Object o : number.getTriplets()) {
			Triplet triplet = (Triplet) o;
			assertEquals(triplets[i++], triplet.getValue());
		}
	}

	@Test
	public void testGetText() {
		Number number = new Number(234);
		assertEquals("Two Hundred and Thirty Four  ", number.getText());
	}

	@Test
	public void testGetNum() {
		Number number = new Number(234);
		assertEquals(234, number.getNum());
	}

}
