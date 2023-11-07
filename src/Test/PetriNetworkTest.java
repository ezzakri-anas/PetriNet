package Test;


import static org.junit.Assert.assertEquals;

import java.util.LinkedList;


import org.junit.jupiter.api.Test;

import petrinet.Arc;
import petrinet.ArcVideur;
import petrinet.ArcZero;
import petrinet.PetriNetwork;
import petrinet.Place;
import petrinet.Transition;

class PetriNetworkTest {

	PetriNetwork PetriCree() {
		return new PetriNetwork() ;
		
		
	}
	void TransitionCree( PetriNetwork Petri) {
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		
		
	}
	void PlaceCree(int poids,PetriNetwork Petri) {
		
		Place T1= new Place(poids);
		Petri.addPlace(T1);
		
	}
	void arcCree(int poids, Transition transition, Place place,boolean entrsortie, boolean isVideurOrZero,PetriNetwork Petri) {
		Arc arc= new Arc( poids,transition, place, isVideurOrZero);
		Petri.addArc(transition, place, poids, entrsortie, isVideurOrZero);
		if(entrsortie) {
			transition.addArcEntrant(arc);
		}
		else
		{
			transition.addArcsortant(arc);
		}
		
		
	}
	void arcVCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcVideur(transition,place ,true);
		Petri.addArcVideur(transition, place);
		transition.addArcEntrant(arc);
		
	}
	void arcZCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcZero(transition,place ,true);
		Petri.addArcZero(transition, place);
		transition.addArcEntrant(arc);
		
	}
	@Test
	void PetriNetworktest() {
		PetriNetwork Petri= this.PetriCree() ;
		assert(Petri.getPlaceList().size()==0);
		assert(Petri.getTransitionList().size()==0);
		assert(Petri.getArc().size()==0);
		
	}
	
	@Test
	public void setTransitionListTest() {
		PetriNetwork Petri= this.PetriCree();
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Transition T2= new Transition(arcsEntrants,arcsSortants);
		LinkedList<Transition> liste_des_transitions= new LinkedList<Transition>();
		liste_des_transitions.add(T1);
		liste_des_transitions.add(T2);
		Petri.setTransitionList(liste_des_transitions);
		assert(Petri.getTransitionList().equals(liste_des_transitions));
	}
	@Test
	public void getTransitionListTest(){
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Transition> liste_des_transitions= new LinkedList<Transition>();
		Petri.setTransitionList(liste_des_transitions);
		assert(Petri.getTransitionList().equals(liste_des_transitions));
	}
	@Test
	public void setPlaceListTest() {
		PetriNetwork Petri= new PetriNetwork();
		Place T1= new Place(5);
		Place T2= new Place(1);
		LinkedList<Place> liste_des_Place= new LinkedList<Place>();
		liste_des_Place.add(T1);
		liste_des_Place.add(T2);
		Petri.setPlaceList(liste_des_Place);
		assert(Petri.getPlaceList().equals(liste_des_Place));
		
	}
	@Test
	public  void getPlaceListTest(){
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Place> liste_des_Place= new LinkedList<Place>();
		Petri.setPlaceList(liste_des_Place);
		assert(Petri.getTransitionList().equals(liste_des_Place));
	}
	@Test
	public void addTransitionTest()  {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		LinkedList<Transition> liste_des_transitions2= new LinkedList<Transition>();
		liste_des_transitions2.add(T1);
		assertEquals(Petri.getTransitionList().get(0),liste_des_transitions2.get(0));
		
		
	}
	

	@Test
	public void rmTransitionTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Place P1= new Place(5);
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Transition T2= new Transition(arcsEntrants,arcsSortants);
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
	public void addPlaceTest() {
		PetriNetwork Petri= new PetriNetwork();
		Place T1= new Place(5);
		LinkedList<Place> liste_des_Places= new LinkedList<Place>();
		Petri.setPlaceList(liste_des_Places);
		Petri.addPlace(T1);
		LinkedList<Place> liste_des_Places2= new LinkedList<Place>();
		liste_des_Places2.add(T1);
		assert(Petri.getPlaceList().equals(liste_des_Places2));
		
		
	}
	@Test
	public void rmPlacetest()  {
		
		PetriNetwork Petri= new PetriNetwork();
		Place P1= new Place(5);
		Place P2= new Place(6);
		LinkedList<Place> liste_des_Places= new LinkedList<Place>();
		Petri.setPlaceList(liste_des_Places);
		Petri.addPlace(P1);
		Petri.rmPlace(P1);
		assert(Petri.getPlaceList().size()==0);
		Petri.addPlace(P2);
		Petri.rmPlace(P1);
		assert(Petri.getPlaceList().size()==1);
	}
	@Test
	public void addArcTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Transition T2= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		Petri.addTransition(T2);
		Place P1= new Place(5);
		Place P2= new Place(5);
		Arc arc= new Arc(5,T1,P1, false);
		Petri.addArc(T1, P1, 5,true, false);
		Petri.addArc(T1, P2, 5,false, false);
		assert(Petri.getArc().get(0).equals(arc));
		
		
	}
	public void addArcZeroTest() {
		PetriNetwork Petri= new PetriNetwork();
		
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Transition T2= new Transition(arcsEntrants,arcsSortants);


		Place P1= new Place(5);
		
		Arc arc1= new ArcZero(T2,P1,true);
		
		Petri.addArcZero(T2, P1);
		T2.addArcEntrant(arc1);
		Petri.addTransition(T1);
		Petri.addTransition(T2);
		Petri.addPlace(P1);
		Arc arc= new ArcZero(T1,P1,true);
		
		Petri.addArcZero(T1, P1);
		assert(Petri.getArc().get(1).equals(arc));
		
		
	}
	public void addArcVideurTest() {
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
	@Test
	public void changeArcValueTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc2= new Arc(5,T1,P1, false);
		Petri.changeArcValue(arc2, 4);
		assert(arc2.getPoids()==4);
		
		
	}
	@Test
	public void setPlaceJetonTest () {
		PetriNetwork Petri= new PetriNetwork();
		Place P1= new Place(5);
		Petri.setPlaceJeton(P1, 3);
		assert(P1.getNbreJetons()==3);
		
	}
	@Test
	public void isArcUniqueTest () {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc4= new Arc(8,T1,P1, true);
		Arc arc5= new Arc(0,T1,P1, false);
		Petri.addArc(T1, P1, 0,true, false);
		Petri.getArc().add(arc5);
		assert(Petri.isArcUnique(arc4));
		assert(!Petri.isArcUnique(arc5));
		
	}
	@Test
	public void PasTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Place P2= new Place(0);
		Place P3= new Place(1);
		Place P4= new Place(2);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcVideur(T1, P3);
		Petri.Pas(T1);
		assert((P1.getNbreJetons()==1)&&(P2.getNbreJetons()==0)&&(P3.getNbreJetons()==0));
		Petri.addArc(T1, P4,4,true,false);
		Petri.Pas(T1);
		
		
	}
	@Test
	public void PasAllTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Transition T2= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Place P2= new Place(0);
		Place P3= new Place(1);
		Petri.addArc(T1, P1,4,true,true);
		Petri.addArcZero(T1, P2);
		Petri.addArcVideur(T2, P3);
		Petri.Pas(T1);
		assert((P1.getNbreJetons()==1)&(P2.getNbreJetons()==0)&(P3.getNbreJetons()==0));
		
		
	}
	
	

	

}
