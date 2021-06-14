import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph2 {
	public Node2 rootNode;
	public ArrayList nodes = new ArrayList();
	public int[][] adjMatrix;// Edges will be represented as adjacency Matrix
	int size;

	public void setRootNode(Node2 n) {
		this.rootNode = n;
	}

	public Node2 getRootNode() {
		return this.rootNode;
	}

	public void addNode(Node2 n) {
		nodes.add(n);
	}

	// This method will be called to make connect two nodes
	public void connectNode(Node2 start, Node2 end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	private Node2 getUnvisitedChildNode(Node2 n) {

		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node2) nodes.get(j)).visited == false) {
				return (Node2) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	// BFS traversal of a tree is performed by the bfs() function
	public void bfs() {

		// BFS uses Queue data structure
		Queue q = new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node2 n = (Node2) q.remove();
			Node2 child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	// DFS traversal of a tree is performed by the dfs() function
	public void dfs() {
		// DFS uses Stack data structure
		Stack s = new Stack();
		s.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while (!s.isEmpty()) {
			Node2 n = (Node2) s.peek();
			Node2 child = getUnvisitedChildNode(n);
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	// Utility methods for clearing visited property of node
	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node2 n = (Node2) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	// Utility methods for printing the node's label
	private void printNode(Node2 n) {
		System.out.print(n.label + " ");
	}

}
