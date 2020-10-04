## 一、DFS和BFS

DFS通常用栈来实现，BFS通常用队列来实现。

二叉树的前中后序遍历为DFS，二叉树或N叉树的层序遍历为BFS。

#### 1.DFS代码模板

```java
   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```
#### 2.BFS代码模板

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```
## 二、贪心算法

#### 1、定义

在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法

**需要注意的是：实际上，并非每一步都选择当前最优解就一定能得到全局最优解，所以需要关注贪心算法的适用场景**

#### 2、特点

|   算法|特点   |
| ------------ | ------------ |
|   贪心|   当下做局部最优判断|
|   回溯|   能够回退|
|   动态规划|   最优判断 + 回退|

#### 3、适用场景

**问题能够分解成子问题来解决，子问题的最优解能够递推到最终问题的最优解。这种子问题最优解称为最优子结构。**

正例：
[兑换硬币](https://www.mdeditor.com/)问题中，特殊场景下，假设硬币为[1,5, 10, 20]，由于硬币之间存在整除关系，所以优先使用大面值的硬币就可以得到最优解。比如25，25 % 20 = 1,（25 - 20）% 10 = 0， （25 - 20） % 5 = 1，所以用一个20和一个5即为最优解。

反例：
非整除关系的硬币，可选硬币为[10, 9, 1]，求拼18，很显然最优解为9 + 9，这时如果先用10，则需要再用8个1。

## 三、二分查找

#### 1.前提

1. 目标函数单调递增或者单调递减
2. 存在上下界
3. 能够通过索引访问

#### 2.代码模板

```Java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```
