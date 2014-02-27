package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}

	private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	
	private UndirectedGraphNode cloneNode(UndirectedGraphNode node) {
		if(map.containsKey(node))
			return map.get(node);
		UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
		map.put(node, ret);
		int size = node.neighbors.size();
		for(int i=0; i<size; i++) {
			ret.neighbors.add(cloneNode(node.neighbors.get(i)));
		}
		return ret;
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		map.clear();
		if(node == null)
			return null;
		return cloneNode(node);
	}
}
