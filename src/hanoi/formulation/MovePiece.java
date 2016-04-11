package hanoi.formulation;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class MovePiece extends Operator{
	
	private int stick1;
	private int stick2;
	
	public MovePiece(int stick1, int stick2) {
		this.stick1 = stick1;
		this.stick2 = stick2;
	}
	
	protected boolean isApplicable(State state) {
		HanoiEnvironment currentEnv = (HanoiEnvironment)state;
		if (currentEnv.getSticks().get(this.stick1).getPieces().size() !=0) {
			if (currentEnv.getSticks().get(this.stick2).getPieces().size() !=0){
				if(currentEnv.getSticks().get(this.stick1).getFPiece().getSize()>currentEnv.getSticks().get(this.stick2).getFPiece().getSize())
					return false;
			}
			return true;
		} else {
			return false;
		}
	}	
	
	protected State effect(State state) {		
		HanoiEnvironment newEnv = ((HanoiEnvironment)state).clone();		
		newEnv.movePiece(this.stick1, this.stick2);		
		return newEnv;
	}
}
