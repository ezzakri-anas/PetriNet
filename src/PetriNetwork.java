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
	public void addTransition(Transition transition)  {
		this.liste_des_transitions.add(transition);
		
	}
	public void rmTransition(Transition transition) {
		for (Transition transitions : this.liste_des_transitions) {
			if (transitions.equals(transition)) {
				this.liste_des_transitions.remove(transition);
				
			}
		}
		
	}
	public void addPlace(Place place) {
		this.liste_des_places.add(place);
		
	}
	public void rmPlace(Place place)  {
		for (Place transitions : this.liste_des_places) {
			if (transitions.equals(place)) {
				this.liste_des_transitions.remove(place);
				
			}
		}
		
	}
	public void addArc(Transition transition, Place place, int poids, boolean isZeroorVideur) {
		Arc arc= new Arc(poids,transition,place, isZeroorVideur);
		this.liste_des_arcs.add(arc);
	}
	public void changeArcValue (Arc arc, int poids) {
		arc.setPoids(poids);
		
	}
	public void setPlaceJeton (Place place, int nbrejetons) {
		place.setNbreJetons(nbrejetons);
		
	}
	public boolean isArcUnique (Arc arc) {
		for (Arc transitions : this.liste_des_arcs) {
			if (transitions.equals(arc)) {
				return true;
				
			}
		}
		return false;
		
	}
	public void Pas(Transition T) {
		for (Arc arc : T.getArcsEntrants()) {
			if(arc.isVideurOrZero()) {
				arc.fire();
			}
			else {
				if(arc.isActive()) {
				Place place= arc.getPlace();
				place.rmNbreJetons(arc.getPoids());	
		}
			}
		for (Arc arc1 : T.getArcsSortants()) {
			Place place= arc1.getPlace();
			place.setNbreJetons(place.getNbreJetons()+arc1.getPoids());	
		}
			
		}
		
		
	}
	public void PasAll() {
		for (Transition T : this.liste_des_transitions) {
			this.Pas(T);
			}
		
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
