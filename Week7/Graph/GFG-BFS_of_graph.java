class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()+1];
        q.add(0);
        visited[0]= true;
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int x: adj.get(curr)){
                if(!visited[x])
                {
                    visited[x]=true;
                    q.add(x);
                }
            }
            
        }
        return res;
    }
}
