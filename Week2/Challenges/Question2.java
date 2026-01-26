/*
Question 2
3412. Find Mirror Score of a String
Problem Statement: You are given a string s.
We define the mirror of a letter in the English alphabet as its corresponding letter when the
alphabet is reversed. For example, the mirror of &#39;a&#39; is &#39;z&#39;, and the mirror of &#39;y&#39; is &#39;b&#39;.
Initially, all characters in the string s are unmarked.
You start with a score of 0, and you perform the following process on the string s:
Iterate through the string from left to right.
At each index i, find the closest unmarked index j such that j &lt; i and s[j] is the mirror of s[i].
Then, mark both indices i and j, and add the value i - j to the total score.
If no such index j exists for the index i, move on to the next index without making any changes.
Return the total score at the end of the process.

Example 1:
Input: s = &quot;aczzx&quot;
Output: 5
Explanation:
i = 0. There is no index j that satisfies the conditions, so we skip.
i = 1. There is no index j that satisfies the conditions, so we skip.
i = 2. The closest index j that satisfies the conditions is j = 0, so we mark both indices 0 and 2,
and then add 2 - 0 = 2 to the score.
i = 3. There is no index j that satisfies the conditions, so we skip.
i = 4. The closest index j that satisfies the conditions is j = 1, so we mark both indices 1 and 4,
and then add 4 - 1 = 3 to the score.
Example 2:

Input: s = &quot;abcdef&quot;
Output: 0
Explanation:
For each index i, there is no index j that satisfies the conditions.

Constraints:
1 &lt;= s.length &lt;= 10^5
s consists only of lowercase English letters.
*/

class Solution {
    public long calculateScore(String s) {
        Map<Character,Stack<Integer>> hm= new HashMap<>();
        int n = s.length();
        long score = 0;
        for(int i =0;i<n;i++){
            char c=s.charAt(i);
            char nex = (char)('a'+('z'-c));
            if(hm.containsKey(nex) && !hm.get(nex).isEmpty()){
                int j =hm.get(nex).pop();
                score+=(i-j); 
            }else{
                hm.putIfAbsent(c,new Stack<>());
                hm.get(c).push(i);
            }
        }
        return score;
    }

}
