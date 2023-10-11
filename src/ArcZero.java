/**
 * 
 */

/**
 * 
 */
public class ArcZero extends Arc{

	/**
	 * 
	 */
	public ArcZero(Transition transition, Place place, boolean isVideurOrZero) {
		super(transition, place, isVideurOrZero);
	}
	
	public boolean isActive() {
		return true;
	}
	
	public void fire() {
		
	}
}
