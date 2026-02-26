import java.util.ArrayList;
import java.util.List;

public class Week7 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(valid(n,edges));
    }

    private static boolean valid(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> gr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            gr.add(new ArrayList<>());
        }
        for (int[] i : edges){
            int u = i[0];
            int v = i[1];
            gr.get(u).add(v);
            gr.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        dfs(gr,visited,0);
        for(boolean v: visited){
            if(!v) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> gr, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;

        for (int nei : gr.get(i)) {
            dfs(gr, visited, nei);
        }
    }
}
