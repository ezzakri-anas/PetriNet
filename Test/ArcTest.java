import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import petrinet.Arc;
import petrinet.Place;
import petrinet.Transition;

class ArcTest {

	@Test
	void testArcIntTransitionPlaceBoolean() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new Arc(5, t, p, false));
	}

	@Test
	void testArcTransitionPlaceBoolean() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new Arc(t, p, false));
	}

	@Test
	void testGetPoids() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.getPoids(), 5);
	}

	@Test
	void testSetPoids() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		a.setPoids(10);
		assertEquals(a.getPoids(), 10);
		
		a.setPoids(-5);
		assertEquals(a.getPoids(), 10);

	}

	@Test
	void testGetPlace() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.getPlace(), p);
	}

	@Test
	void testSetPlace() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		
		Place p2 = new Place(0);
		a.setPlace(p2);
		assertEquals(a.getPlace(), p2);
	}

	@Test
	void testGetTransition() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.getTransition(), t);
	}

	@Test
	void testSetTransition() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		
		Transition t2 = new Transition(null, null);
		a.setTransition(t2);
		assertEquals(a.getTransition(), t2);
	}

	@Test
	void testIsVideurOrZero() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.isVideurOrZero(), false);
	}

	@Test
	void testSetVideurOrZero() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		a.setVideurOrZero(true);
		assertEquals(a.isVideurOrZero(), true);
	}

	@Test
	void testAddJetons() {
		Transition t = new Transition(null, null);
		int jetons = 1;
		Place p = new Place(jetons);
		int poids = 5;
		Arc a = new Arc(poids, t, p, false);
		
		a.addJetons();
		assertEquals(p.getNbreJetons(), poids + jetons);
	}

	@Test
	void testRemoveJetons() {
		Transition t = new Transition(null, null);
		int jetons = 10;
		Place p = new Place(jetons);
		int poids = 5;
		Arc a = new Arc(poids, t, p, false);
		
		a.removeJetons();
		assertEquals(p.getNbreJetons(), jetons - poids);
		
		
		Transition t2 = new Transition(null, null);
		int jetons2 = 10;
		Place p2 = new Place(jetons2);
		int poids2 = 10;
		Arc a2 = new Arc(poids2, t, p, false);
		
		a.removeJetons();
		assertEquals(p.getNbreJetons(), 0); // expected result 0
	}

	@Test
	void testIsActive() {
		Transition t = new Transition(null, null);
		int jetons = 10;
		Place p = new Place(jetons);
		int poids = 5;
		Arc a = new Arc(poids, t, p, false);
		
		assertEquals(a.isActive(), true);
		
		
		Transition t2 = new Transition(null, null);
		int jetons2 = 10;
		Place p2 = new Place(jetons2);
		int poids2 = 10;
		Arc a2 = new Arc(poids2, t, p, false);
		
		assertEquals(a.isActive(), true);
		
		
		Transition t3 = new Transition(null, null);
		int jetons3 = 5;
		Place p3 = new Place(jetons3);
		int poids3 = 10;
		Arc a3 = new Arc(poids3, t, p, false);
		
		assertEquals(a.isActive(), true);
	}

}
