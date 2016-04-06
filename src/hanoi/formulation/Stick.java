package hanoi.formulation;
import java.util.List;

public class Stick {

	private List<Piece> pieces;
	private int location;
	
	public Stick(int nPiece, int location){
		this.location=location;
		for(int i=nPiece; i>0; i--){
			this.pieces.add(new Piece(i,location));			
		}
	}
	
	public List<Piece> getPieces(){
		return this.pieces;
	}
	
	public int getLocation(){
		return this.location;
	}
	
	public void setLocatio(int location){
		this.location=location;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Stick) {
			List<Piece> auxPiece = ((Stick)obj).getPieces();
			for (int i=0; i<this.pieces.size(); i++) {
				if (!this.pieces.get(i).equals(auxPiece.get(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		String result="";
		for(int i=0; i<this.pieces.size(); i++){
			result=result+"["+this.pieces.get(i).getSice()+"]";
		}
		return result;
	}
}
