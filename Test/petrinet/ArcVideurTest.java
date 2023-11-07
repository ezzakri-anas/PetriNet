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
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		ArcVideur a = new ArcVideur(t, p, true);
		
		a.fire();
		
		assertEquals(p.getNbreJetons(), 0);
		
		Transition t2 = new Transition(null, null);
		Place p2 = new Place(0);
		ArcVideur a2 = new ArcVideur(t2, p2, true);
		
		a2.fire();
		
		assertEquals(p2.getNbreJetons(), 0);
	}

	@Test
	void testArcVideur() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new ArcVideur(t, p, true));
	}

}
