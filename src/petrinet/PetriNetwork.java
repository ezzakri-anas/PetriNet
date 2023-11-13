package petrinet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Classe principale représentant un réseau de Petri, contenant des places, transitions et arcs.
 */
public class PetriNetwork {
    private LinkedList<Arc> liste_des_arcs;
    private LinkedList<Transition> liste_des_transitions;
    private LinkedList<Place> liste_des_places;
    
    /**
     * Constructeur de la classe PetriNetwork. Initialise les listes pour les arcs, transitions et places.
     */
    public PetriNetwork() {
        this.liste_des_arcs= new LinkedList<Arc>();
        this.liste_des_transitions= new LinkedList<Transition>();
        this.liste_des_places=new LinkedList<Place>();
    }
    
    /**
     * Définit la liste des transitions dans le réseau.
     * @param Transitions Liste des transitions à définir.
     */
    public void setTransitionList(LinkedList<Transition> Transitions) {
        this.liste_des_transitions=Transitions;
    }

    /**
     * Obtient la liste actuelle des transitions dans le réseau.
     * @return La liste des transitions.
     */
    public LinkedList<Transition> getTransitionList(){
        return this.liste_des_transitions;
    }

    /**
     * Définit la liste des places dans le réseau.
     * @param Places Liste des places à définir.
     */
    public void setPlaceList(LinkedList<Place> Places) {
        this.liste_des_places=Places;
    }

    /**
     * Obtient la liste actuelle des places dans le réseau.
     * @return La liste des places.
     */
    public LinkedList<Place> getPlaceList(){
        return this.liste_des_places;
    }

    /**
     * Ajoute une transition spécifique au réseau.
     * @param transition Transition à ajouter.
     */
    public void addTransition(Transition transition) {
        this.liste_des_transitions.add(transition);
    }

    /**
     * Supprime une transition spécifique du réseau.
     * @param transition Transition à supprimer.
     */
    public void rmTransition(Transition transition) {
        this.liste_des_transitions.removeIf(transitions -> transitions.equals(transition));
    }

    /**
     * Ajoute une place spécifique au réseau.
     * @param place Place à ajouter.
     */
    public void addPlace(Place place) {
        this.liste_des_places.add(place);
    }

    /**
     * Supprime une place spécifique du réseau.
     * @param place Place à supprimer.
     */
    public void rmPlace(Place place) {
        this.liste_des_places.removeIf(p -> p.equals(place));
    }

    /**
     * Ajoute un arc au réseau avec les paramètres spécifiés.
     * @param transition Transition associée à l'arc.
     * @param place Place associée à l'arc.
     * @param poids Poids de l'arc.
     * @param entrsort Booléen indiquant si l'arc est entrant ou sortant.
     * @param isZeroorVideur Booléen indiquant si l'arc est de type ArcZero ou ArcVideur.
     */
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
	/**
     * Ajoute un ArcZero au réseau, qui est un type spécial d'arc avec des règles de tirage spécifiques.
     * @param transition Transition associée à l'arc.
     * @param place Place associée à l'arc.
     */
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
	/**
     * Ajoute un ArcVideur au réseau, un type spécial d'arc qui vide entièrement la place de ses jetons lorsqu'il est tiré.
     * @param transition Transition associée à l'arc.
     * @param place Place associée à l'arc.
     */
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
	/**
     * Retourne la liste des arcs présents dans le réseau.
     * @return La liste des arcs.
     */
	public LinkedList<Arc> getArc() {
		
		return this.liste_des_arcs;
	}
	/**
     * Modifie le poids d'un arc spécifique.
     * @param arc Arc dont le poids doit être modifié.
     * @param poids Nouveau poids de l'arc.
     */
	public void changeArcValue (Arc arc, int poids) {
		arc.setPoids(poids);
		
	}
	/**
     * Définit le nombre de jetons pour une place donnée.
     * @param place Place pour laquelle modifier le nombre de jetons.
     * @param nbrejetons Nouveau nombre de jetons pour la place.
     */
	public void setPlaceJeton (Place place, int nbrejetons) {
		place.setNbreJetons(nbrejetons);
		
	}
	/**
     * Vérifie si un arc est unique dans le réseau.
     * @param arc Arc à vérifier.
     * @return Booléen indiquant si l'arc est unique.
     */
	public boolean isArcUnique (Arc arc) {
		for (Arc arc_transitions : this.liste_des_arcs) {
			if (arc_transitions.equals(arc)) {
				return false;
				
			}
		}
		return true;
		
	}
	/**
     * Exécute un pas (tirage) sur une transition donnée.
     * @param T Transition sur laquelle effectuer le pas.
     */
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
	/**
     * Exécute un pas (tirage) sur toutes les transitions du réseau.
     */
	public void PasAll() {
		for (Transition T : this.liste_des_transitions) {
			this.Pas(T);
			}
		
	}
	
