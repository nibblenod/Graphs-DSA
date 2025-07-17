package Traversals;
import java.util.*;

public class GraphDFS {
    private int vertices;
    private List<List<Integer>> adjList;

    public GraphDFS(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    private void dfsUtil(int node, boolean[] visited, ArrayList<Integer> answer) {

        answer.add(node);
        visited[node] = true;

        for (int neighbour: adjList.get(node))
        {
            if (!visited[neighbour])
            {
                dfsUtil(neighbour, visited, answer);
            }
        }
    }

    public void dfs(int startNode) {
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> answer = new ArrayList<>();
        dfsUtil(startNode, visited, answer);
        for (int x: answer)
        {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.dfs(0);
    }
}
