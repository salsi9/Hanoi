package hanoi.heuristics;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.heuristic.HeuristicSearchMethod;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HillCimbing extends HeuristicSearchMethod{

	public HillCimbing(EvaluationFunction arg0) {
		super(arg0);
	}

	@Override
	public Node search(Problem arg0, State arg1) {
		Node node = new Node(arg1);
		
		return node;
	}
}
