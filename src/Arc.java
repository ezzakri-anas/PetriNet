/**
 * 
 */

/**
 * 
 */
public class Arc {
	private int poids;
	private Place place;
	private Transition transition;
	private boolean isVideurOrZero;
	
	public Arc(int poids, Transition transition, Place place, boolean isVideurOrZero) {
		this.poids = poids;
		this.place = place;
		this.transition = transition;
		this.isVideurOrZero = isVideurOrZero;
	}
}
