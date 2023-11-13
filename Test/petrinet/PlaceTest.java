package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//Classe de test pour Place, utilisant JUnit pour valider le comportement des places dans un réseau de Petri.

class PlaceTest {
	// Test pour vérifier la création correcte d'une instance de Place avec un nombre positif de jetons.

	@Test
	void placeTest() {
		int tokens = 5;
		Place p = new Place(tokens);
		assertNotNull(p);// Vérifie que l'objet p n'est pas nul.
		// Test pour vérifier le comportement lors de la création d'une Place avec un nombre négatif de jetons.

		int tokens2 = -1;
		Place p2 = new Place(tokens2);
		assertEquals(p2.getTokenNbre(), 0);// Le nombre de jetons devrait être ramené à 0 dans ce cas.

	}
	// Test pour vérifier que la méthode getNbreJetons retourne le nombre correct de jetons.

	@Test
	void getTokenNbreTest() {
		int tokens = 5;
		Place p = new Place(tokens);
		assertEquals(p.getTokenNbre(), tokens);// Vérifie que le nombre de jetons est bien 10.

	}
	// Test pour vérifier le comportement de la méthode setNbreJetons dans des cas normaux et limites.

	@Test
	void setTokenNbreTest() {
		int tokens = 5;
		Place p = new Place(tokens);
		
		int tokens2 = 7;
		p.setTokenNbre(tokens2);
		assertEquals(p.getTokenNbre(), tokens2);// Vérifie si le nombre de jetons est correctement mis à jour.

		// Teste le comportement lors de la définition d'un nombre négatif de jetons.


		int tokens21 = 10;
		Place p2 = new Place(tokens21);
		
		int tokens22 = -7;
		p2.setTokenNbre(tokens22);
		assertEquals(p2.getTokenNbre(), 0);// Le nombre de jetons doit être ramené à 0.

	}
	// Test pour vérifier le comportement de la méthode rmNbreJetons dans des cas normaux et limites.

	@Test
	void removeTokenNbreTest() {
		int tokens = 10;
		Place p = new Place(tokens);
		int to_remove = 10;
		p.removeTokenNbre(to_remove);
		assertEquals(p.getTokenNbre(), tokens - to_remove);// Vérifie que le nombre de jetons est réduit correctement.

		// Teste le comportement lors de la tentative de retrait d'un nombre de jetons supérieur à celui présent.

		int tokens2 = 10;
		Place p2 = new Place(tokens2);
		int to_remove2 = 11;
		p2.removeTokenNbre(to_remove2);
		assertEquals(p2.getTokenNbre(), 0);// Tous les jetons doivent être retirés dans ce cas.

	}
}