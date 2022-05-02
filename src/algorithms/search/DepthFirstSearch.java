package algorithms.search;

import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {


    @Override
    public Solution solve(ISearchable Search) {
        Search.resetAState();
        Stack<AState> stateStack = new Stack<>();
        stateStack.push(Search.getFirst());
        while (!stateStack.isEmpty()) {
            AState temp = stateStack.pop();
            temp.setVisited(true);
            for (AState neighbor : Search.getAllPossibleStates(temp)) {
                this.NumberOfNodesEvaluated++;
                if (!neighbor.isVisited()) {
                    neighbor.setPrev(temp);
                    stateStack.push(neighbor);
                }
            }
        }

        return reconstructionPath(Search.getTarget());

    }


    @Override
    public String getName() {
        return "DepthFirstSearch";
    }
}
