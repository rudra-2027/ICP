// FROM BFS
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges){
            int u=i[0];
            int v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==dest) return true;
            for(int x : adj.get(curr)){
                if(!visited[x]){
                    visited[x] = true;
                    q.add(x);                }
            }
        }
        return false;
    }
}

//FROM DFS
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges){
            int u=i[0];
            int v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n+1];
        return dfs(src,dest,visited);

    }
    public boolean dfs(int src, int dest, boolean[] visited){
        if(src== dest){
            return true;
        }
        visited[src] =true;
        for(int i : adj.get(src)){
            if(!visited[i]){
                if(dfs(i,dest,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
