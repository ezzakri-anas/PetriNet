package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//Classe de test pour ArcVideur, utilisant JUnit pour valider le comportement spécifique des ArcVideurs dans un réseau de Petri.

class ArcVideurTest {
	// Test pour vérifier que isActive retourne toujours vrai pour un ArcVideur.
    
	@Test
	void testIsActive() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		ArcVideur a = new ArcVideur(t, p, true);
		// Un ArcVideur est toujours actif, peu importe le nombre de jetons dans la place associée.
        
		assertTrue(a.isActive());
	}
	// Test pour vérifier le comportement de la méthode fire de ArcVideur.
    
	@Test
	void testFire() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		ArcVideur a = new ArcVideur(t, p, true);
		// Après l'appel de fire, le nombre de jetons dans la place devrait être réinitialisé à 0.
        
		a.fire();
		
		assertEquals(p.getNbreJetons(), 0);
		// Test avec une place initialement vide pour confirmer que fire réinitialise toujours le nombre de jetons à 0.
        
		Transition t2 = new Transition(null, null);
		Place p2 = new Place(0);
		ArcVideur a2 = new ArcVideur(t2, p2, true);
		
		a2.fire();
		
		assertEquals(p2.getNbreJetons(), 0);
	}
	// Test pour vérifier la création correcte d'un ArcVideur.
	   
	@Test
	void testArcVideur() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		// Vérifie que l'objet ArcVideur est créé correctement.
	       
		assertNotNull(new ArcVideur(t, p, true));
	}

}
