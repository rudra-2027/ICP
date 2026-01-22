// Brute Force
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        long mod = 1_000_000_007;
        for(int i  = 0;i<arr.length;i++){
            for(int j = i  ;j<arr.length;j++){
                 int min = Integer.MAX_VALUE;
                for(int k = i ;k<=j;k++){
                    min = Math.min(min,arr[k]);
                }
            
            ans = (ans+min)%mod;
            }
        }
        return (int)ans;
    }
}

//Optinal Approach

class Solution {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = i+1;
            }else{
                left[i] = i-st.peek();
            }
            
            st.push(i);
        }

        st.clear();
        
        for (int i = n-1; i>=0; i--) {
            while (!st.isEmpty()&& arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n-i;
            }else{
                right[i] = st.peek() - i;
            }
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i<n; i++) {
            ans = (ans +(long)arr[i]*left[i]*right[i])%mod;
        }
        return (int) ans;
    }
}
