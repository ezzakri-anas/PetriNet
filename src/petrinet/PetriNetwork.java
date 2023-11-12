package petrinet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//Classe principale représentant un réseau de 
	//Petri, contenant des places, transitions et arcs.
public class PetriNetwork {
	private LinkedList<Arc> liste_des_arcs;
	private LinkedList<Transition> liste_des_transitions;
	private LinkedList<Place> liste_des_places;
	
	
	// Constructeur de la classe PetriNetwork. Initialise les 
	//listes pour les arcs, transitions et places.
	public PetriNetwork() {
		this.liste_des_arcs= new LinkedList<Arc>();
		this.liste_des_transitions= new LinkedList<Transition>();
		this.liste_des_places=new LinkedList<Place>();
	}
	
	// Méthode pour définir la liste des transitions dans le réseau.
	//Prend en paramètre une liste de transitions.
    
	public void setTransitionList(LinkedList<Transition> Transitions) {
		this.liste_des_transitions=Transitions;
	}
	// Méthode pour obtenir la liste actuelle des transitions 
	//dans le réseau.
    
	public LinkedList<Transition> getTransitionList(){
		return this.liste_des_transitions;
	}
	// Méthode pour définir la liste des places dans le réseau. Prend en paramètre une liste de places.
    
	public void setPlaceList(LinkedList<Place> Places) {
		this.liste_des_places=Places;
		
	}
	// Méthode pour obtenir la liste actuelle des places dans le réseau.
    
	public LinkedList<Place>  getPlaceList(){
		return this.liste_des_places;
	}
	// Ajoute une transition spécifique au réseau. Prend en paramètre un objet Transition.
    
	public void addTransition(Transition transition)  {
		this.liste_des_transitions.add(transition);
		
	}
	// Supprime une transition spécifique du réseau. Recherche et supprime la transition correspondante.
    
	public void rmTransition(Transition transition) {
		for (Transition transitions : this.getTransitionList()) {
			if (transitions.equals(transition)) {
				this.liste_des_transitions.remove(transition);
				
			}
		}
		
	}
	// Ajoute une place spécifique au réseau. Prend en paramètre un objet Place.
    
	public void addPlace(Place place) {
		this.liste_des_places.add(place);
		
	}
	 // Supprime une place spécifique du réseau. Recherche et supprime la place correspondante.
    
	public void rmPlace(Place place)  {
		for (Place P : this.liste_des_places) {
			if (P.equals(place)) {
				this.liste_des_places.remove(place);
				
			}
		}
		
	}
	// Ajoute un arc au réseau. Prend plusieurs paramètres pour spécifier la transition, la place, le poids et le type de l'arc.
    
	//entrée 1 sortie 0
	public void addArc(Transition transition, Place place, int poids,boolean entrsort, boolean isZeroorVideur) {
		Arc arc= new Arc(poids,transition,place, isZeroorVideur);
		if (this.isArcUnique(arc)) {
			this.liste_des_arcs.add(arc);
			for(Transition T: this.liste_des_transitions) {
				if(T.equals(transition)) {
					if(entrsort) {
						T.addArcEntrant(arc);
					}
					else {
						T.addArcsortant(arc);
					}
				}
			}
		}
		
	}
	// Ajoute un ArcZero au réseau. Un ArcZero est un type spécial d'arc avec des règles de tirage spécifiques.
    
	public void addArcZero(Transition transition, Place place) {
		Arc arc= new ArcZero(transition, place, true);
		if (this.isArcUnique(arc)) {
		this.liste_des_arcs.add(arc);
		for(Transition T: this.liste_des_transitions) {
			if(T.equals(transition)) {
				
				T.addArcEntrant(arc);
				
				
			}
		}
	}
	}
	// Ajoute un ArcVideur au réseau. Un ArcVideur est un type spécial d'arc qui vide entièrement la place de ses jetons lorsqu'il est tiré.
    
	public void addArcVideur(Transition transition, Place place) {
		Arc arc=new ArcVideur(transition,  place, true);
		if (this.isArcUnique(arc)) {
		this.liste_des_arcs.add(arc);
		for(Transition T: this.liste_des_transitions) {
			if(T.equals(transition)) {
				
				T.addArcEntrant(arc);
				
				
			}
		}
	}
	}
	// Ajoute un ArcVideur au réseau. Un ArcVideur est un type spécial d'arc qui vide entièrement la place de ses jetons lorsqu'il est tiré.
    
