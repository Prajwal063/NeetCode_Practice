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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
        
    }
    
    private int height(TreeNode root){
        
        if(root == null){                                   //base condition
            return 0;
        }
        
        int left = height(root.left);                       //calling left child node using recursion
        int right = height(root.right);                     //calling left child node using recursion
        
        if(left == -1 || right == -1){                      //if there is NO left or right node, return -1
            return -1;
        }
        if(left - right < -1 || left - right > 1){          //if diff btw left and right node <-1 or >1, return -1
            return -1;
        }
        return Math.max(left, right) + 1;                   //else return height
    }
}