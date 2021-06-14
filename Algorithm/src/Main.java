import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[] = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]); // node
		int e = Integer.parseInt(arr[1]); // edge
		String r = arr[2]; // root
		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (int i = 0; i < e; i++) {
			String arr2[] = br.readLine().split(" ");
			String a1 = arr2[0];
			String a2 = arr2[1];
			arrayList.add(a1);
			arrayList.add(a2);
		}
		
		for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (i == j) {
                } else if (arrayList.get(j).equals(arrayList.get(i))) {
                	arrayList.remove(j);
                }
            }
        }
//		 Lets create nodes as given as an example in the article		
        ArrayList<Node2> nodeList = new ArrayList<Node2>();
		for (int i = 0; i < arrayList.size(); i++) {
			String arrNodeList[] = new String[arrayList.size()];
			Node2 nd = new Node2(arrayList.get(i));
			nodeList.add(nd);
		}



//		 Create the graph, add nodes, create edges between nodes
		Graph2 g = new Graph2();
		Node2 r2 = new Node2(r);
		for (int i = 0; i < nodeList.size(); i++) {
			g.addNode(nodeList.get(i));
			g.setRootNode(r2);
		}
		
		
//		g.connectNode(nA, nB);
//		g.connectNode(nA, nC);
//		g.connectNode(nA, nD);
//
//		g.connectNode(nB, nE);
//		g.connectNode(nB, nF);
//		g.connectNode(nC, nF);

//		// Perform the traversal of the graph
//		System.out.println("DFS Traversal of a tree is ------------->");
//		g.dfs();
//
//		System.out.println("\nBFS Traversal of a tree is ------------->");
//		g.bfs();

		br.close();
	}
}
