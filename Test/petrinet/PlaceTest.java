package petrinet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//Classe de test pour Place, utilisant JUnit pour valider le comportement des places dans un réseau de Petri.

class PlaceTest {
	// Test pour vérifier la création correcte d'une instance de Place avec un nombre positif de jetons.

	@Test
	void placeTest() {
		Place p = new Place(5);
		assertNotNull(p);// Vérifie que l'objet p n'est pas nul.
		// Test pour vérifier le comportement lors de la création d'une Place avec un nombre négatif de jetons.

		Place p2 = new Place(-1);
		assertEquals(p2.getTokenNbre(), 0);// Le nombre de jetons devrait être ramené à 0 dans ce cas.

	}
	// Test pour vérifier que la méthode getNbreJetons retourne le nombre correct de jetons.

	@Test
	void getTokenNbreTest() {
		Place p = new Place(10);
		assertEquals(p.getTokenNbre(), 10);// Vérifie que le nombre de jetons est bien 10.

	}
	// Test pour vérifier le comportement de la méthode setNbreJetons dans des cas normaux et limites.

	@Test
	void setTokenNbreTest() {
		Place p = new Place(10);
		p.setTokenNbre(7);
		assertEquals(p.getTokenNbre(), 7);// Vérifie si le nombre de jetons est correctement mis à jour.

		// Teste le comportement lors de la définition d'un nombre négatif de jetons.


		Place p2 = new Place(10);
		p2.setTokenNbre(-1);
		assertEquals(p2.getTokenNbre(), 0);// Le nombre de jetons doit être ramené à 0.

	}
	// Test pour vérifier le comportement de la méthode rmNbreJetons dans des cas normaux et limites.

	@Test
	void removeTokenNbreTest() {
		Place p = new Place(10);
		p.removeTokenNbre(7);
		assertEquals(p.getTokenNbre(), 10 - 7);// Vérifie que le nombre de jetons est réduit correctement.

		// Teste le comportement lors de la tentative de retrait d'un nombre de jetons supérieur à celui présent.


		Place p2 = new Place(10);
		p2.removeTokenNbre(11);
		assertEquals(p2.getTokenNbre(), 0);// Tous les jetons doivent être retirés dans ce cas.

	}
}