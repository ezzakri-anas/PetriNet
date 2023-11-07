/**
 * 
 */
package petrinet;

/**
 * 
 */
public class Arc {
	private int poids;
	private Place place;
	private Transition transition;
	private boolean isVideurOrZero;
	
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
	
	public Arc(Transition transition, Place place, boolean isVideurOrZero) {
		this.poids = 1;
		this.place = place;
		this.transition = transition;
		this.isVideurOrZero = isVideurOrZero;
	}
	
	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids >= 1 ? poids : 1;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return this.place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * @return the transition
	 */
	public Transition getTransition() {
		return this.transition;
	}

	/**
	 * @param transition the transition to set
	 */
	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	/**
	 * @return the isVideurOrZero
	 */
	public boolean isVideurOrZero() {
		return this.isVideurOrZero;
	}

	/**
	 * @param isVideurOrZero the isVideurOrZero to set
	 */
	public void setVideurOrZero(boolean isVideurOrZero) {
		this.isVideurOrZero = isVideurOrZero;
	}

	public void addJetons() {
		Place p = this.getPlace();
		int pds = this.getPoids();
		p.setNbreJetons(p.getNbreJetons() + pds);
	}
	
	public void removeJetons() {
		Place p = this.getPlace();
		int pds = this.getPoids();
		p.rmNbreJetons(pds);
	}
	
	public boolean isActive() {
		Place p = this.getPlace();
		return p.getNbreJetons() >= this.getPoids();
	}

	public void fire() {}
	
	public boolean equals(Arc arc) {
		if((this.place.equals(arc.place))&&(this.transition.equals(arc.place))&&(this.poids==arc.poids)) {
			return true;
					
		}
		return false;
		
	}
}
