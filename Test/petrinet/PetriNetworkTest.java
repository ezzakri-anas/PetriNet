package petrinet;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
//Classe de test pour PetriNetwork, utilisant JUnit pour effectuer des tests unitaires.

class PetriNetworkTest {
	 // Crée une instance de PetriNetwork pour les tests.
    
	PetriNetwork PetriCree() {
		return new PetriNetwork() ;
		
		
	}
	@Ignore
	// Crée une transition pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
    Transition TransitionCree( PetriNetwork Petri) {
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		return T1;
		
		
	}
	@Ignore
	// Crée une place pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
    Place PlaceCree(int poids,PetriNetwork Petri) {
		
		Place T1= new Place(poids);
		Petri.addPlace(T1);
		return T1;
		
	}
	// Crée un arc pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
    
	@Ignore
	
    Arc arcCree(int poids, Transition transition, Place place,boolean entrsortie, boolean isVideurOrZero,PetriNetwork Petri) {
		Arc arc= new Arc( poids,transition, place, isVideurOrZero);
		Petri.addArc(transition, place, poids, entrsortie, isVideurOrZero);
		
		return arc;
		
		
	}
	@Ignore
	// Crée un ArcVideur pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
    
	Arc arcVCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcVideur(transition,place ,true);
		Petri.addArcVideur(transition, place);
		
