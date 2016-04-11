package hanoi.formulation;
public class Piece {

	private int size;
	
	public Piece(int size){
		this.size=size;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setSize(int size){
		this.size=size;
	}
	
	public Piece clone(){
		return new Piece(this.size);
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Piece) {
			Piece pieceAux = (Piece)obj;
			return (this.size == pieceAux.size);
		} else {
			return false;
		}
	}
}
