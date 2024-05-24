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
    public List<Integer> rightSideView(TreeNode root) {
        var list = new ArrayList<Integer>();
        helper(list, root, 0);
        return list;
    }
    
    //list.size() == depth -> only when this condition is true the node is added
    /*NOTE: only 1 node is added from each level -> as the right node is traversed first -> thus when right node is         added, the list size increases by 1 and thus not equal to depth and therefore left node not added*/ 

    //For left side view, left node will be recursed first and then the right node -> same logic as above
    
    void helper(ArrayList<Integer> list, TreeNode root, int depth){
        if(root == null)
            return;
        if(list.size() == depth)
            list.add(root.val);
        if(root.right != null)
            helper(list, root.right, depth+1);
        if(root.left != null)
            helper(list, root.left, depth+1);
    }
}