/*
Question2:(Easy Greedy)
Problem Statement: You are a caregiver at a community center organizing a treat
distribution event for children. Each child has a specific preference for cookie size, reflecting
how much of a treat they need to feel satisfied. These preferences are described as a "greed
factor" — the minimum cookie size a child will accept to be content. You have a collection of
cookies in various sizes, and you want to distribute them as fairly and efficiently as possible.
However, there’s a constraint: each child can receive at most one cookie, and each cookie
can be given to only one child.
Your objective is to maximize the number of content children, meaning you want to assign
cookies such that as many children as possible receive a cookie that meets or exceeds their
minimum requirement.
Write a function that takes two lists as input:

 g — a list of greed factors for each child
 s — a list of available cookie sizes
Return the maximum number of children who can be content after the distribution. This
assessment tests your ability to think algorithmically, work with greedy strategies, and
implement efficient solutions to real-world allocation problems.

Example 1:
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the
child whose greed factor is 1 content.
You need to output 1.

Example 2:
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children,
You need to output 2.

Constraints:
1 <= g.length <= 3 * 10^4
0 <= s.length <= 3 * 10^4
1 <= g[i], s[j] <= 2^31 - 1

Input0:
1 2 4 5
1 2 3
Output0:
2

Input1:

1 2 4 5
1 2 4
Output1:
3

Input2:
2 5 7
2 3 5 7
Output2:
3

Input3:
2 5 7 8 1
2 3
Output3:
2

Input4:
1 1 1 2
1 2
Output4:
2
*/

import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(maxCandies(g,s));
    }
    public static  int maxCandies(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length &&j<s.length){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}
