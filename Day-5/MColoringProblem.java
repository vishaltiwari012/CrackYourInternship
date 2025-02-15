

class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        Arrays.fill(color, -1);
        return solve(graph, m, n, color, 0);
    }
    
    public static boolean solve(boolean graph[][], int m, int n, int[] color, int node) {
        if(node == n) return true;
        
        for(int i = 1; i <= m; i++) {
            if(isSafe(graph, n, color, node, i)) {
                color[node] = i;
                if(solve(graph, m, n, color, node + 1)) return true;
                color[node] = -1;
            }
        }
        return false;
    }
    
    public static boolean isSafe(boolean[][] graph, int n, int[] color, int node, int i) {
        for(int j = 0; j < n; j++) {
            if(graph[node][j] == true && color[j] == i) {
                return false;
            }
        }
        return true;
    }
}