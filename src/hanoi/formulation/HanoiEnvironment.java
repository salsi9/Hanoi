package hanoi.formulation;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiEnvironment extends State{

	private List<Stick> sticks;
	private int nPieces;
	
	public HanoiEnvironment(int nStick, int nPiece){
		this.sticks = new ArrayList<Stick>();
		this.nPieces=nPiece;
		for(int i=1; i<=nStick;i++){
			this.sticks.add(new Stick(i));
		}
		for(int i=nPiece; i>0;i--){
			this.sticks.get(0).addPiece(new Piece(i));
		}
	}
	
	public List<Stick> getSticks() {
		return this.sticks;
	}
	
	public int getNPieces(){
		return this.nPieces;
	}
	
	public List<Piece> getPieces(Stick stick){
		return stick.getPieces();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof HanoiEnvironment) {
			List<Stick> auxSticks = ((HanoiEnvironment)obj).getSticks();
			for (int i=0; i<this.sticks.size(); i++) {
				if (!this.sticks.get(i).equals(auxSticks.get(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void movePiece(int stick1, int stick2) {
		this.sticks.get(stick2).addPiece(this.sticks.get(stick1).getFPiece());
		this.sticks.get(stick1).removeFPiece();
	}
	
	public String toString() {
		String result = "Hanoi \n";
		for(int i=0; i<this.sticks.size(); i++){
			result=result+this.sticks.get(i).toString();
		}
		return result;
	}
	
	/*public HanoiEnvironment clone() {
		HanoiEnvironment newEnv = new HanoiEnvironment(this.sticks.size(),this.nPieces);		
		for(Stick stick : this.sticks) {
			newEnv.getSticks().add(stick.clone());
		}		
		return newEnv;
	}*/
	
	public static void main(String[]arg){
		HanoiEnvironment[]he = new HanoiEnvironment[5];
		for(int i=0; i<5; i++){
			he[i] = new HanoiEnvironment(i+3,i+3);			
		}		
		for(int i=0; i<5; i++){
			System.out.println(he[i].toString());			
		}
		he[0].movePiece(0, 1);
		he[0].movePiece(0, 2);
		he[2].movePiece(0, 1);
		he[2].movePiece(1, 2);
		he[4].movePiece(0, 5);
		for(int i=0; i<5; i++){
			System.out.println(he[i].toString());			
		}
		if(he[1].equals(he[1]))
			System.out.println("It is OK, they are the same.");
		else
			System.out.println("It is WRONG, they are the same.");
		if(he[1].equals(he[2]))
			System.out.println("It is WRONG, they are different.");
		else
			System.out.println("It is OK, they are different.");
	}
}
