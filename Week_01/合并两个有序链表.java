// 递归解法：两个待合并节点中val小的作为头节点，然后将另一个节点和新头结点的旧next节点进行合并，所得节点作为新头结点的next节点
// 时间复杂度O(m+n)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l2.next, l1);
                return l2;
            }
        }
        return l1 != null ? l1 : l2; 
    }
}

// 尝试过的暴力解法（超时）。取出所有节点，放入一个集合，对集合中的所有节点按val从小到大排序，然后从头开始遍历整个集合，将每一个节点的next指向下一个节点
class Solution {
    List<ListNode> nodes = new ArrayList<>();
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        nodes.addAll(getAllNodes(l1));
        nodes.addAll(getAllNodes(l2));
        nodes.sort((n1, n2) -> n1.val - n2.val);
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }

        return nodes.get(0);
    }

    private List<ListNode> getAllNodes(ListNode l1) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode tmp = l1;
        while (tmp != null) {
            nodes.add(l1);
            tmp = l1.next;
        }
        return nodes;
    }
}