/**
 * 
 */
package petrinet;

//Classe représentant un arc dans un réseau de Petri, liant une place à une transition.

public class Arc {
	// Attributs pour stocker le poids de l'arc, la place et la transition associées, et si l'arc est de type spécial (Videur ou Zero).
    
	private int poids;
	private Place place;
	private Transition transition;
	private boolean isVideurOrZero;
	// Constructeur principal de la classe Arc. Initialise l'arc avec un poids spécifié, une place, une transition et un marqueur pour indiquer s'il s'agit d'un arc spécial.
    
	public Arc(int poids, Transition transition, Place place, boolean isVideurOrZero) {
		if(poids < 1) {
			this.poids = 1;
		} else {
			this.poids = poids;
		}
		
		this.place = place;
		this.transition = transition;
		this.isVideurOrZero = isVideurOrZero;
	}
	// Constructeur surchargé pour créer un arc avec un poids par défaut de 1.
    
	public Arc(Transition transition, Place place, boolean isVideurOrZero) {
		this.poids = 1;
		this.place = place;
		this.transition = transition;
		this.isVideurOrZero = isVideurOrZero;
	}
	
	// Retourne le poids de cet arc.
    
	public int getPoids() {
		return poids;
	}

	// Définit le poids de cet arc. Si la valeur donnée est inférieure à 1, le poids est fixé à 1.
    
	public void setPoids(int poids) {
		this.poids = poids >= 1 ? poids : 1;
	}

	 // Retourne la place associée à cet arc.
    
	public Place getPlace() {
		return this.place;
	}

	// Définit la place associée à cet arc.
    
	public void setPlace(Place place) {
		this.place = place;
	}

	// Définit la place associée à cet arc.
    
	public Transition getTransition() {
		return this.transition;
	}

	// Définit la transition associée à cet arc.
    
	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	// Retourne un booléen indiquant si cet arc est un arc spécial (Videur ou Zero).
    
	public boolean isVideurOrZero() {
		return this.isVideurOrZero;
	}

	// Définit si cet arc est un arc spécial (Videur ou Zero).
    
	public void setVideurOrZero(boolean isVideurOrZero) {
		this.isVideurOrZero = isVideurOrZero;
	}
	// Ajoute des jetons à la place associée à cet arc, selon le poids de l'arc.
    
	public void addJetons() {
		Place p = this.getPlace();
		int pds = this.getPoids();
		p.setNbreJetons(p.getNbreJetons() + pds);
	}
	// Retire des jetons de la place associée à cet arc, selon le poids de l'arc.
    
	public void removeJetons() {
		Place p = this.getPlace();
		int pds = this.getPoids();
		p.rmNbreJetons(pds);
	}
	// Vérifie si l'arc est actif, c'est-à-dire si la place associée a suffisamment de jetons selon le poids de l'arc.
    
	public boolean isActive() {
		Place p = this.getPlace();
		return p.getNbreJetons() >= this.getPoids();
	}
	// Méthode pour effectuer l'action de l'arc (à définir dans les sous-classes).
    
	public void fire() {}
	

}
