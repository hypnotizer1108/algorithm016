### 学习总结
**一、学习方法非常重要！**
- 切记不要死磕！最多15分钟没有思路立即看题解。
- 最大的误区是刷题只刷一遍！严格按照五毒神掌，反复练习过遍数。

**二、常见数据结构时间复杂度**

|  操作 | LinkedList  | ArrayList  |
| :------------ | :------------ | :------------ |
| prepend  | O(1)  | O(1)  |
| append  |  O(1) |  O(1) |
| lookup  | O(n)  |  O(1) |
| insert  | O(1）  |  O(n) |
| delete  | O(1)  |  O(n) |

**三、优化时间复杂度的核心思想**
- 升维
- 空间换时间

以跳表为例，普通链表随机访问元素的时间复杂度为O(n)，跳表在链表基础上增加了多级索引，将查询的时间复杂度降低到了O(log n)。

**四、常用解题技巧**
数组：双指针
链表：迭代和递归，循环链表可用双指针求解。

**五、面试资料**
值得收藏：https://github.com/CyC2018/CS-Notes