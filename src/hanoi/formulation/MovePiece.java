package hanoi.formulation;
import es.deusto.ingenieria.is.search.formulation.State;

public class MovePiece {
	
	private Piece piece;
	private Stick stick;
	
	public MovePiece(Piece piece, Stick stick) {
		this.piece = piece;
		this.stick = stick;
	}
	
	protected boolean isApplicable(State state) {
		HanoiEnvironment currentEnv = (HanoiEnvironment)state;
		if (true) {
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
