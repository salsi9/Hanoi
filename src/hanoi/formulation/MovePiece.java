package hanoi.formulation;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class MovePiece extends Operator{
	
	private int piece;
	private int stick;
	
	//borrame
	
	public MovePiece(int piece, int stick) {
		this.piece = piece;
		this.stick = stick;
	}
	
	protected boolean isApplicable(State state) {
		HanoiEnvironment currentEnv = (HanoiEnvironment)state;
		if (currentEnv.getSticks().get(stick).getPieces().get(piece).getSice()<this.piece) {
			HanoiEnvironment newEnv = currentEnv.clone();	
			newEnv.movePiece(piece, stick);
			return true;
		} else {
			return false;
		}
	}	
	
	protected State effect(State state) {		
		HanoiEnvironment newEnv = (HanoiEnvironment) ((HanoiEnvironment)state).clone();		
		newEnv.movePiece(8, 9);
		
		return newEnv;
	}
}
