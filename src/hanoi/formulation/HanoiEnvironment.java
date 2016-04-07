package hanoi.formulation;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiEnvironment extends State{

	private List<Stick> sticks;
	private List<Piece> pieces;
	
	public HanoiEnvironment(int nStick, int nPiece){
		for(int i=1;i<=nPiece;i++){
			this.pieces.add(new Piece(i, 1));
		}
		this.sticks.add(new Stick(nPiece,1));
		for(int i=2; i<=nStick;i++){
			this.sticks.add(new Stick(0,i));
		}
	}
	
	public List<Stick> getSticks() {
		return this.sticks;
	}
	
	public List<Piece> getPieces(){
		return this.pieces;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof HanoiEnvironment) {
			List<Stick> auxSticks = ((HanoiEnvironment)obj).getSticks();
			List<Piece> auxPieces = ((HanoiEnvironment)obj).getPieces();
			for (int i=0; i<this.sticks.size(); i++) {
				if (!this.sticks.get(i).equals(auxSticks.get(i))) {
					return false;
				}
			}
			for (int i=0; i<this.pieces.size(); i++) {
				if (!this.pieces.get(i).equals(auxPieces.get(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void movePiece(int piece, int stick) {
		if (piece>0 && piece<=this.pieces.size() && stick>0 && stick<=this.sticks.size()) {
			for(int i=0;i<this.sticks.size();i++){
				for(int j=0;j<this.sticks.get(i).getPieces().size();j++){
					if(this.pieces.get(j).getSice()==piece){
						this.sticks.get(i).getPieces().get(j).setLocatio(stick);
						this.sticks.get(stick).getPieces().add(this.pieces.get(j));
						this.sticks.get(i).getPieces().remove(j);
					}
				}
			}
		}
	}
	
	public HanoiEnvironment clone() {
		HanoiEnvironment newEnv = new HanoiEnvironment(this.sticks.size(),this.pieces.size());		
		for(int i=1; i<=this.pieces.size(); i++) {
			newEnv.movePiece(i, 1);
		}		
		return newEnv;
	}
	
	@Override
	public String toString() {
		String result = "Hanoi \n";
		for(int i=0; i<this.sticks.size(); i++){
			result=result+"\n Stick "+i+": "+this.sticks.get(i).toString();
		}
		return result;
	}

}
