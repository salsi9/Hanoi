package hanoi.formulation;
public class Piece {

	private int sice;
	private int location;
	
	public Piece(int sice, int location){
		this.sice=sice;
		this.location=location;
	}
	
	public int getSice(){
		return this.sice;
	}
	
	public int getLocation(){
		return this.location;
	}
	
	public void setLocatio(int location){
		this.location=location;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Piece) {
			Piece pieceAux = (Piece)obj;
			return this.sice == pieceAux.sice;
		} else {
			return false;
		}
	}
}
