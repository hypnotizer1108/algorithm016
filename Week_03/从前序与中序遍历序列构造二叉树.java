/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 中序遍历序列中值和索引的映射关系
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    /**
     * 根据前序、中序遍历序列构造树
     * @param preorder 原始前序遍历序列
     * @param inorder 原始中序遍历序列
     * @param p_start 当前子序列在原始前序遍历序列中对应的起始位置
     * @param p_end 当前子序列在原始前序遍历序列中对应的结束位置
     * @param i_start 当前子序列在原始前序遍历序列中对应的起始位置
     * @param i_end 当前子序列在原始前序遍历序列中对应的结束位置
     * @return 根据前序、中序遍历序列构造出的子树S
     */
    private TreeNode buildTree(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
        // recursion terminator
        if (p_start > p_end) {
            return null;
        }
        // process current logic
        // 前序遍历的第一个节点就是根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        // 在中序遍历结果中找到根节点的位置，根节点左边的就是左子树，根节点右边的就是右子树
        int i_root_index = map.get(root_val);
        int count_left_subtree = i_root_index - i_start;
        // drill down
        // 前序遍历中从左边界+1开始到左边界（根节点+count_left_subtree个元素就对应了中序遍历中从左边界开始到根节点定位-1的元素
        root.left = buildTree(preorder, inorder, p_start + 1, p_start + count_left_subtree, i_start, i_root_index - 1);
        // 前序遍历中从左边界+左子树节点数目+1开始到右边界的元素就对应了中序遍历中从根节点定位+1到右边界的元素
        root.right = buildTree(preorder, inorder, p_start + count_left_subtree + 1, p_end, i_root_index + 1, i_end);
        // reverse state: do nothing
        return root;
    }
}