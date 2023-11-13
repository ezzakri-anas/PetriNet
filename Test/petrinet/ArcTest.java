package petrinet;
//Classe de test pour Arc, utilisant JUnit pour valider le comportement des arcs dans un réseau de Petri.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArcTest {
	// Test pour vérifier la création correcte d'un arc avec un poids spécifié.
	   
	@Test
	void arcIntTransitionPlaceBooleanTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new Arc(5, t, p, false));// Vérifie la création d'un arc valide.

        // Vérifie la création d'un arc avec un poids négatif.
		
		Transition t2 = new Transition(null, null);
		Place p2 = new Place(1);
		assertNotNull(new Arc(-5, t2, p2, false));// Même avec un poids négatif, l'arc est créé.
		   
	}
	// Test pour vérifier la création d'un arc avec un poids par défaut de 1.
    
	@Test
	void arcTransitionPlaceBooleanTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		assertNotNull(new Arc(t, p, false));// Vérifie la création d'un arc avec poids par défaut.
		   
	}
	// Test pour vérifier que getPoids retourne le poids correct de l'arc.
    
	@Test
	void getWeightTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.getWeight(), 5);
	}
	// Test pour vérifier le comportement de setPoids, y compris avec des valeurs négatives.
    
	@Test
	void setWeightTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		a.setWeight(10);// Modification du poids à 10.
		assertEquals(a.getWeight(), 10);
		
		a.setWeight(-5);// Tentative de mise à jour du poids avec une valeur négative.
        
		assertEquals(a.getWeight(), 1); // Le poids ne peut pas être inférieur à 1.
		  

	}
	// Test pour vérifier que getPlace retourne la bonne place associée à l'arc.
	   
	@Test
	void getPlaceTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.getPlace(), p);
	}
	// Test pour vérifier le comportement de setPlace pour mettre à jour la place associée à l'arc.
    
	@Test
	void setPlaceTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		
		Place p2 = new Place(0);// Création d'une nouvelle place.
		a.setPlace(p2);// Mise à jour de la place de l'arc.
		assertEquals(a.getPlace(), p2);
	}
	// Test pour vérifier que getTransition retourne la bonne transition associée à l'arc.
    
	@Test
	void getTransitionTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.getTransition(), t);
	}
	// Test pour vérifier le comportement de setTransition pour mettre à jour la transition associée à l'arc.
	   
	@Test
	void setTransitionTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		
		Transition t2 = new Transition(null, null);// Création d'une nouvelle transition.
        
		a.setTransition(t2);// Mise à jour de la transition de l'arc.
        
		assertEquals(a.getTransition(), t2);
	}
	// Test pour vérifier le comportement de isVideurOrZero, qui indique si l'arc est un arc spécial.
	   
	@Test
	void isVideurOrZeroTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		assertEquals(a.isVideurOrZero(), false);
	}
	// Test pour vérifier le comportement de setVideurOrZero pour modifier le statut d'arc spécial de l'arc.
    
	@Test
	void setVideurOrZeroTest() {
		Transition t = new Transition(null, null);
		Place p = new Place(1);
		Arc a = new Arc(5, t, p, false);
		a.setVideurOrZero(true);// Modification pour indiquer que c'est un arc spécial.
	      
		assertEquals(a.isVideurOrZero(), true);
	}
	 // Test pour vérifier le comportement de addJetons, qui ajoute des jetons à la place associée à l'arc.
	   
	@Test
	void addTokenTest() {
		Transition t = new Transition(null, null);
		int jetons = 1;
		Place p = new Place(jetons);
		int poids = 5;
		Arc a = new Arc(poids, t, p, false);
		
		a.addToken();// Ajout de jetons à la place selon le poids de l'arc.
	       
		assertEquals(p.getTokenNbre(), poids + jetons);// Vérification de l'ajout correct de jetons.
		   
	}
	// Test pour vérifier le comportement de removeJetons, qui retire des jetons de la place associée à l'arc.
    
	@Test
	void removeTokensTest() {
		Transition t = new Transition(null, null);
		int jetons = 10;
		Place p = new Place(jetons);
		int poids = 5;
		Arc a = new Arc(poids, t, p, false);
		
		a.removeTokens();// Retrait de jetons de la place selon le poids de l'arc.
	       
		assertEquals(p.getTokenNbre(), jetons - poids);// Vérification du retrait correct de jetons.

        // Test avec un nombre de jetons égal au poids pour vérifier le comportement limite.
        
		
		
		Transition t2 = new Transition(null, null);
		int jetons2 = 10;
		Place p2 = new Place(jetons2);
		int poids2 = 10;
		Arc a2 = new Arc(poids2, t2, p2, false);
		
		a2.removeTokens();// Retrait de tous les jetons.
		assertEquals(p2.getTokenNbre(), 0);
		// La place devrait être vide.
	    
	}
	// Test pour vérifier le comportement de isActive, qui détermine si l'arc est actif ou non.
    
	@Test
	void isActiveTest() {
		Transition t = new Transition(null, null);
		int jetons = 10;
		Place p = new Place(jetons);
		int poids = 5;
		Arc a = new Arc(poids, t, p, false);
		
		assertEquals(a.isActive(), true);// L'arc est actif car il y a suffisamment de jetons.
        
        // Test avec un arc dont le poids est égal au nombre de jetons.
        
		
		
		Transition t2 = new Transition(null, null);
		int jetons2 = 10;
		Place p2 = new Place(jetons2);
		int poids2 = 10;
		Arc a2 = new Arc(poids2, t2, p2, false);
		
		assertEquals(a2.isActive(), true); // L'arc est toujours actif.

        // Test avec un arc dont le poids est supérieur au nombre de jetons.
        
		
		
		Transition t3 = new Transition(null, null);
		int jetons3 = 5;
		Place p3 = new Place(jetons3);
		int poids3 = 10;
		Arc a3 = new Arc(poids3, t3, p3, false);
		
		assertEquals(a3.isActive(), false); // L'arc n'est pas actif car il manque des jetons.
	    
	}
	// Test pour vérifier le comportement de fire, qui est normalement défini dans les sous-classes d'Arc.
	   
	@Test
	void fireTest() {
		Transition t = new Transition(null, null);
		int jetons = 5;
		Place p = new Place(jetons);
		int poids = 10;
		Arc a = new Arc(poids, t, p, false);
		a.fire();// Exécution de la méthode fire, qui n'a pas d'effet dans la classe Arc de base.
	       
		assertTrue(true);// Vérification que l'appel de fire ne provoque pas d'erreur.
		   
	}

}
