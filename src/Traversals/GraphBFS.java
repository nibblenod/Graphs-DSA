package Traversals;

import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        int n = 7;

        int[][] edges = {
                {5, 2},
                {5, 0},
                {2, 6},
                {0, 3},
                {3, 1},
                {6, 4}
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bfs(adj, n, 5);
    }

    static void bfs(List<List<Integer>> adj, int n, int start) {
        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> visited = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            visited.add(0);
        }
        visited.set(start,1);
        ArrayList<Integer> answer = new ArrayList<>();

        q.add(start);
        while (!q.isEmpty())
        {
            int queueHead = q.peek();
            answer.add(q.remove());

            for (int neighbour: adj.get(queueHead))
            {
                if (visited.get(neighbour) != 1)
                {
                    visited.set(neighbour, 1);
                    q.add(neighbour);
                }
            }
        }

        for (int ans: answer)
        {
            System.out.print(ans + " ");
        }

    }
}
