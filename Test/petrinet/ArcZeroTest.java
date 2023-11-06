package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArcZeroTest {

	@Test
	void testIsActive() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		ArcZero a = new ArcZero(t, p, true);
		
		assertEquals(a.isActive(), false);
		
		p.setNbreJetons(0);
		assertEquals(a.isActive(), true);
	}

	@Test
	void testFire() {
		fail("Not yet implemented");
	}

	@Test
	void testArcZero() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new ArcZero(t, p, true));
	}

}
