package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;


import org.junit.jupiter.api.Test;

//Classe de test pour Transition, utilisant JUnit pour valider le comportement des transitions dans un réseau de Petri.

class TransitionTest {

	// Test pour vérifier la création correcte d'une instance de Transition.

	@Test
	void transitionTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assertNotNull(T) ;
	}
	// Test pour vérifier que getArcsEntrants retourne une liste vide pour une nouvelle transition.

	@Test
	void getInputArcsTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assertEquals(T.getInputArcs().size(), 0);
	}
	// Test pour vérifier le comportement de setArcsEntrants.

	@Test
	void setInputArcsTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		
		int tokens = 7;
		Place P= new Place(tokens);
		
		int weight = 5;
		Arc arc = new Arc(weight, T, P, false);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.setInputArcs(arcE);
		assertEquals(T.getInputArcs(), arcE);
	}
	// Test pour vérifier que getArcsSortants retourne une liste vide pour une nouvelle transition.

	@Test
	void getOutputArcsTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		assertEquals(T.getOutputArcs().size(), 0);
	}
	// Test pour vérifier le comportement de setArcsSortants.

	@Test
	void setOutputArcsTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		
		int tokens = 7;
		Place P= new Place(tokens);
		
		int weight = 5;
		Arc arc = new Arc(weight, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.setOutputArcs(arcS);
		assertEquals(T.getOutputArcs(), arcS);
	}
	// Test pour vérifier que addArcEntrant ajoute correctement un arc à la liste des arcs entrants.

	@Test
	void addInputArcTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		
		int tokens = 7;
		Place P= new Place(tokens);
		
		int weight = 5;
		Arc arc = new Arc(weight, T, P, false);
		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.addInputArc(arc);
		assertEquals(T.getInputArcs(), arcE);
	}
	// Test pour vérifier que addArcsortant ajoute correctement un arc à la liste des arcs sortants.

	@Test
	void addOutputArcTest() {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		
		int tokens = 7;
		Place P= new Place(tokens);
		
		int weight = 5;
		Arc arc = new Arc(weight, T, P, false);
		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.addOutputArc(arc);
		assertEquals(T.getOutputArcs(), arcS);
	}
	// Test pour vérifier que rmArc supprime correctement un arc et gère les cas où l'arc n'existe pas.

	@Test
	void removeArcTest() throws Exception {
		Transition T=new Transition(new LinkedList<Arc>() ,new LinkedList<Arc>() );
		int tokens = 7;
		Place P= new Place(tokens);
		int weight = 5;
		Arc arc = new Arc(weight, T, P, false);
		// Ajoute puis supprime un arc de la liste des arcs sortants et vérifie que la liste est vide après.

		LinkedList<Arc> arcS= new LinkedList<Arc>();
		arcS.add(arc);
		T.addOutputArc(arc);
		T.removeArc(arc);
		assertEquals(T.getOutputArcs().size(), 0);
		// Ajoute puis supprime un arc de la liste des arcs entrants et vérifie que la liste est vide après.

		LinkedList<Arc> arcE= new LinkedList<Arc>();
		arcE.add(arc);
		T.addInputArc(arc);
		T.removeArc(arc);
		assertEquals(T.getInputArcs().size(), 0);
		// Teste la gestion des exceptions pour un arc non présent.
		assertThrows(Exception.class, () -> {
			T.removeArc(arc);
		});
	}

}
