/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        help(root,cur);
        for(int i : queries){
            al.add(find(i,cur));
        }
        return al;
    }
    public List<Integer> find(int t, List<Integer> curr){
        int l =  0;
        int r =curr.size()-1;
        int min=-1;
        int max=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int value = curr.get(mid);
            if (value == t) {
                min=value;
                max=value;
                break;
            }
            else if (value<t) {
                min=value;      
                l=mid+1;
            }
            else {
                max=value;      
                r=mid-1;
            }
        }
        return Arrays.asList(min, max);
    }
    public void help(TreeNode root, List<Integer> cur){
        if(root==null){
            return;
        }
        help(root.left,cur);
        cur.add(root.val);
        help(root.right,cur);
    }
}
