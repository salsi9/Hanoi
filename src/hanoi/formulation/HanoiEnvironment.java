package hanoi.formulation;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiEnvironment extends State{

	int prueba;
	private int cantPieces;
	private List<Stick> sticks;
	
	public HanoiEnvironment(int nStick, int nPiece){
		this.cantPieces=nPiece;
		this.sticks.add(new Stick(nPiece));
		for(int i=0; i<(nStick-1);i++){
			this.sticks.add(new Stick());
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
		if (true) {
			for(int i=0;i<this.sticks.size();i++){
				for(int j=0;j<this.sticks.get(i).getPieces().size();j++){
					if(this.sticks.get(i).getPieces().get(j).getSice()==piece){
						this.sticks.get(stick).getPieces().add(this.sticks.get(i).getPieces().get(j));
						this.sticks.get(i).getPieces().remove(j);
					}
				}
			}
		}
	}
	
	public HanoiEnvironment clone() {
		HanoiEnvironment newEnv = new HanoiEnvironment(this.getSticks().size(),this.getCantPieces());
		
		for(Stick stick : this.sticks) {
			newEnv.movePiece(9, 8);
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