		return arc;
		
	}
	// Crée un ArcZero pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
    
	@Ignore
	Arc arcZCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcZero(transition,place ,true);
		Petri.addArcZero(transition, place);
		
		return arc;
		
	}
	@Test
	// Test pour vérifier l'initialisation correcte d'un PetriNetwork.
    void PetriNetworktest() {
		PetriNetwork Petri= this.PetriCree() ;
		assert(Petri.getPlaceList().size()==0);
		assert(Petri.getTransitionList().size()==0);
		assert(Petri.getArc().size()==0);
		
		
	}
	// Test pour vérifier le fonctionnement de setTransitionList.
    
	@Test
	void setTransitionListTest() {
		PetriNetwork Petri= this.PetriCree();
		Transition T1= this.TransitionCree(Petri);
		Transition T2= this.TransitionCree(Petri);
		LinkedList<Transition> liste_des_transitions= new LinkedList<Transition>();
		liste_des_transitions.add(T1);
		liste_des_transitions.add(T2);
		Petri.setTransitionList(liste_des_transitions);
		assert(Petri.getTransitionList().equals(liste_des_transitions));
	}
	@Test
	// Test pour vérifier que getTransitionList retourne bien la liste actuelle des transitions.
    void getTransitionListTest(){
		PetriNetwork Petri= this.PetriCree();
		LinkedList<Transition> liste_des_transitions= new LinkedList<Transition>();
		Petri.setTransitionList(liste_des_transitions);
		assert(Petri.getTransitionList().equals(liste_des_transitions));
	}
	@Test
	// Test pour vérifier que setPlaceList met à jour correctement la liste des places.
    void setPlaceListTest() {
		PetriNetwork Petri= this.PetriCree();
		Place T1= this.PlaceCree(5,Petri);
		Place T2= this.PlaceCree(1,Petri);
		LinkedList<Place> liste_des_Place= new LinkedList<Place>();
		liste_des_Place.add(T1);
		liste_des_Place.add(T2);
		Petri.setPlaceList(liste_des_Place);
		assert(Petri.getPlaceList().equals(liste_des_Place));
		
	}
	// Test pour vérifier que getPlaceList retourne bien la liste actuelle des places.
    
	@Test
	void getPlaceListTest(){
		PetriNetwork Petri= this.PetriCree();
		LinkedList<Place> liste_des_Place= new LinkedList<Place>();
		Petri.setPlaceList(liste_des_Place);
		assert(Petri.getTransitionList().equals(liste_des_Place));
	}
	@Test
	// Test pour vérifier que la méthode addTransition ajoute correctement une transition à PetriNetwork.
    void addTransitionTest()  {
		PetriNetwork Petri= this.PetriCree();
		
		Transition T1= this.TransitionCree(Petri);
		LinkedList<Transition> liste_des_transitions2= new LinkedList<Transition>();
		liste_des_transitions2.add(T1);
		assertEquals(Petri.getTransitionList().get(0),liste_des_transitions2.get(0));
		
		
	}
	
	// Test pour vérifier que la méthode rmTransition supprime correctement une transition de PetriNetwork.
    
	@Test
	void rmTransitionTest() {
		PetriNetwork Petri= this.PetriCree();
		Place P1= this.PlaceCree(5,Petri);
		Transition T1= this.TransitionCree(Petri);
		Transition T2= this.TransitionCree(Petri);
		Petri.addArcVideur(T2, P1);
		LinkedList<Transition> liste_des_transitions= new LinkedList<Transition>();
		Petri.setTransitionList(liste_des_transitions);
		Petri.addTransition(T1);
		Petri.rmTransition(T1);
		assert(Petri.getTransitionList().size()==0);
		Petri.addTransition(T1);
		Petri.rmTransition(T2);
		assert(Petri.getTransitionList().size()==1);
		
		
		
	}
	@Test
	// Test pour vérifier que la méthode addPlace ajoute correctement une place à PetriNetwork.
    void addPlaceTest() {
		PetriNetwork Petri= this.PetriCree();
		Place T1= this.PlaceCree(5,Petri);
		LinkedList<Place> liste_des_Places= new LinkedList<Place>();
		Petri.setPlaceList(liste_des_Places);
		LinkedList<Place> liste_des_Places2= new LinkedList<Place>();
		liste_des_Places2.add(T1);
		assertEquals(Petri.getPlaceList(),liste_des_Places2);
		
		
	}
	@Test
	// Test pour vérifier que la méthode rmPlace supprime correctement une place de PetriNetwork.
    void rmPlacetest()  {
		
		PetriNetwork Petri= this.PetriCree();
		Place P1= this.PlaceCree(5,Petri);
		Place P2= new Place(6);
		Place P3= new Place(7);
		
		Petri.rmPlace(P1);
		assertEquals(Petri.getPlaceList().size(),0);
		Petri.rmPlace(P2);
		Petri.rmPlace(P3);
		assertEquals(Petri.getPlaceList().size(),0);
	}
	@Test
	// Test pour vérifier que la méthode addArc ajoute correctement un arc à PetriNetwork.
    void addArcTest() {
		PetriNetwork Petri= this.PetriCree();
		Transition T1= this.TransitionCree(Petri);
		Transition T2= this.TransitionCree(Petri);
		
		Place P1= this.PlaceCree(5,Petri);
		Place P2= this.PlaceCree(6,Petri);
		Arc arc= new Arc(5,T1,P1, false);
		Petri.addArc(T1, P1, 5,true, false);
		Petri.addArc(T1, P2, 5,false, false);
		assertEquals(Petri.getArc().get(0), arc);
		
		
	}
	// Test pour vérifier que la méthode addArcZero ajoute correctement un ArcZero à PetriNetwork.
	@Test
	void addArcZeroTest() {
		PetriNetwork Petri=  this.PetriCree();
		
		Transition T1= this.TransitionCree(Petri);
		Transition T2= this.TransitionCree(Petri);

		Place P1= this.PlaceCree(5,Petri);
		
		Arc arc1= new ArcZero(T2,P1,true);
		
		this.arcVCree(T1,P1,Petri);
		Petri.addArcZero(T2, P1);
		
		
		
		assert(Petri.getArc().contains(arc1));
		
		
	}
	// Test pour vérifier que la méthode addArcVideur ajoute correctement un ArcVideur à PetriNetwork.
	@Test
	void addArcVideurTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Transition T2= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Petri.addTransition(T1);
		Petri.addTransition(T2);
		Petri.addPlace(P1);
		Arc arc= new ArcVideur(T1,P1, false);
		Petri.addArcVideur(T1, P1);
		assert(Petri.getArc().get(0).equals(arc));
		
		
	}
	// Test pour vérifier que la méthode changeArcValue change correctement le poids d'un arc dans PetriNetwork.
	   
	@Test
	void changeArcValueTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc2= new Arc(5,T1,P1, false);
		Petri.changeArcValue(arc2, 4);
		assertEquals(arc2.getPoids(),4);
		
		
	}
	// Test pour vérifier que la méthode setPlaceJeton modifie correctement le nombre de jetons d'une place dans PetriNetwork.
    
	@Test
	void setPlaceJetonTest () {
		PetriNetwork Petri= new PetriNetwork();
		Place P1= new Place(5);
		Petri.setPlaceJeton(P1, 3);
		assertEquals(P1.getNbreJetons(),3);
		
	}
	 // Test pour vérifier que la méthode isArcUnique détermine correctement si un arc est unique dans PetriNetwork.
    
	@Test
	void isArcUniqueTest () {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc4= new Arc(8,T1,P1, true);
		Arc arc5= new Arc(0,T1,P1, false);
		Petri.addArc(T1, P1, 0,true, false);
		assert(Petri.isArcUnique(arc5));
		assert(!Petri.isArcUnique(arc4));
		
	}
	@Test
	void PasTest() {
		PetriNetwork Petri= new PetriNetwork();
		//RD4
		Transition T1= this.TransitionCree(Petri);
		Place P1= this.PlaceCree(5,Petri);
		Place P2= this.PlaceCree(0,Petri);
		Place P3= this.PlaceCree(1,Petri);
		Place P4= this.PlaceCree(2,Petri);
		Place P5= this.PlaceCree(2,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArc(T1, P5,4,false,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcVideur(T1, P3);
		Petri.Pas(T1);
		assertEquals(P1.getNbreJetons(),1);
		assertEquals(P2.getNbreJetons(),0);
		assertEquals(P3.getNbreJetons(),0);
		Petri.addArc(T1, P4,4,true,false);
		Petri.Pas(T1);
		assertEquals(P4.getNbreJetons(),2);
		//RD1
		Transition T10= this.TransitionCree(Petri);
		Place P10= this.PlaceCree(3,Petri);
		Petri.addArc(T10, P10,2,true,false);
		assertEquals(P10.getNbreJetons(),3);
		Petri.Pas(T10);
		assertEquals(P10.getNbreJetons(),1);
		//RD2
		Petri= new PetriNetwork();
		Transition T11= this.TransitionCree(Petri);
		Place P11= this.PlaceCree(1,Petri);
		Petri.addArc(T10, P10,2,true,false);
		assertEquals(P10.getNbreJetons(),1);
		Petri.Pas(T10);
		assertEquals(P10.getNbreJetons(),1);
		
		//RD3
		Petri= new PetriNetwork();
		Transition T12= this.TransitionCree(Petri);
		Place P12= this.PlaceCree(4,Petri);
		Place P13= this.PlaceCree(0,Petri);
		Petri.addArc(T10, P12,2,true,false);
		Petri.addArc(T10, P13,1,true,false);
		assertEquals(P12.getNbreJetons(),1);
		assertEquals(P13.getNbreJetons(),0);
		Petri.Pas(T10);
		assertEquals(P12.getNbreJetons(),1);
		assertEquals(P13.getNbreJetons(),1);
		
		
		
		
		
	}
	@Test
	void PasAllTest() {
		PetriNetwork Petri= new PetriNetwork();
		Transition T1=  this.TransitionCree(Petri);
		Transition T2=  this.TransitionCree(Petri);
		Place P1= this.PlaceCree(5,Petri);
		Place P2= this.PlaceCree(0,Petri);
		Place P3= this.PlaceCree(1,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcZero(T2, P3);
		Petri.PasAll();
		assertEquals(P1.getNbreJetons(),1);
		assertEquals(P2.getNbreJetons(),0);
		assertEquals(P3.getNbreJetons(),1);
		
		
	}
	
	@Test
	void testAfficherPetriNet() {
		PetriNetwork Petri= new PetriNetwork();
		Transition T1=  this.TransitionCree(Petri);
		Transition T2=  this.TransitionCree(Petri);
		Place P1= this.PlaceCree(5,Petri);
		Place P2= this.PlaceCree(0,Petri);
		Place P3= this.PlaceCree(1,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcZero(T2, P3);
		
		String FinalMessage = Petri.AfficherPetriNet();
		
		String ExpectedMessage = "Réseau de Petri \n"
				+ "3 places\n"
				+ "2 transitions\n"
				+ "3 arcs\n"
				+ "\n"
				+ "Liste des transitions\n"
				+ "1 : transition, 2 arc(s) entrant(s), 0 arc(s) sortant(s)\n"
				+ "2 : transition, 1 arc(s) entrant(s), 0 arc(s) sortant(s)\n"
				+ "\n"
				+ "Liste des arcs\n"
				+ "1 : arc de type class petrinet.Arc poids 4 (Transition vers place avec 5 jetons)\n"
				+ "2 : arc de type class petrinet.ArcZero poids 1 (Transition vers place avec 0 jetons)\n"
				+ "3 : arc de type class petrinet.ArcZero poids 1 (Transition vers place avec 1 jetons)\n"
				+ "\n"
				+ "Liste des places\n"
				+ "1 : place avec 5 jetons, , 1 arcs sortants,\n"
				+ "2 : place avec 0 jetons, , 1 arcs sortants,\n"
				+ "3 : place avec 1 jetons, , 1 arcs sortants,";		
		assertEquals(FinalMessage, ExpectedMessage);
		
		
		Petri= new PetriNetwork();
		Transition T12= TransitionCree(Petri);
		Place P12= PlaceCree(4,Petri);
		Place P13= PlaceCree(0,Petri);
		Petri.addArc(T12, P12,2,true,false);
		Petri.addArc(T12, P13,1,true,false);
		
		
		ExpectedMessage = "Réseau de Petri\n"
				+ "2 places\n"
				+ "1 transitions\n"
				+ "2 arcs\n"
				+ "\n"
				+ "Liste des transitions\n"
				+ "1 : transition, 2 arc(s) entrant(s), 0 arc(s) sortant(s)\n"
				+ "\n"
				+ "Liste des arcs\n"
				+ "1 : arc de type class petrinet.Arc poids 2 (Transition vers place avec 4 jetons)\n"
				+ "2 : arc de type class petrinet.Arc poids 1 (Transition vers place avec 0 jetons)\n"
				+ "\n"
				+ "Liste des places\n"
				+ "1 : place avec 4 jetons, , 1 arcs sortants,\n"
				+ "2 : place avec 0 jetons, , 1 arcs sortants,\n"
				+ "";		
		
		FinalMessage = Petri.AfficherPetriNet();
		assertEquals(FinalMessage, ExpectedMessage);

	
	}
	

}
