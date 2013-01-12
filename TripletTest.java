package test;

import static org.junit.Assert.assertEquals;
import numbertextoop.Triplet;

import org.junit.Test;

/**
 * @author sanjeev
 * JUnit Test class for Triplet.java
 */

public class TripletTest {

  @Test
	public void testMatchTripletPlaces() {
		Triplet triplet = new Triplet(123);
        assertEquals(1, triplet.matchTripletPlaces(123).getHundredthPlace());
        assertEquals(2, triplet.matchTripletPlaces(123).getTenthPlace());
        assertEquals(3, triplet.matchTripletPlaces(123).getUnitPlace());
    }
	
	@Test
	public void testToString() {
		Triplet triplet = new Triplet(203);
		triplet = triplet.matchTripletPlaces(234);
        assertEquals("Two Hundred and Thirty Four", triplet.toString());
    }
	
	@Test
	public void testGetValue(){
		Triplet triplet = new Triplet(987);
		assertEquals(987, triplet.getValue());
    }

	
	@Test
	public void testSetHundredthPlace(){
		Triplet triplet = new Triplet(987);
		triplet.setHundredthPlace(9);
		assertEquals(9, triplet.getHundredthPlace());
    }
	
	@Test
	public void testSetTenthPlace(){
		Triplet triplet = new Triplet(987);
		triplet.setTenthPlace(8);
		assertEquals(8, triplet.getTenthPlace());
    }
	
	@Test
	public void testSetUnitPlace(){
		Triplet triplet = new Triplet(987);
		triplet.setUnitPlace(7);
		assertEquals(7, triplet.getUnitPlace());
    }
	
	
	
	
}
