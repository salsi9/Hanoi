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
			if(this.location!=auxStick.location || this.pieces.size()!=auxStick.pieces.size())
				return false;
			else if(this.location==auxStick.location && this.pieces.size()==auxStick.pieces.size()){
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
		String result="\n"+"Stick "+this.getLocation()+": ";
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
	
	public static void main(String[]arg){
		Stick[]sticks = new Stick[5];
		for(int i=0; i<5; i++){
			sticks[i] = new Stick(i+1);			
		}		
		for(int i=0; i<5; i++){
			System.out.println(sticks[i].toString());			
		}
		for(int i=5; i>0; i--){
			sticks[0].addPiece(new Piece(i));			
		}
		for(int i=0; i<5; i++){
			System.out.println(sticks[i].toString());			
		}
		List<Piece>pieces = new ArrayList<Piece>();
		pieces.add(new Piece(4));
		pieces.add(new Piece(3));
		pieces.add(new Piece(2));
		pieces.add(new Piece(1));
		sticks[2].setPieces(pieces);
		System.out.println(sticks[2].getNPieces());
		System.out.println(sticks[2].getFPiece().getSize());
		sticks[2].removeFPiece();
		System.out.println(sticks[2].getFPiece().getSize());
		if(sticks[1].equals(sticks[1]))
			System.out.println("It is OK, they are the same.");
		else
			System.out.println("It is WRONG, they are the same.");
		if(sticks[1].equals(sticks[2]))
			System.out.println("It is WRONG, they are different.");
		else
			System.out.println("It is OK, they are different.");
		System.out.println("ncStick: "+sticks[4].toString());
		sticks[4]=sticks[2].clone();
		System.out.println("cStick: "+sticks[4].toString());
		if(sticks[4].equals(sticks[2]))
			System.out.println("It is OK, it is a clone.");
		else
			System.out.println("It is WRONG, it is a clone.");
	}
}
