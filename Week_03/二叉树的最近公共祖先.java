/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//1.root为null，说明已经找到最后一层仍未找到结果，则公共祖先为null。p为root则最近公共祖先是p，q为root则最近公共祖先是q
/*2.若步骤1未找到最近公共祖先，则在root节点的左右子树中分别查找pq的最近公共祖先left和right，分以下三种情况：
a.若left和right都不为null，说明pq分别位于root的左子树和右子树，则最近公共祖先就是root
b.left为null，right非null说明两个都位于右子树，right即为最近公共祖先
c.left非null，right为null说明两个都位于左子树，left即为最近公共祖先.*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}