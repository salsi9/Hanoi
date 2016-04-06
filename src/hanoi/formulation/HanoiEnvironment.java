package hanoi.formulation;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiEnvironment extends State{

	private int cantPieces;
	private List<Stick> sticks;
	private List<Piece> pieces;
	
	public HanoiEnvironment(int nStick, int nPiece){
		this.cantPieces=nPiece;
		this.sticks.add(new Stick(nPiece,1));
		for(int i=2; i<=nStick;i++){
			this.sticks.add(new Stick(0,i));
		}
	}
	
	public List<Stick> getSticks() {
		return this.sticks;
	}
	
	public int getCantPieces(){
		return this.cantPieces;
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

	public void movePiece(int piece, int stick) {
		if (piece>0 && piece<=this.cantPieces && stick>0 && stick<=this.sticks.size()) {
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
		HanoiEnvironment newEnv = new HanoiEnvironment(this.sticks.size(),this.getCantPieces());		
		for(int i=1; i<=this.getCantPieces(); i++) {
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
