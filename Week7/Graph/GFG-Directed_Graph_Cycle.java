class Solution {
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0;i<V;i++){
            al.add(new ArrayList<>());
            
        }
        for(int i[]: edges){
            int u = i[0];
            int v = i[1];
            al.get(u).add(v);
        } 
        boolean[] visited = new boolean[V+1];
        boolean[] visited2 = new boolean[V+1];
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,al,visited,visited2)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> al,boolean[] visited ,boolean[] visited2){
        visited[i] =true;
        visited2[i] =true;
        for(int x: al.get(i)){
            if(!visited[x]){
                if(dfs(x,al,visited,visited2)){
                    return true;
                }
            }else if(visited2[x]){
                return true;
            }
        }
        visited2[i] =false;
        return false;
    }
}
