/* The functions which
builds the segment tree */
class GfG {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        // Add your code here
        st = new int[4*n];
        build(0,n-1,arr,0);
        return st;
    }
    public static void build(int l, int r, int[]arr, int i){
        if(l==r) {
            st[i] = arr[l];
            return;
        }
        int mid = l+(r-l)/2;
        build(l,mid,arr,2*i+1);
        build(mid+1,r,arr,2*i+2);
        st[i]=Math.min(st[2*i+1],st[2*i+2]);
    }
    public static int RMQ(int st[], int n, int l, int r) {
        // Add your code here
        if(l<0 || r>n-1 || l>r){
            return -1;
        }
        return Query(st,n,0,0,n-1,l,r);
    }
    public static int Query(int[] sg, int n,int st,int i,int end, int l ,int r){
        if(l>end || r<st ){
            return Integer.MAX_VALUE;
        }
        if(l<=st && r>=end){
            return sg[i];
        }
        int mid = st+(end-st)/2;
        return Math.min(Query(sg,n,st,2*i+1,mid,l,r),Query(sg,n,mid+1,2*i+2,end,l,r));
    }
}
