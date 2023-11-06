
public class Place {
	private int nbre_jetons;

	public Place(int nbre_jetons) {
		this.nbre_jetons = Math.abs(nbre_jetons);
	}
	public int getNbreJetons() {
		return nbre_jetons;
		
	}
	public void setNbreJetons(int Jetons){
		this.nbre_jetons=Jetons;
		
	}
	public void rmNbreJetons(int rm) {
		this.nbre_jetons-=rm;;
		
	}

}
