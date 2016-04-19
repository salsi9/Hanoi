package hanoi.heuristics;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import hanoi.formulation.HanoiEnvironment;

public class LeftysEvaluationFunction extends EvaluationFunction{

	@Override
	public double calculateG(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateH(Node arg0) {
		HanoiEnvironment he = (HanoiEnvironment) arg0.getState();		
		return he.leftNPiece();
	}

}
