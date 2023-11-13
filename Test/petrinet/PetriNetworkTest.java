package petrinet;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
//Classe de test pour PetriNetwork, utilisant JUnit pour effectuer des tests unitaires.

class PetriNetworkTest {
	// Crée une instance de PetriNetwork pour les tests.

	PetriNetwork create_petrinetwork_for_test() {
		return new PetriNetwork() ;


	}
	@Ignore
	// Crée une transition pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
	Transition create_transition_for_test( PetriNetwork Petri) {
		LinkedList<Arc> inputArcs= new LinkedList<Arc>() ;
		LinkedList<Arc> outputArcs= new LinkedList<Arc>() ;
		Transition T1= new Transition(inputArcs,outputArcs);
		Petri.addTransition(T1);
		return T1;


	}
	@Ignore
	// Crée une place pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.
	Place create_place_for_test(int weight,PetriNetwork Petri) {

		Place T1= new Place(weight);
		Petri.addPlace(T1);
		return T1;

	}
	// Crée un arc pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.

	@Ignore

	Arc create_arc_for_test(int weight, Transition transition, Place place,boolean entrsortie, boolean isVideurOrZero,PetriNetwork Petri) {
		Arc arc= new Arc( weight,transition, place, isVideurOrZero);
		Petri.addArc(transition, place, weight, entrsortie, isVideurOrZero);

		return arc;


	}
	@Ignore
	// Crée un ArcVideur pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.

	Arc create_arc_videur_for_test(Transition transition, Place place, PetriNetwork Petri) {
		Arc arc= new ArcVideur(transition,place ,true);
		Petri.addArcVideur(transition, place);

		return arc;

	}
	// Crée un ArcZero pour les tests. @Ignore indique que cette méthode est ignorée lors des tests unitaires.

	@Ignore
	Arc create_arc_zero_for_test( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcZero(transition,place ,true);
		Petri.addArcZero(transition, place);

		return arc;

	}
	@Test
	// Test pour vérifier l'initialisation correcte d'un PetriNetwork.
	void PetriNetworktest() {
		PetriNetwork Petri= this.create_petrinetwork_for_test() ;
		assert(Petri.getPlaceList().size()==0);
		assert(Petri.getTransitionList().size()==0);
		assert(Petri.getArc().size()==0);


	}
	// Test pour vérifier le fonctionnement de setTransitionList.

	@Test
	void setTransitionListTest() {
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		Transition T1= this.create_transition_for_test(Petri);
		Transition T2= this.create_transition_for_test(Petri);
		LinkedList<Transition> list_of_transitions= new LinkedList<Transition>();
		list_of_transitions.add(T1);
		list_of_transitions.add(T2);
		Petri.setTransitionList(list_of_transitions);
		assert(Petri.getTransitionList().equals(list_of_transitions));
	}
	@Test
	// Test pour vérifier que getTransitionList retourne bien la liste actuelle des transitions.
	void getTransitionListTest(){
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		LinkedList<Transition> list_of_transitions= new LinkedList<Transition>();
		Petri.setTransitionList(list_of_transitions);
		assert(Petri.getTransitionList().equals(list_of_transitions));
	}
	@Test
	// Test pour vérifier que setPlaceList met à jour correctement la liste des places.
	void setPlaceListTest() {
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		Place T1= this.create_place_for_test(5,Petri);
		Place T2= this.create_place_for_test(1,Petri);
		LinkedList<Place> list_of_places= new LinkedList<Place>();
		list_of_places.add(T1);
		list_of_places.add(T2);
		Petri.setPlaceList(list_of_places);
		assert(Petri.getPlaceList().equals(list_of_places));

	}
	// Test pour vérifier que getPlaceList retourne bien la liste actuelle des places.

