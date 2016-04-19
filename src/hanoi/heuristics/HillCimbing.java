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

	protected List<Node> expand(Node node, Problem problem, List<State> generatedStates, List<State> expandedStates) {
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode = null;
		State currentState = null;
		State successorState = null;		
		//If the current node and problem aren't null
		if (node != null && problem != null) {
			//Make the current state the state kept in the node.
			currentState = node.getState();
			//Remove current state from the list of generated states.
			generatedStates.remove(currentState);
			//Insert current state to the list of generated states.
			expandedStates.add(currentState);			
			//If current state is not null
			if (currentState != null) {
				//process the list of problem operators
				for (Operator operator : problem.getOperators()) {
					//Apply the operator to the current state
					successorState = operator.apply(currentState);
					//If the operator was applicable, a new successor state was generated
					if (successorState != null) {
						//If the new node hadn't been generated before nor expanded
						if (!generatedStates.contains(successorState) && !expandedStates.contains(successorState)) {
							//make a new node to keep the new successor state
							successorNode = new Node(successorState);
							//Set values for the various node's attributes
							successorNode.setOperator(operator.getName());
							successorNode.setParent(node);
							successorNode.setDepth(node.getDepth() + 1);
							//evaluation function = heuristic function
							successorNode.setH(this.getEvaluationFunction().calculateH(successorNode));
							//Add the new node to the list of successor nodes.
							successorNodes.add(successorNode);
							//Insert current successor State to the list of generated states
							generatedStates.add(successorState);
						}
					}
				}
			}
		}		
		return successorNodes;
	}
}
