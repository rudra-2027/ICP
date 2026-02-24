
class Solution {
    int[] segTree;
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        // code here
        segTree = new int[4*n];
        buildSeg(0,n-1,0,arr);
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<q*2;i+=2){
            int st =queries[i]-1;
            int end =queries[i+1]-1;
            res.add(Query(st,end,0,0,n-1));
        }
        return res;
        
    }
    int Query(int st, int end, int i,int l, int r){
        if(l>end|| r<st ){
            return 0;
        }
        if(l>=st && r<=end){
            return segTree[i];
        }
        int mid = l+(r-l)/2;
        return Query(st,end,2*i+1,l,mid)+Query(st,end,2*i+2,mid+1,r);
    }
    void buildSeg(int l,int r,int i,int[] arr){
        if(l==r){
            segTree[i]= arr[l];
            return;
            
        }
        int mid = l+(r-l)/2;
        buildSeg(l,mid,2*i+1,arr);
        buildSeg(mid+1,r,2*i+2,arr);
        segTree[i]= segTree[2*i+1]+segTree[2*i+2];
    }
}
