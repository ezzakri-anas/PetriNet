package Test;


import java.util.LinkedList;


import org.junit.jupiter.api.Test;

import petrinet.Arc;
import petrinet.ArcVideur;
import petrinet.ArcZero;
import petrinet.PetriNetwork;
import petrinet.Place;
import petrinet.Transition;

class PetriNetworkTest {

	
	@Test
	void PetriNetworktest() {
		PetriNetwork Petri= new PetriNetwork() ;
		assert(Petri.getPlaceList().size()==0);
		assert(Petri.getTransitionList().size()==0);
		assert(Petri.getArc().size()==0);
		
	}
	
	@Test
	public void setTransitionListTest() {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
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
	public void setPlaceListTest(LinkedList<Place> Places) {
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
	public void addTransitionTest(Transition transition)  {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		LinkedList<Transition> liste_des_transitions2= new LinkedList<Transition>();
		liste_des_transitions2.add(T1);
		assert(Petri.getTransitionList().get(0).equals(liste_des_transitions2.get(0)));
		
	}
	@Test
	public void rmTransitionTest(Transition transition) {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		LinkedList<Transition> liste_des_transitions= new LinkedList<Transition>();
		Petri.setTransitionList(liste_des_transitions);
		Petri.addTransition(T1);
		Petri.rmTransition(T1);
		assert(Petri.getTransitionList().size()==0);
		
	}
	@Test
	public void addPlaceTest(Place place) {
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
	public void rmPlacetest(Place place)  {
		
		PetriNetwork Petri= new PetriNetwork();
		Place T1= new Place(5);
		LinkedList<Place> liste_des_Places= new LinkedList<Place>();
		Petri.setPlaceList(liste_des_Places);
		Petri.addPlace(T1);
		Petri.rmPlace(T1);
		assert(Petri.getPlaceList().size()==0);
	}
	@Test
	public void addArcTest(Transition transition, Place place, int poids, boolean isZeroorVideur) {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc= new Arc(5,T1,P1, false);
		Petri.addArc(T1, P1, 5, false);
		assert(Petri.getArc().get(0).equals(arc));
		
		
	}
	public void addArcZeroTest(Transition transition, Place place, int poids, boolean isZeroorVideur) {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc= new ArcZero(T1,P1,true);
		Petri.addArcZero(T1, P1);
		assert(Petri.getArc().get(0).equals(arc));
		
		
	}
	public void addArcVideurTest(Transition transition, Place place, int poids, boolean isZeroorVideur) {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc= new ArcVideur(T1,P1, false);
		Petri.addArcVideur(T1, P1);
		assert(Petri.getArc().get(0).equals(arc));
		
		
	}
	@Test
	public void changeArcValueTest(Arc arc, int poids) {
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
	public void setPlaceJetonTest (Place place, int nbrejetons) {
		PetriNetwork Petri= new PetriNetwork();
		Place P1= new Place(5);
		Petri.setPlaceJeton(P1, 3);
		assert(P1.getNbreJetons()==3);
		
	}
	@Test
	public void isArcUniqueTest (Arc arc) {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Arc arc4= new Arc(8,T1,P1, true);
		Petri.addArc(T1, P1, 0, false);
		assert(Petri.isArcUnique(arc4));
		
	}
	@Test
	public void PasTest(Transition T) {
		PetriNetwork Petri= new PetriNetwork();
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Place P1= new Place(5);
		Place P2= new Place(0);
		Place P3= new Place(1);
		Petri.addArc(T1, P1,4,true);
		Petri.addArcZero(T1, P2);
		Petri.addArcVideur(T1, P3);
		Petri.Pas(T1);
		assert((P1.getNbreJetons()==1)&(P2.getNbreJetons()==0)&(P3.getNbreJetons()==0));
		
		
		
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
		Petri.addArc(T1, P1,4,true);
		Petri.addArcZero(T1, P2);
		Petri.addArcVideur(T2, P3);
		Petri.Pas(T1);
		assert((P1.getNbreJetons()==1)&(P2.getNbreJetons()==0)&(P3.getNbreJetons()==0));
		
		
	}
	
	

	

}