	@Test
	void getPlaceListTest(){
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		LinkedList<Place> list_of_places= new LinkedList<Place>();
		Petri.setPlaceList(list_of_places);
		assert(Petri.getTransitionList().equals(list_of_places));
	}
	@Test
	// Test pour vérifier que la méthode addTransition ajoute correctement une transition à PetriNetwork.
	void addTransitionTest()  {
		PetriNetwork Petri= this.create_petrinetwork_for_test();

		Transition T1= this.create_transition_for_test(Petri);
		LinkedList<Transition> list_of_transitions2= new LinkedList<Transition>();
		list_of_transitions2.add(T1);
		assertEquals(Petri.getTransitionList().get(0),list_of_transitions2.get(0));


	}

	// Test pour vérifier que la méthode rmTransition supprime correctement une transition de PetriNetwork.

	@Test
	void removeTransitionTest() {
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		Place P1= this.create_place_for_test(5,Petri);
		Transition T1= this.create_transition_for_test(Petri);
		Transition T2= this.create_transition_for_test(Petri);
		Petri.addArcVideur(T2, P1);
		LinkedList<Transition> list_of_transitions = new LinkedList<Transition>();
		Petri.setTransitionList(list_of_transitions);
		Petri.addTransition(T1);
		Petri.removeTransition(T1);
		assert(Petri.getTransitionList().size()==0);
		Petri.addTransition(T1);
		Petri.removeTransition(T2);
		assert(Petri.getTransitionList().size()==1);
	}

	@Test
	// Test pour vérifier que la méthode addPlace ajoute correctement une place à PetriNetwork.
	void addPlaceTest() {
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		Place T1= this.create_place_for_test(5,Petri);
		LinkedList<Place> list_of_places= new LinkedList<Place>();
		Petri.setPlaceList(list_of_places);
		LinkedList<Place> list_of_places2 = new LinkedList<Place>();
		list_of_places2.add(T1);
		assertEquals(Petri.getPlaceList(), list_of_places2);


	}
	@Test
	// Test pour vérifier que la méthode rmPlace supprime correctement une place de PetriNetwork.
	void removePlacetest()  {

		PetriNetwork Petri= this.create_petrinetwork_for_test();
		Place P1= this.create_place_for_test(5,Petri);
		Place P2= new Place(6);
		Place P3= new Place(7);

		Petri.removePlace(P1);
		assertEquals(Petri.getPlaceList().size(),0);
		Petri.removePlace(P2);
		Petri.removePlace(P3);
		assertEquals(Petri.getPlaceList().size(),0);
	}
	@Test
	// Test pour vérifier que la méthode addArc ajoute correctement un arc à PetriNetwork.
	void addArcTest() {
		PetriNetwork Petri= this.create_petrinetwork_for_test();
		Transition T1= this.create_transition_for_test(Petri);
		Transition T2= this.create_transition_for_test(Petri);

		Place P1= this.create_place_for_test(5,Petri);
		Place P2= this.create_place_for_test(6,Petri);
		Arc arc= new Arc(5,T1,P1, false);
		Petri.addArc(T1, P1, 5,true, false);
		Petri.addArc(T1, P2, 5,false, false);
		assertEquals(Petri.getArc().get(0), arc);


	}
	// Test pour vérifier que la méthode addArcZero ajoute correctement un ArcZero à PetriNetwork.
	@Test
	void addArcZeroTest() {
		PetriNetwork Petri=  this.create_petrinetwork_for_test();

		Transition T1= this.create_transition_for_test(Petri);
		Transition T2= this.create_transition_for_test(Petri);

		Place P1= this.create_place_for_test(5,Petri);

		Arc arc1= new ArcZero(T2,P1,true);

		this.create_arc_videur_for_test(T1,P1,Petri);
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
		assertEquals(arc2.getWeight(),4);


	}
	// Test pour vérifier que la méthode setPlaceJeton modifie correctement le nombre de jetons d'une place dans PetriNetwork.

