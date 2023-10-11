/**
 * 
 */

/**
 * 
 */
public class ArcVideur extends Arc{

	/**
	 * 
	 */
	public ArcVideur(Transition transition, Place place, boolean isVideurOrZero) {
		super(transition, place, isVideurOrZero);
	}

	public boolean isActive() {
		return true;
	}
	
	public void fire() {
		Place p = this.getPlace();
		p.setNbreJetons(0);
	}
}
