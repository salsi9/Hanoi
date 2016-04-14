package hanoi.formulation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiProblem extends Problem{

	private int nSticks;
	private int nPieces;
	private int fStick;
	
	public HanoiProblem(int nSticks, int nPieces, int fStick) {
		this.nSticks=nSticks;
		this.nPieces=nPieces;
		this.fStick=fStick;
		this.createOperators();
	}
	
	protected void createOperators() {
		for (int i = 0; i < this.nSticks; i++) {
			for (int j = 0; j < this.nSticks; j++) {
				if (i != j) {
					this.addOperator(new MovePiece(i, j));
				}
			}
		}
	}
	
	public State gatherInitialPercepts() {
		return new HanoiEnvironment(nSticks, nPieces);
	}

	public boolean isFinalState(State state) {
		if (state != null && state instanceof HanoiEnvironment) {
			HanoiEnvironment hannoiEnv = (HanoiEnvironment) state;
			if (hannoiEnv.getSticks().get(this.fStick).getPieces().size() == nPieces)
				return true;
		}
		return false;
	}
	
	public void solve(SearchMethod searchMethod) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.S");
		Date beginDate = GregorianCalendar.getInstance().getTime();
		System.out.println(
				"\n* Start '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(beginDate) + ")");

		Node finalNode = searchMethod.search(this, this.getInitialStates().get(0));

		Date endDate = GregorianCalendar.getInstance().getTime();
		System.out.println(
				"* End   '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(endDate) + ")");

		long miliseconds = (int) Math.abs(beginDate.getTime() - endDate.getTime());
		long seconds = miliseconds / 1000;
		miliseconds %= 1000;
		long minutes = seconds / 60;
		seconds %= 60;
		long hours = minutes / 60;
		minutes %= 60;

		String time = "\n* Serach lasts: ";
		time += (hours > 0) ? hours + " h " : " ";
		time += (minutes > 0) ? minutes + " m " : " ";
		time += (seconds > 0) ? seconds + "s " : " ";
		time += (miliseconds > 0) ? miliseconds + "ms " : " ";

		System.out.println(time);

		if (finalNode != null) {
			System.out.println("\n- Solution found!     :)");
			List<String> operators = new ArrayList<String>();
			searchMethod.solutionPath(finalNode, operators);
			searchMethod.createSolutionLog(operators);
			System.out.println("- Number of movements: " + finalNode.getDepth());
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
	}
	
	public static void main(String[] args) {
		HanoiProblem hp1 = new HanoiProblem(3, 3, 2);
		HanoiProblem hp2 = new HanoiProblem(3, 3, 0);
		HanoiEnvironment he = (HanoiEnvironment)hp1.gatherInitialPercepts();
		System.out.println(he.toString());
		if(hp1.isFinalState(he))
			System.out.println("False, is not final state.");
		else
			System.out.println("OK, is not final state.");
		if(hp2.isFinalState(he))
			System.out.println("OK, is final state.");
		else
			System.out.println("False, is fina state.");
	}
}
