package hanoi.formulation;
import java.util.ArrayList;
import java.util.List;

public class Stick {

	private List<Piece> pieces;
	private int location;
	
	public Stick(int location){
		this.location=location;
		this.pieces=new ArrayList<Piece>();
	}
	
	public List<Piece> getPieces(){
		return this.pieces;
	}
	
	public int getNPieces(){
		return this.pieces.size();
	}
	
	public Piece getFPiece(){
		if (pieces.size() == 0) {
			return new Piece(0);
		} else {
			return pieces.get(pieces.size() - 1);
		}
	}
	
	public void removeFPiece(){
		if(pieces.size() > 0)
			pieces.remove(pieces.size()-1);
	}
	
	public void addPiece(Piece piece){
		this.pieces.add(piece);
	}
	
	public int getLocation(){
		return this.location;
	}
	
	public void setPieces(List<Piece> pieces){
		this.pieces=pieces;
	}
	
	public void setLocation(int location){
		this.location=location;
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Stick) {
			Stick auxStick = (Stick)obj;
			if(this.location==auxStick.location && this.pieces.size()==auxStick.pieces.size()){
				for (int i=0; i<this.pieces.size(); i++) {
					if (!this.pieces.get(i).equals(auxStick.pieces.get(i))) {
						return false;
					}
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
			result=result+"["+this.pieces.get(i).getSize()+"]";
		}
		return result;
	}
	
	public Stick clone(){
		Stick newStick = new Stick(this.location);
		for(Piece piece : pieces){
			newStick.addPiece(piece.clone());			
		}
		return newStick;
	}
}
