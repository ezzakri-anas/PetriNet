/**
 * 
 */
package petrinet;

import java.util.LinkedList;
/**
 * 
 */
public class Transition {
	private LinkedList<Arc> arcsEntrants;
	private LinkedList<Arc> arcsSortants;
	/**
	 * 
	 */
	public Transition(LinkedList<Arc> arcsEntrants, LinkedList<Arc> arcsSortants) {
		this.arcsEntrants = arcsEntrants;
		this.arcsSortants = arcsSortants;
}
	/**
	 * @return the arcsEntrants
	 */
	public LinkedList<Arc> getArcsEntrants() {
		return this.arcsEntrants;
	}
	/**
	 * @param arcsEntrants the arcsEntrants to set
	 */
	public void setArcsEntrants(LinkedList<Arc> arcsEntrants) {
		this.arcsEntrants = arcsEntrants;
	}
	/**
	 * @return the arcsSortants
	 */
	public LinkedList<Arc> getArcsSortants() {
		return this.arcsSortants;
	}
	/**
	 * @param arcsSortants the arcsSortants to set
	 */
	public void setArcsSortants(LinkedList<Arc> arcsSortants) {
		this.arcsSortants = arcsSortants;
	}
	
	public void addArcEntrant(Arc arc) {
		LinkedList<Arc> arcs = this.getArcsEntrants();
		arcs.add(arc);
		this.setArcsEntrants(arcs);// à tester si on peut ajouter un arc sans le setter
	}
	
	public void addArcsortant(Arc arc) {
		LinkedList<Arc> arcs = this.getArcsSortants();
		arcs.add(arc);
		this.setArcsSortants(arcs);// à tester si on peut ajouter un arc sans le setter
	}
	
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
