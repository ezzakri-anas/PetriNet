package petrinet;

public class Place {
	private int nbre_jetons;

	public Place(int nbre_jetons) {
		this.nbre_jetons = nbre_jetons < 1 ? 0 : nbre_jetons;
	}
	public int getNbreJetons() {
		return nbre_jetons;
		
	}
	public void setNbreJetons(int Jetons){
		this.nbre_jetons = Jetons < 1 ? 0 : Jetons;
		
	}
	public void rmNbreJetons(int rm) {
		this.nbre_jetons -= rm <= this.getNbreJetons() ? rm : this.getNbreJetons();
		
	}
	

}
