package hanoi.formulation;
public class Piece {

	private int sice;
	
	public Piece(int sice){
		this.sice=sice;
	}
	
	public int getSice(){
		return this.sice;
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