	public LinkedList<Arc> getArc() {
		
		return this.liste_des_arcs;
	}
	 // Modifie la valeur d'un arc spécifique. Utile pour changer le poids d'un arc après sa création.
    
	public void changeArcValue (Arc arc, int poids) {
		arc.setPoids(poids);
		
	}
	// Définit le nombre de jetons pour une place donnée. Cette méthode est utilisée pour initialiser ou modifier l'état d'une place.
    
	public void setPlaceJeton (Place place, int nbrejetons) {
		place.setNbreJetons(nbrejetons);
		
	}
	// Vérifie si un arc donné est unique dans le réseau. Cette méthode assure qu'il n'y a pas de doublons d'arcs.
    
	public boolean isArcUnique (Arc arc) {
		for (Arc arc_transitions : this.liste_des_arcs) {
			if (arc_transitions.equals(arc)) {
				return false;
				
			}
		}
		return true;
		
	}
	 // Méthode pour exécuter un pas (tirage) sur une transition donnée. Vérifie si la transition est tirable et met à jour l'état du réseau en conséquence.
    
	public void Pas(Transition T) {
		//on verifie d abrd que c est titable
		
		boolean tirable= true;
		for (Arc arc : T.getArcsEntrants()) {
			if(!arc.isActive()) {
				tirable= false;
			}
			
				
			}
		if(tirable) {
			for (Arc arc : T.getArcsEntrants()) {
			if(arc.isVideurOrZero()) {
				arc.fire();
			}
			else {
				if(arc.isActive()) {
				arc.getPlace().rmNbreJetons(arc.getPoids());	
		}
			}
		for (Arc arc1 : T.getArcsSortants()) {
			arc1.getPlace().setNbreJetons(arc1.getPlace().getNbreJetons()+arc1.getPoids());	
		}
			
		}
		}
		
		
	}
	// Exécute un pas (tirage) sur toutes les transitions du réseau. Cette méthode permet de simuler l'avancement du réseau de Petri.
    
	public void PasAll() {
		for (Transition T : this.liste_des_transitions) {
			this.Pas(T);
			}
		
	}
	
	 // Affiche l'état actuel du réseau de Petri, incluant les informations sur les places, transitions et arcs.
    
