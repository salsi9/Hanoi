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
	
	public static void main(String[] args) {
		MovePiece mp1 = new MovePiece(0, 1);
		MovePiece mp2 = new MovePiece(1, 2);
		MovePiece mp3 = new MovePiece(1, 0);
		MovePiece mp4 = new MovePiece(0, 2);
		HanoiEnvironment he = new HanoiEnvironment(3,3);
		System.out.println(he.toString());
		if(mp1.isApplicable(he)){
			System.out.println("OK, it is posible");
			he=(HanoiEnvironment)mp1.effect(he);
			System.out.println(he.toString());
		}
		else
			System.out.println("False, it is posible");
		if(mp2.isApplicable(he)){
			System.out.println("OK, it is posible");
			he=(HanoiEnvironment)mp2.effect(he);
			System.out.println(he.toString());
		}
		else
			System.out.println("False, it is posible");
		if(mp3.isApplicable(he))
			System.out.println("False, it is not posible");
		else{
			System.out.println("OK, it is not posible");
		}
		if(mp4.isApplicable(he))
			System.out.println("False, it is not posible");
		else{
			System.out.println("OK, it is not posible");
		}
	}
}
