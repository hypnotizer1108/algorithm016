// 1.dp：时间复杂度O(n) 空间复杂度O(1)
class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int total = first + second;
            first = second;
            second = total;
        }
        return second;
    }
}

// 2.记忆化递归，map做缓存：时间复杂度O(n) 空间复杂度O(n)
class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
	
    public int climbStairs(int n) {
        if (n < 3) return n;
        if (cache.containsKey(n)) return cache.get(n);
        int val = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, val);
        return val;
    }
}