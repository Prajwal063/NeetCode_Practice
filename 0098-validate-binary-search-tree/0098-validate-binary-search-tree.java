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
    public boolean isValidBST(TreeNode root) {
        return isBinarySearchTree(root, null, null);
    }
    
    boolean isBinarySearchTree(TreeNode root, Integer min, Integer max) {	
		if(root == null)									
			return true;
        
        //Edge cases if left and right nodes are null *important*		
		if((min != null && root.val <= min) || max != null && root.val >= max)			
			return false;
		
		return 												
			isBinarySearchTree(root.left, min, root.val)	
			&& isBinarySearchTree(root.right, root.val, max);	
	}
}