	/**
     * Affiche l'état actuel du réseau de Petri, y compris les informations sur les places, transitions et arcs.
     */
	public String AfficherPetriNet() {
		
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
		
		return MessageFinal;
		
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
	
	
	/**
     * Méthode utilitaire pour créer et ajouter une nouvelle transition au réseau.
     * @param Petri Réseau de Petri auquel la transition sera ajoutée.
     * @return La transition créée et ajoutée au réseau.
     */
	public static Transition TransitionCree( PetriNetwork Petri) {
		LinkedList<Arc> arcsEntrants= new LinkedList<Arc>() ;
		LinkedList<Arc> arcsSortants= new LinkedList<Arc>() ;
		Transition T1= new Transition(arcsEntrants,arcsSortants);
		Petri.addTransition(T1);
		return T1;
		
		
	}
	/**
     * Méthode utilitaire pour créer et ajouter une nouvelle place au réseau.
     * @param poids Nombre initial de jetons dans la place.
     * @param Petri Réseau de Petri auquel la place sera ajoutée.
     * @return La place créée et ajoutée au réseau.
     */
	public static Place PlaceCree(int poids,PetriNetwork Petri) {
		
		Place T1= new Place(poids);
		Petri.addPlace(T1);
		return T1;
		
	}
	/**
     * Méthode utilitaire pour créer et ajouter un nouvel arc au réseau.
     * @param poids Poids de l'arc à créer.
     * @param transition Transition associée à l'arc.
     * @param place Place associée à l'arc.
     * @param entrsortie Booléen indiquant si l'arc est entrant ou sortant.
     * @param isVideurOrZero Booléen indiquant si l'arc est de type ArcZero ou ArcVideur.
     * @param Petri Réseau de Petri auquel l'arc sera ajouté.
     * @return L'arc créé et ajouté au réseau.
     */
	public static Arc arcCree(int poids, Transition transition, Place place,boolean entrsortie, boolean isVideurOrZero,PetriNetwork Petri) {
		Arc arc= new Arc( poids,transition, place, isVideurOrZero);
		Petri.addArc(transition, place, poids, entrsortie, isVideurOrZero);
		
		return arc;
		
		
	}
	/**
     * Méthode utilitaire pour créer et ajouter un ArcVideur au réseau.
     * @param transition Transition associée à l'ArcVideur.
     * @param place Place associée à l'ArcVideur.
     * @param Petri Réseau de Petri auquel l'ArcVideur sera ajouté.
     * @return L'ArcVideur créé et ajouté au réseau.
     */
	public static Arc arcVCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcVideur(transition,place ,true);
		Petri.addArcVideur(transition, place);
		
		return arc;
		
	}
	/**
     * Méthode utilitaire pour créer et ajouter un ArcZero au réseau.
     * @param transition Transition associée à l'ArcZero.
     * @param place Place associée à l'ArcZero.
     * @param Petri Réseau de Petri auquel l'ArcZero sera ajouté.
     * @return L'ArcZero créé et ajouté au réseau.
     */
	public static Arc arcZCree( Transition transition, Place place,PetriNetwork Petri) {
		Arc arc= new ArcZero(transition,place ,true);
		Petri.addArcZero(transition, place);
		
		return arc;
		
	}

}
