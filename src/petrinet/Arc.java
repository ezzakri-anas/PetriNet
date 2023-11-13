package petrinet;

/**
 * Classe représentant un arc dans un réseau de Petri, liant une place à une transition.
 */
public class Arc {
    private int poids;
    private Place place;
    private Transition transition;
    private boolean isVideurOrZero;

    /**
     * Constructeur principal de la classe Arc. Initialise l'arc avec un poids spécifié, une place, une transition et un marqueur pour indiquer s'il s'agit d'un arc spécial.
     * @param poids Poids de l'arc.
     * @param transition Transition associée à l'arc.
     * @param place Place associée à l'arc.
     * @param isVideurOrZero Booléen indiquant si l'arc est un arc spécial (Videur ou Zero).
     */
    public Arc(int poids, Transition transition, Place place, boolean isVideurOrZero) {
        this.poids = Math.max(poids, 1);
        this.place = place;
        this.transition = transition;
        this.isVideurOrZero = isVideurOrZero;
    }

    /**
     * Constructeur surchargé pour créer un arc avec un poids par défaut de 1.
     * @param transition Transition associée à l'arc.
     * @param place Place associée à l'arc.
     * @param isVideurOrZero Booléen indiquant si l'arc est un arc spécial (Videur ou Zero).
     */
	public Arc(Transition transition, Place place, boolean isVideurOrZero) {
		this.poids = 1;
		this.place = place;
		this.transition = transition;
		this.isVideurOrZero = isVideurOrZero;
	}
	
	/**
     * Retourne le poids de cet arc.
     * @return Le poids de l'arc.
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Définit le poids de cet arc. Si la valeur donnée est inférieure à 1, le poids est fixé à 1.
     * @param poids Nouveau poids de l'arc.
     */
    public void setPoids(int poids) {
        this.poids = Math.max(poids, 1);
    }

    /**
     * Retourne la place associée à cet arc.
     * @return La place associée.
     */
    public Place getPlace() {
        return this.place;
    }

    /**
     * Définit la place associée à cet arc.
     * @param place Nouvelle place à associer à l'arc.
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * Retourne la transition associée à cet arc.
     * @return La transition associée.
     */
    public Transition getTransition() {
        return this.transition;
    }

    /**
     * Définit la transition associée à cet arc.
     * @param transition Nouvelle transition à associer à l'arc.
     */
    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    /**
     * Retourne un booléen indiquant si cet arc est un arc spécial (Videur ou Zero).
     * @return Booléen indiquant si l'arc est un arc spécial.
     */
    public boolean isVideurOrZero() {
        return this.isVideurOrZero;
    }

    /**
     * Définit si cet arc est un arc spécial (Videur ou Zero).
     * @param isVideurOrZero Booléen pour définir si l'arc est un arc spécial.
     */
    
	public void setVideurOrZero(boolean isVideurOrZero) {
		this.isVideurOrZero = isVideurOrZero;
	}
	/**
     * Ajoute des jetons à la place associée à cet arc, selon le poids de l'arc.
     */
    public void addJetons() {
        place.setNbreJetons(place.getNbreJetons() + poids);
    }

    /**
     * Retire des jetons de la place associée à cet arc, selon le poids de l'arc.
     */
    public void removeJetons() {
        place.rmNbreJetons(poids);
    }

    /**
     * Vérifie si l'arc est actif, c'est-à-dire si la place associée a suffisamment de jetons selon le poids de l'arc.
     * @return True si l'arc est actif, sinon false.
     */
	public boolean isActive() {
		Place p = this.getPlace();
		return p.getNbreJetons() >= this.getPoids();
	}
	/*
	 *  Méthode pour effectuer l'action de l'arc (à définir dans les sous-classes).
	 */
    
	public void fire() {}
	

}
