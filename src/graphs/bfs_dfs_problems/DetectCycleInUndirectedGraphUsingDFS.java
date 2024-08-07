package graphs.bfs_dfs_problems;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphUsingDFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }

    static boolean dfs(int v, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, v, vis, adj))
                    return true;
            } else if (ele != parent) {
                return true;
            }
        }
        return false;
    }
}
