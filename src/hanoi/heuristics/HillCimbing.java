package hanoi.heuristics;

import java.util.ArrayList;
import java.util.Collections;
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
	public Node search(Problem problem, State initialState) {
		List<Node> frontier = new ArrayList<Node>();
		List<State> generatedStates = new ArrayList<State>();
		List<State> expandedStates = new ArrayList<State>();
		Node firstNode = null;
		List<Node> successorNodes = null;
		boolean solutionFound = false;	
		frontier.add(new Node(initialState));
		while (!solutionFound && !frontier.isEmpty()) {			
			firstNode = frontier.remove(0);			
			if (problem.isFinalState(firstNode.getState())) {
				solutionFound = true;			
			} else {
				successorNodes = this.expand(firstNode, problem, generatedStates, expandedStates);
				if (successorNodes != null && !successorNodes.isEmpty()) {
					frontier.addAll(successorNodes);
					Collections.sort(frontier);
				}
			}
		}
		if (solutionFound) {
			return firstNode;
		} else {
			return null;
		}
	}
	
	protected List<Node> expand(Node node, Problem problem, List<State> generatedStates, List<State> expandedStates){
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode=null;
		State currentState=null;
		State successorState=null;
		if(node!=null && problem!=null){
			currentState=node.getState();
			generatedStates.remove(currentState);
			expandedStates.add(currentState);
			if(currentState!=null){
				for(Operator operator : problem.getOperators()){
					successorState = operator.apply(currentState);
					if (successorState != null) {
						if (!generatedStates.contains(successorState) && !expandedStates.contains(successorState)) {
							if(this.getEvaluationFunction().calculateH(new Node(successorState))>this.getEvaluationFunction().calculateH(new Node(currentState))){
								successorNode = new Node(successorState);
								successorNode.setOperator(operator.getName());
								successorNode.setParent(node);
								successorNode.setDepth(node.getDepth() + 1);
								successorNode.setH(this.getEvaluationFunction().calculateH(successorNode));
								successorNodes.add(successorNode);
								generatedStates.add(successorState);								
							}else
								break;
						}
					}
				}
			}
		}
		return successorNodes;
	}
}
