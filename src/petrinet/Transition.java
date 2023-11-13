package petrinet;

import java.util.LinkedList;

/**
 * Classe représentant une transition dans un réseau de Petri, contenant des arcs entrants et sortants.
 */
public class Transition {
    private LinkedList<Arc> arcsEntrants;
    private LinkedList<Arc> arcsSortants;

    /**
     * Constructeur de la classe Transition. Initialise la transition avec des listes d'arcs entrants et sortants.
     * @param arcsEntrants Liste des arcs entrants.
     * @param arcsSortants Liste des arcs sortants.
     */
    public Transition(LinkedList<Arc> arcsEntrants, LinkedList<Arc> arcsSortants) {
        this.arcsEntrants = arcsEntrants;
        this.arcsSortants = arcsSortants;
    }

    /**
     * Retourne la liste des arcs entrants de cette transition.
     * @return Liste des arcs entrants.
     */
    public LinkedList<Arc> getArcsEntrants() {
        return this.arcsEntrants;
    }

    /**
     * Définit la liste des arcs entrants pour cette transition.
     * @param arcsEntrants Liste des arcs entrants à définir.
     */
    public void setArcsEntrants(LinkedList<Arc> arcsEntrants) {
        this.arcsEntrants = arcsEntrants;
    }

    /**
     * Retourne la liste des arcs sortants de cette transition.
     * @return Liste des arcs sortants.
     */
    public LinkedList<Arc> getArcsSortants() {
        return this.arcsSortants;
    }

    /**
     * Définit la liste des arcs sortants pour cette transition.
     * @param arcsSortants Liste des arcs sortants à définir.
     */
    public void setArcsSortants(LinkedList<Arc> arcsSortants) {
        this.arcsSortants = arcsSortants;
    }

    /**
     * Ajoute un arc entrant à la liste des arcs entrants de cette transition.
     * @param arc Arc à ajouter à la liste des entrants.
     */
	public void addArcEntrant(Arc arc) {
		LinkedList<Arc> arcs = this.getArcsEntrants();
		arcs.add(arc);
		this.setArcsEntrants(arcs);// à tester si on peut ajouter un arc sans le setter
	}
	/**
     * Ajoute un arc sortant à la liste des arcs sortants de cette transition.
     * @param arc Arc à ajouter à la liste des sortants.
     */
	public void addArcsortant(Arc arc) {
		LinkedList<Arc> arcs = this.getArcsSortants();
		arcs.add(arc);
		this.setArcsSortants(arcs);// à tester si on peut ajouter un arc sans le setter
	}
	/**
     * Supprime un arc spécifique des listes d'arcs entrants ou sortants, selon sa présence.
     * Lève une exception si l'arc n'est trouvé ni dans les arcs entrants ni dans les arcs sortants.
     * @param arc Arc à supprimer.
     * @throws Exception Si l'arc n'est pas trouvé.
     */
	public void rmArc(Arc arc) throws Exception {
		LinkedList<Arc> sortants = this.getArcsSortants();
		LinkedList<Arc> entrants = this.getArcsEntrants();

		if (sortants.contains(arc)) {
			sortants.remove(arc);
			this.setArcsSortants(sortants);
		} else if (entrants.contains(arc)) {
			entrants.remove(arc);
			this.setArcsEntrants(entrants);
		} else {
			throw new Exception("Number must be non-negative");
		}
	}

}
