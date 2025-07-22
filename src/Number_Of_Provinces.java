class Number_Of_Provinces {

    public static void DFS(int n, int source, boolean[] visited, int[][] isConnected)
    {
        visited[source] = true;

        for (int i = 0; i < n; i++)
        {
            if (isConnected[source][i] == 1 && !visited[i])
            {
                DFS(n, i, visited, isConnected);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int numberOfProvinces = 0;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                numberOfProvinces++;
                DFS(n, i, visited, isConnected);
            }
        }

        return numberOfProvinces;
    }

        public static void main(String[] args) {

            int[][] isConnected3 = {
                    {1, 1, 0, 0},
                    {1, 1, 0, 0},
                    {0, 0, 1, 1},
                    {0, 0, 1, 1}
            };
            System.out.println("Number of Provinces: " + findCircleNum(isConnected3));
        }
    }

