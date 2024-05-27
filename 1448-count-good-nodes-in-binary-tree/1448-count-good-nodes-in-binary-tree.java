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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    
    void helper(TreeNode root, int max){
        if(root == null)
            return;
        if(root.val >= max )    //if current node value is greater than max, then it's a good node
            count++;
        
        max = Math.max(max, root.val);  //update max
        
        helper(root.left, max);
        helper(root.right, max);
    }
}