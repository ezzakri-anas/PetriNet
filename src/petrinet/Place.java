package petrinet;

/**
 * Classe représentant une place dans un réseau de Petri, caractérisée par un nombre de jetons.
 */
public class Place {
    
    private int nbre_jetons;

    /**
     * Constructeur de la classe Place. Initialise la place avec un nombre de jetons donné.
     * Si le nombre de jetons est inférieur à 1, il est initialisé à 0 pour éviter les nombres négatifs.
     * @param nbre_jetons Nombre initial de jetons dans la place.
     */
    public Place(int nbre_jetons) {
        this.nbre_jetons = nbre_jetons < 1 ? 0 : nbre_jetons;
    }

    /**
     * Obtient le nombre de jetons actuellement dans la place.
     * @return Le nombre de jetons dans la place.
     */
    public int getNbreJetons() {
        return nbre_jetons;
    }

    /**
     * Définit le nombre de jetons dans la place. 
     * Si le nombre est inférieur à 1, il est fixé à 0.
     * @param Jetons Nouveau nombre de jetons pour la place.
     */
    public void setNbreJetons(int Jetons){
        this.nbre_jetons = Jetons < 1 ? 0 : Jetons;
    }

    /**
     * Réduit le nombre de jetons dans la place par une quantité spécifiée.
     * Si la quantité à retirer est supérieure au nombre de jetons existants, tous les jetons sont retirés.
     * @param rm Nombre de jetons à retirer.
     */
    public void rmNbreJetons(int rm) {
        this.nbre_jetons -= rm <= this.getNbreJetons() ? rm : this.getNbreJetons();
    }
}
