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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        helper(root, result, 0);    
        return result;
    }
    
    public static void helper(TreeNode root, List<List<Integer>> result, int height){
        
        if(root == null) return;
        
        if(height>=result.size()){
            result.add(new LinkedList<Integer>());
        }
        
        result.get(height).add(root.val);
        
        helper(root.left, result, height+1);
        helper(root.right, result, height+1);
    }
}