package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;


import org.junit.jupiter.api.Test;

//Classe de test pour Transition, utilisant JUnit pour valider le comportement des transitions dans un réseau de Petri.

class TransitionTest {

	// Test pour vérifier la création correcte d'une instance de Transition.
    
	@Test
	void testTransition() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assertNotNull(T) ;
	}
	// Test pour vérifier que getArcsEntrants retourne une liste vide pour une nouvelle transition.
    
	@Test
	void testGetArcsEntrants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assertEquals(T.getArcsEntrants().size(), 0);
	}
	// Test pour vérifier le comportement de setArcsEntrants.
    
	@Test
	void testSetArcsEntrants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.setArcsEntrants(arcE);
		assertEquals(T.getArcsEntrants(), arcE);
	}
	// Test pour vérifier que getArcsSortants retourne une liste vide pour une nouvelle transition.
    
	@Test
	void testGetArcsSortants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assertEquals(T.getArcsSortants().size(), 0);
	}
	// Test pour vérifier le comportement de setArcsSortants.
    
	@Test
	void testSetArcsSortants() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.setArcsSortants(arcS);
		assertEquals(T.getArcsSortants(), arcS);
	}
	// Test pour vérifier que addArcEntrant ajoute correctement un arc à la liste des arcs entrants.
    
	@Test
	void testAddArcEntrant() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.addArcEntrant(arc);
		assertEquals(T.getArcsEntrants(), arcE);
	}
	// Test pour vérifier que addArcsortant ajoute correctement un arc à la liste des arcs sortants.
    
	@Test
	void testAddArcsortant() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.addArcsortant(arc);
		assertEquals(T.getArcsSortants(), arcS);
	}
	// Test pour vérifier que rmArc supprime correctement un arc et gère les cas où l'arc n'existe pas.
    
	@Test
	void testRmArc() throws Exception {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		Place P= new Place(7);
		Arc arc = new Arc(5, T, P, false);
		// Ajoute puis supprime un arc de la liste des arcs sortants et vérifie que la liste est vide après.
        
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.addArcsortant(arc);
		T.rmArc(arc);
		assertEquals(T.getArcsSortants().size(), 0);
		// Ajoute puis supprime un arc de la liste des arcs entrants et vérifie que la liste est vide après.
        
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.addArcEntrant(arc);
		T.rmArc(arc);
		assertEquals(T.getArcsEntrants().size(), 0);
		// Teste la gestion des exceptions pour un arc non présent.
		assertThrows(Exception.class, () -> {
			T.rmArc(arc);
        });
	}

}
