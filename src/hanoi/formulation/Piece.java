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
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Piece) {
			Piece pieceAux = (Piece)obj;
			return (this.size == pieceAux.size);
		} else {
			return false;
		}
	}
	
	public Piece clone(){
		return new Piece(this.size);
	}
	
	public static void main(String[]arg){
		Piece[]pieces= new Piece[5];
		for(int i=0; i<5; i++){
			pieces[i] = new Piece(i+1);			
		}		
		for(int i=0; i<5; i++){
			System.out.println("Piece "+pieces[i].getSize());			
		}
		if(pieces[1].equals(pieces[1]))
			System.out.println("It is OK, they are the same.");
		else
			System.out.println("It is WRONG, they are the same.");
		if(pieces[1].equals(pieces[2]))
			System.out.println("It is WRONG, they are different.");
		else
			System.out.println("It is OK, they are different.");
		System.out.println("ncPiece: "+pieces[4].getSize());
		pieces[4]=pieces[2].clone();
		System.out.println("cPiece: "+pieces[4].getSize());
		if(pieces[4].equals(pieces[2]))
			System.out.println("It is OK, it is a clone.");
		else
			System.out.println("It is WRONG, it is a clone.");
		
	}
}
