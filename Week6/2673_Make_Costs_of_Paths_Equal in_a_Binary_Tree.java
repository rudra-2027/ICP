class Solution {
    int need = 0;
    public int minIncrements(int n, int[] cost) {
        solve(1,n,cost);
        return need;
    }
    public int solve(int curr, int n, int[]cost){
        if(curr>n) return 0;
        int leftSide=solve(2*curr,n,cost);
        int rightSide=solve(2*curr+1,n,cost);
        need+=Math.abs(leftSide-rightSide);
        return Math.max(leftSide,rightSide)+cost[curr-1];

    }
}   
// /------------------------------------
    // Another approach
class Solution {
    public int minIncrements(int n, int[] cost) {
        int mov =0;
        for(int i=n/2-1;i>=0;i--){
            mov+=Math.abs(cost[2*i+1]-cost[2*i+2]);
            cost[i]+=Math.max(cost[2*i+1],cost[2*i+2]);
        }
        return mov;
    }
}
