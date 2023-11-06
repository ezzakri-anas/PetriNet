import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import petrinet.Place;

class PlaceTest {

	@Test
	void testPlace() {
		assertNotNull(new Place(5));
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
	}

	@Test
	void testRmNbreJetons() {
		Place p = new Place(10);
		p.rmNbreJetons(7);
		assertEquals(p.getNbreJetons(), 10 - 7);
	}
}