//Using DFS
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i =0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int [][] arr, boolean[] visited, int i){
        visited[i] =true;
        for(int j =0;j<arr.length;j++){
            if(arr[i][j]==1 && !visited[j]){
                dfs(arr,visited,j);
            }
        }
    }
}
