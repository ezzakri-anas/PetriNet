package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;


import org.junit.jupiter.api.Test;

import petrinet.Arc;
import petrinet.Place;
import petrinet.Transition;

class TransitionTest {

	
	@Test
	void testTransition() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assert(T!=null) ;
	}

	@Test
	void testGetArcsEntrants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assert(T.getArcsEntrants().size()==0);
	}

	@Test
	void testSetArcsEntrants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.setArcsEntrants(arcE);
		assert(T.getArcsEntrants().equals(arcE));
	}

	@Test
	void testGetArcsSortants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assert(T.getArcsSortants().size()==0);
	}

	@Test
	void testSetArcsSortants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.setArcsSortants(arcS);
		assert(T.getArcsSortants().equals(arcS));
	}

	@Test
	void testAddArcEntrant() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.addArcEntrant(arc);
		assert(T.getArcsEntrants().equals(arcE));
	}

	@Test
	void testAddArcsortant() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.addArcsortant(arc);
		assert(T.getArcsSortants().equals(arcS));
	}

	@Test
	void testRmArc() throws Exception {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.addArcsortant(arc);
		T.rmArc(arc);
		assert(T.getArcsSortants().size()==0);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.addArcEntrant(arc);
		T.rmArc(arc);
		assert(T.getArcsEntrants().size()==0);
		assertThrows(Exception.class, () -> {
			T.rmArc(arc);
        });
		
	}

}