	public void AfficherPetriNet() {
		
		String MessageFinal = "Réseau de Petri \n";
		
		int nbre_arcs = this.liste_des_arcs.size();
		int nbre_transitions = this.liste_des_transitions.size();
		int nbre_places = this.liste_des_places.size();
		
		MessageFinal += nbre_places + " places\n";
		MessageFinal += nbre_transitions + " transitions\n";	
		MessageFinal += nbre_arcs + " arcs\n";	
		

		String MessageTransitions = "\nListe des transitions\n";
		
		for(int i=0; i<nbre_transitions; i++) {
			Transition t = this.liste_des_transitions.get(i);
			LinkedList<Arc> arcs_entrants = t.getArcsEntrants();
			LinkedList<Arc> arcs_sortants = t.getArcsSortants();
			MessageTransitions += i+1 + " : transition, " + arcs_entrants.size() + " arc(s) entrant(s), " + arcs_sortants.size() + " arc(s) sortant(s)\n";	
		}
		
		MessageFinal += MessageTransitions;
		
		Map<Object, Object> Arc_destination = new HashMap<>();
		Map<Object, Object> Arc_source = new HashMap<>();
		
		Map<Object, LinkedList<Object>> Place_entrants = new HashMap<>();
		Map<Object, LinkedList<Object>> Place_sortants = new HashMap<>();
		
		for(int i=0; i<nbre_transitions; i++) {
			Transition t = this.liste_des_transitions.get(i);
			
			LinkedList<Arc> arcs_entrants = t.getArcsEntrants();
			LinkedList<Arc> arcs_sortants = t.getArcsSortants();
			
			
			for(int j=0; j<arcs_entrants.size(); j++) {
				Arc arc = arcs_entrants.get(j);
				
				Place place = arc.getPlace();
				
				Arc_destination.put(arc, t);
				Arc_source.put(arc, arc.getPlace());
				
				if(Place_sortants.containsKey(place)) {
					LinkedList<Object> values = Place_sortants.get(place);
					values.addFirst(arc);
					Place_sortants.put(place, values);
				} else {
					LinkedList<Object> values = new LinkedList<Object>();
					values.addFirst(arc);
					Place_sortants.put(place, values);
				}
			}
			
			for(int j=0; j<arcs_sortants.size(); j++) {
				Arc arc = arcs_sortants.get(j);
				Place place = arc.getPlace();
				
				Arc_destination.put(arc, arc.getPlace());
				Arc_source.put(arc, t);
				
				if(Place_entrants.containsKey(place)) {
					LinkedList<Object> values = Place_entrants.get(place);
					values.addFirst(arc);
					Place_entrants.put(place, values);
				} else {
					LinkedList<Object> values = new LinkedList<Object>();
					values.addFirst(arc);
					Place_entrants.put(place, values);
				}
			}
		}
		
		String MessageArcs = "\nListe des arcs\n";	
		
		for(int i=0; i<nbre_arcs; i++) {
			Arc arc = this.liste_des_arcs.get(i);
			
			Class<?> arc_class = arc.getClass();
			
			if(Arc_destination.get(arc) instanceof Place) {
				MessageArcs += i+1 + " : arc de type " + arc_class + " poids " + arc.getPoids() + 
						" (place avec " + arc.getPlace().getNbreJetons() + " jetons vers transition)\n";	
			} else {
				MessageArcs += i+1 + " : arc de type " + arc_class + " poids " + arc.getPoids() + 
						" (Transition vers place avec " + arc.getPlace().getNbreJetons() + " jetons)\n";	
			}
		}
		
		MessageFinal += MessageArcs;
		
		
		String MessagePlace = "\nListe des places\n";
		
		for(int i=0; i<nbre_places; i++) {
			String message_arc_entrant = "";
			String message_arc_sortant = "";
			
			Place place = this.liste_des_places.get(i);
			if(Place_entrants.containsKey(place)) {
				int nbre_arc_entrant = Place_entrants.get(place).size();
				message_arc_entrant = " " + nbre_arc_entrant + " arcs entrants,";
			}
			
			if(Place_sortants.containsKey(place)) {
				int nbre_arc_sortant = Place_sortants.get(place).size();
				message_arc_sortant = " " + nbre_arc_sortant + " arcs sortants,";
			}

			MessagePlace += i+1 + " : place avec " + place.getNbreJetons() + " jetons, " + message_arc_entrant + "," + message_arc_sortant +"\n";
		}
		
		MessageFinal += MessagePlace;
		
		System.out.println(MessageFinal);
		
	}
	// Méthode principale pour exécuter et tester le réseau de Petri. Crée un réseau, y ajoute des éléments et exécute des pas.
    
	public static void main(String[] args) {
		PetriNetwork Petri= new PetriNetwork();
		Transition T1=  TransitionCree(Petri);
		Transition T2=  TransitionCree(Petri);
		Place P1= PlaceCree(5,Petri);
		Place P2= PlaceCree(0,Petri);
		Place P3= PlaceCree(1,Petri);
		Petri.addArc(T1, P1,4,true,false);
		Petri.addArcZero(T1, P2);
		Petri.addArcZero(T2, P3);
		
//		Petri.AfficherPetriNet();

		
		Petri.PasAll();
		
		
		Petri.AfficherPetriNet();

	}
	
	
	// Méthode utilitaire pour créer une nouvelle transition, l'ajouter au réseau et la retourner.
    
	public static Transition TransitionCree( PetriNetwork Petri) {
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		return T1;
		
		
	}
	// Méthode utilitaire pour créer une nouvelle place, l'ajouter au réseau et la retourner.
    
	public static Place PlaceCree(int poids,PetriNetwork Petri) {
		
		Place T1= new Place(poids);
		Petri.addPlace(T1);
		return T1;
		
	}
	// Méthode utilitaire pour créer un nouveau arc, l'ajouter au réseau et le retourner. Prend en paramètres les détails de l'arc.
    
	public static Arc arcCree(int poids, Transition transition, Place place,boolean entrsortie, boolean isVideurOrZero,PetriNetwork Petri) {
		Arc arc= new Arc( poids,transition, place, isVideurOrZero);
		Petri.addArc(transition, place, poids, entrsortie, isVideurOrZero);
		
		return arc;
		
		
	}
	 // Méthode utilitaire pour créer un ArcVideur, l'ajouter au réseau et le retourner.
    
	public static Arc arcVCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcVideur(transition,place ,true);
		Petri.addArcVideur(transition, place);
		
		return arc;
		
	}
	// Méthode utilitaire pour créer un ArcZero, l'ajouter au réseau et le retourner.
    
	public static Arc arcZCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcZero(transition,place ,true);
		Petri.addArcZero(transition, place);
		
		return arc;
		
	}

}
