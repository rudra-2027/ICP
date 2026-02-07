class Solution {
    public int totalSteps(int[] nums) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.push(new int[]{nums[0],0});
        int ans =0;
        for(int i = 1;i<nums.length;i++){
            int a = nums[i];
            int cnt= 0;
            while(!dq.isEmpty() && dq.peek()[0]<=a){
                cnt = Math.max(cnt,dq.peek()[1]);
                dq.pop();
            }
            if(!dq.isEmpty()){
                cnt++;
            }else{
                cnt =0;
            }
            ans =Math.max(cnt,ans);
            dq.push(new int[]{a,cnt});
        }   
        return ans;
    }
}
