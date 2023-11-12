package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//Classe de test pour ArcZero, utilisant JUnit pour valider le comportement spécifique des ArcZeros dans un réseau de Petri.

class ArcZeroTest {
	// Test pour vérifier le comportement de la méthode isActive de ArcZero.
    
	@Test
	void testIsActive() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		ArcZero a = new ArcZero(t, p, true);
		// Un ArcZero est actif uniquement lorsque la place associée n'a aucun jeton.
        
		assertEquals(a.isActive(), false);
		// Modification du nombre de jetons de la place pour tester le changement d'état de l'arc.
	       
		p.setNbreJetons(0);
		assertEquals(a.isActive(), true);
	}
	// Test pour vérifier la création correcte d'un ArcZero.
    
	@Test
	void testArcZero() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		// Vérifie que l'objet ArcZero est créé correctement.
        
		assertNotNull(new ArcZero(t, p, true));
	}

}
