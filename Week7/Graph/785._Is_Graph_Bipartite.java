class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int  i=0;i<n;i++){
            if(color[i]==0){
                if(!bfs(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int c, int[] color){
        color[c]=1;
        Queue<Integer> q = new LinkedList<>();
        q.add(c);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int n : graph[cur]){

            if(color[n]==0){
                color[n]=-color[cur];
                q.add(n);
            }
            else if(color[n]==color[cur]){
                return false;
            }
            }
        }
        return true;
    }
}
