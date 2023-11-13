/**
 * 
 */
package petrinet;

//Classe ArcZero, une sous-classe de Arc, représentant un type spécial d'arc dans un réseau de Petri.
//Cet arc est uniquement actif lorsque la place associée ne contient aucun jeton.

public class ArcZero extends Arc{

	// Constructeur de la classe ArcZero. Initialise l'ArcZero avec une transition, une place et un marqueur isVideurOrZero.
	// isVideurOrZero est utilisé pour indiquer que cet arc est un arc spécial (bien que le nom puisse ne pas être entièrement descriptif pour ArcZero).

	public ArcZero(Transition transition, Place place, boolean isVideurOrZero) {
		super(transition, place, isVideurOrZero);
	}
	// Méthode isActive surchargée pour vérifier si l'arc est actif.
	// Un ArcZero est actif uniquement si le nombre de jetons dans la place associée est égal à zéro.

	public boolean isActive() {
		return this.getPlace().getTokenNbre()==0;
	}
	// Note: La méthode fire() n'est pas surchargée ici, car le comportement par défaut d'Arc est suffisant.
	// ArcZero ne modifie pas le nombre de jetons dans la place lorsqu'il est activé.

}
