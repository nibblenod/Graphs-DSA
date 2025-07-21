import java.util.*;
public class Find_If_Path_Exists_In_Graph {
    public static boolean DFS(int source, List<List<Integer>> adjList, List<Boolean> visited, int destination)
    {
        visited.set(source, true);
        if (source == destination) return true;

        for (int neighbor: adjList.get(source))
        {
            if (!visited.get(neighbor))
            {
                if (DFS(neighbor, adjList, visited, destination)) return true;
            }

        }
        return false;
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);

        }

        List<Boolean> visited = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            visited.add(false);
        }

        return DFS(source, adjList, visited, destination);

    }

    public static void main(String[] args)
    {
        int n = 6;
        int[][] edges = {{0,1},{1,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(n, edges, 0, 5));
    }
}
