import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import petrinet.Place;

class PlaceTest {

	@Test
	void testPlace() {
		Place p = new Place(5);
		assertNotNull(p);
		
		Place p2 = new Place(-1);
		assertEquals(p2.getNbreJetons(), 0);
	}

	@Test
	void testGetNbreJetons() {
		Place p = new Place(10);
		assertEquals(p.getNbreJetons(), 10);
	}

	@Test
	void testSetNbreJetons() {
		Place p = new Place(10);
		p.setNbreJetons(7);
		assertEquals(p.getNbreJetons(), 7);
		
		Place p2 = new Place(10);
		p2.setNbreJetons(-1);
		assertEquals(p2.getNbreJetons(), 0);
	}

	@Test
	void testRmNbreJetons() {
		Place p = new Place(10);
		p.rmNbreJetons(7);
		assertEquals(p.getNbreJetons(), 10 - 7);
		
		Place p2 = new Place(10);
		p2.rmNbreJetons(11);
		assertEquals(p2.getNbreJetons(), 0);
	}
}