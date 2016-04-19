package hanoi.heuristics;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import hanoi.formulation.HanoiEnvironment;

public class SearchEvaluationFunction extends EvaluationFunction{

	@Override
	public double calculateG(Node arg0) {
		HanoiEnvironment he = (HanoiEnvironment) arg0.getState();		
		return he.numMovements();
	}

	@Override
	public double calculateH(Node arg0) {
		HanoiEnvironment he = (HanoiEnvironment) arg0.getState();		
		return he.numMovements();
	}

}
