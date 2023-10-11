import java.util.LinkedList;



public class PetriNetwork {
	private LinkedList<Arc> liste_des_arcs;
	private LinkedList<Transition> liste_des_transitions;
	private LinkedList<Place> liste_des_places;
	
	
	public PetriNetwork() {
		this.liste_des_arcs= new LinkedList<Arc>();
		this.liste_des_transitions= new LinkedList<Transition>();
		this.liste_des_places=new LinkedList<Place>();
	}
	public void setTransitionList(LinkedList<Transition> Transitions) {
		this.liste_des_transitions=Transitions;
	}
	public LinkedList<Transition> getTransitionList(){
		return this.liste_des_transitions;
	}
	public void setPlaceList(LinkedList<Place> Places) {
		this.liste_des_places=Places;
		
	}
	public LinkedList<Place>  getPlaceList(){
		return this.liste_des_places;
	}
	public Void addTransition(Transition transition)  {
		this.liste_des_transitions.add(transition);
		
	}
	public Void rmTransition(Transition transition) {
		for (Transition transitions : this.liste_des_transitions) {
			if (transitions.equals(transition)) {
				this.liste_des_transitions.remove(transition);
				
			}
		}
		
	}
	public Void addPlace(Place place) {
		this.liste_des_places.add(place);
		
	}
	public Void rmPlace(Place place)  {
		for (Place transitions : this.liste_des_places) {
			if (transitions.equals(place)) {
				this.liste_des_transitions.remove(place);
				
			}
		}
		
	}
	public Void addArc(Transition transition, Place place, int poids, boolean isZeroorVideur) {
		Arc arc= new Arc(poids,transition,place, isZeroorVideur);
		this.liste_des_arcs.add(arc);
	}
	public Void changeArcValue (Arc arc, int poids) {
		arc.setPoids(poids);
		
	}
	public Void setPlaceJeton (Place place, int nbrejetons) {
		place.setNbreJetons(nbrejetons);
		
	}
	public Bool isArcUnique (Arc arc) {
		for (Arc transitions : this.liste_des_arcs) {
			if (transitions.equals(arc)) {
				return true;
				
			}
		}
		return false;
		
	}
	public Void Pas(Transition) {
		
	}
	public Void PasAll() {
		
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
