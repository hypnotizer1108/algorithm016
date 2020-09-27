## 递归

函数自己调自己，写递归程序时，必须关注递归终止条件，否则会导致栈溢出。

#### 泛型递归代码模板

```java
public void recursion(int level, int param) {
	// 1.recurion terminator
	if (level > MAX_LEVEL) {
	// 2.process result
		return;
	}
	// 3.process current logic
	process(level + 1, param);
	// 4.reverse state of current level
}
```
## 分治

将复杂的大问题分解成若干小的子问题并一一解决，最终达到解决复杂问题的目的。

#### 分治代码模板（python）
```python
def devide_conquer(problem, param1, param2,...) {
#recursion terminator
if problem is None:
 print result
#prepare data
data = prepare_data(problem)
subproblems = split_problem(problem, data)
#conquer subproblems
subresult1 = self.devide_conquer(subproblems[0], p1,...)
subresult2 = self.devide_conquer(subproblems[0], p2,...)
subresult3 = self.devide_conquer(subproblems[0], p3,...)
...
# process and generate the final rsult
result = process_result(subresult1,subresult2,subresult3,...)
# revert the current level states
}
```

分治与递归本质上都是找重复子问题，不同之处在于分治要将各个子问题的结果进行合并。
比如juc包下的fork/join框架就体现了分治思想。

## 回溯

采用试错的思想，穷举出所有可能的结果，再判断检查结果是否有效。

## 剪枝

最坏情况下，回溯会导致一次复杂度为指数级的计算，通过剪枝来提前去掉一定不正确的分支来实现优化。
例如，[22.生成括号](https://leetcode-cn.com/problems/generate-parentheses/)问题中通过判断左括号和右括号的数量关系来决定是否可以添加，而非生成全部可能的结果后再逐一检查。