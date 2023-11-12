package petrinet;

//Classe représentant une place dans un réseau de Petri, caractérisée par un nombre de jetons.

public class Place {
	// Classe représentant une place dans un réseau de Petri, caractérisée par un nombre de jetons.

	private int nbre_jetons;
	// Constructeur de la classe Place. Initialise la place avec un nombre de jetons donné.
    // Si le nombre de jetons est inférieur à 1, il est initialisé à 0 pour éviter les nombres négatifs.
    
	public Place(int nbre_jetons) {
		this.nbre_jetons = nbre_jetons < 1 ? 0 : nbre_jetons;
	}
	// Méthode pour obtenir le nombre de jetons actuellement dans la place.
    
	public int getNbreJetons() {
		return nbre_jetons;
		
	}
	// Définit le nombre de jetons dans la place. Si le nombre est inférieur à 1, il est fixé à 0.
    
	public void setNbreJetons(int Jetons){
		this.nbre_jetons = Jetons < 1 ? 0 : Jetons;
		
	}
	// Réduit le nombre de jetons dans la place par une quantité spécifiée.
    // Si la quantité à retirer est supérieure au nombre de jetons existants, tous les jetons sont retirés.
   
	public void rmNbreJetons(int rm) {
		this.nbre_jetons -= rm <= this.getNbreJetons() ? rm : this.getNbreJetons();
		
	}
	

}
