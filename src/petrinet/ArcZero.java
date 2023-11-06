/**
 * 
 */
package petrinet;

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
		return this.getPlace().getNbreJetons()==0;
	}
	
	public void fire() {
		
	}
}
