// 每次将一层的元素（node.children）放入队列，每次遍历前，队列中的节点全是同一层的，以此控制遍历每一层时从队列中取出的元素个数，遍历同一层的节点时，还需要将同一层每个节点的children放入队列，供后续遍历。
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLayer = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                currentLayer.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(currentLayer);
        }
        return result;
    }
}