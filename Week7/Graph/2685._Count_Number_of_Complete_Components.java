/*
In this question we have to find how many component are completed 
for finding this components we have given a edges[][] and n veritces
the approach is 
1. make a adjacent list
2. now do the dfs on made list and with a proof that current values for that vertices using one ArrayList name as compo 
3.  then check each value in compos size == adj.get(comp.element).size() if it is equal then true; else false  
4. if its true then it tells about the that comp is completed cnt++;
return  cnt;

*/


class Solution {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int[] i : edges){
            int u =i[0];
            int v =i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt = 0;
        visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i,comp);
                if(check(comp)){
                    cnt++;
                }
            }
        }
        System.out.println(adj);
        return cnt;
    }
    public void dfs(int i, ArrayList<Integer> comp ){
        visited[i] = true;
        comp.add(i);
        for(int x : adj.get(i)){
            if(!visited[x]){
                dfs(x,comp);
            }
        }
    }
    public boolean check(ArrayList<Integer> comp){
        int size = comp.size();
        for(int i : comp){
            if(adj.get(i).size() != size -1){
                return false;
            }
        
        }
        return true;
    }
}
