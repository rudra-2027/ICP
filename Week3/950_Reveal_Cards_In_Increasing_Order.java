// First Approach 
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> dq = new LinkedList<>();
        int[] res = new int[n];
        for(int i =0;i<n;i++){
            dq.add(i);
        }
        for(int i =0;i<n;i++){
            int c =deck[i];
            int idx= dq.poll();
            res[idx]= c;
            if(!dq.isEmpty()){
                dq.add(dq.poll());
            }
        }
        return res;
    }
}