	@Test
	void setPlaceTokenTest () {
		PetriNetwork Petri= new PetriNetwork();
		Place P1= new Place(5);
		Petri.setPlaceToken(P1, 3);
		assertEquals(P1.getTokenNbre(),3);

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
	void stepTest() {
		PetriNetwork Petri= new PetriNetwork();
		//RD4
		Transition T1= this.create_transition_for_test(Petri);
		Place P1= this.create_place_for_test(5,Petri);
		Place P2= this.create_place_for_test(0,Petri);
		Place P3= this.create_place_for_test(1,Petri);
		Place P4= this.create_place_for_test(2,Petri);
		Place P5= this.create_place_for_test(2,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArc(T1, P5,4,false,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcVideur(T1, P3);
		Petri.step(T1);
		assertEquals(P1.getTokenNbre(),1);
		assertEquals(P2.getTokenNbre(),0);
		assertEquals(P3.getTokenNbre(),0);
		Petri.addArc(T1, P4,4,true,false);
		Petri.step(T1);
		assertEquals(P4.getTokenNbre(),2);
		//RD1
		Transition T10= this.create_transition_for_test(Petri);
		Place P10= this.create_place_for_test(3,Petri);
		Petri.addArc(T10, P10,2,true,false);
		assertEquals(P10.getTokenNbre(),3);
		Petri.step(T10);
		assertEquals(P10.getTokenNbre(),1);
		//RD2
		Petri= new PetriNetwork();
		Transition T11= this.create_transition_for_test(Petri);
		Place P11= this.create_place_for_test(1,Petri);
		Petri.addArc(T10, P10,2,true,false);
		assertEquals(P10.getTokenNbre(),1);
		Petri.step(T10);
		assertEquals(P10.getTokenNbre(),1);

		//RD3
		Petri= new PetriNetwork();
		Transition T12= this.create_transition_for_test(Petri);
		Place P12= this.create_place_for_test(4,Petri);
		Place P13= this.create_place_for_test(0,Petri);
		Petri.addArc(T10, P12,2,true,false);
		Petri.addArc(T10, P13,1,true,false);
		assertEquals(P12.getTokenNbre(),1);
		assertEquals(P13.getTokenNbre(),0);
		Petri.step(T10);
		assertEquals(P12.getTokenNbre(),1);
		assertEquals(P13.getTokenNbre(),1);





	}
	@Test
	void stepAllTest() {
		PetriNetwork Petri= new PetriNetwork();
		Transition T1=  this.create_transition_for_test(Petri);
		Transition T2=  this.create_transition_for_test(Petri);
		Place P1= this.create_place_for_test(5,Petri);
		Place P2= this.create_place_for_test(0,Petri);
		Place P3= this.create_place_for_test(1,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcZero(T2, P3);
		Petri.stepAll();
		assertEquals(P1.getTokenNbre(),1);
		assertEquals(P2.getTokenNbre(),0);
		assertEquals(P3.getTokenNbre(),1);


	}

	@Test
	void showPetriNetTest() {
		PetriNetwork Petri= new PetriNetwork();
		Transition T1=  this.create_transition_for_test(Petri);
		Transition T2=  this.create_transition_for_test(Petri);
		Place P1= this.create_place_for_test(5,Petri);
		Place P2= this.create_place_for_test(0,Petri);
		Place P3= this.create_place_for_test(1,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcZero(T2, P3);

		String final_message = Petri.showPetriNet();

		String expected_message = "Réseau de Petri \n"
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
		assertEquals(final_message, expected_message);


		Petri= new PetriNetwork();
		Transition T12= create_transition_for_test(Petri);
		Place P12= create_place_for_test(4,Petri);
		Place P13= create_place_for_test(0,Petri);
		Petri.addArc(T12, P12,2,true,false);
		Petri.addArc(T12, P13,1,true,false);


		expected_message = "Réseau de Petri\n"
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

		final_message = Petri.showPetriNet();
		assertEquals(final_message, expected_message);


	}


}
