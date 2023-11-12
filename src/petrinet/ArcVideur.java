/**
 * 
 */
package petrinet;

//Classe ArcVideur, sous-classe de Arc, représentant un type spécial d'arc dans un réseau de Petri. 
//Ce type d'arc vide entièrement la place de ses jetons lorsqu'il est activé.

public class ArcVideur extends Arc{

	// Constructeur de la classe ArcVideur. Initialise l'ArcVideur avec une transition et une place.
    // Le paramètre isVideurOrZero est utilisé pour indiquer que cet arc est un arc spécial.
    
	public ArcVideur(Transition transition, Place place, boolean isVideurOrZero) {
		super(transition, place, isVideurOrZero);
	}
	// Méthode isActive surchargée pour retourner toujours vrai. 
    // Cela indique que l'ArcVideur est toujours actif, quel que soit le nombre de jetons dans la place.
    
	public boolean isActive() {
		return true;
	}
	// Méthode fire surchargée pour vider entièrement la place de ses jetons lorsque l'arc est activé.
    
	public void fire() {
		Place p = this.getPlace();
		p.setNbreJetons(0);
	}
	
}
