package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArcVideurTest {

	@Test
	void testIsActive() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		ArcVideur a = new ArcVideur(t, p, true);
		
		assertTrue(a.isActive());
	}

	@Test
	void testFire() {
		fail("Not yet implemented");
	}

	@Test
	void testArcVideur() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new ArcVideur(t, p, true));
	}

}
