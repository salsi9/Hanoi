package hanoi;
import java.util.Scanner;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;
import hanoi.formulation.HanoiEnvironment;
import hanoi.formulation.HanoiProblem;
import hanoi.heuristics.HillCimbing;
import hanoi.heuristics.Leftys2EvaluationFunction;
import hanoi.heuristics.LeftysEvaluationFunction;
import hanoi.heuristics.SearchEvaluationFunction;

public class Ejecutable {

	public static void main(String[]arg){
		Scanner in=new Scanner(System.in);
		int nStick, nPiece, fTower;
		System.out.println("How many towers: ");
		nStick=in.nextInt();
		System.out.println("How many pieces: ");
		nPiece=in.nextInt();
		System.out.println("Which is the final tower: ");
		fTower=(in.nextInt()-1);
		HanoiProblem problem = new HanoiProblem(nStick, nPiece, fTower);
		HanoiEnvironment environment = (HanoiEnvironment) problem.gatherInitialPercepts();
		problem.addInitialState(environment);
		System.out.println(environment.toString());		
		problem.solve(DepthFS.getInstance());
		problem.solve(BreadthFS.getInstance());
		//problem.solve(new BestFS(new SearchEvaluationFunction()));
		System.out.println("\nTAKING INTO ACOUNT ONLY THE LEFT STICK");
		problem.solve(new BestFS(new LeftysEvaluationFunction()));
		System.out.println("\nTAKING INTO ACOUNT THE LEFT AND CENTRE STICKS");
		problem.solve(new BestFS(new Leftys2EvaluationFunction()));
		System.out.println("\nHILL CLIMBING METHOD WITH LEFT STICK");
		problem.solve(new HillCimbing(new LeftysEvaluationFunction()));
		System.out.println("\nHILL CLIMBING METHOD WITH LEFT AND CENTRE STICKS");
		problem.solve(new HillCimbing(new Leftys2EvaluationFunction()));
	}
}
