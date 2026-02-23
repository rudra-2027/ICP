class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>  res = new ArrayList<>();
        boolean[] visited =new boolean[adj.size()+1];
        dfs(adj,visited,0,res);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node , ArrayList<Integer> res){
        visited[node] = true;
        res.add(node);
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(adj,visited,i,res);
            }
        }
    }
}
