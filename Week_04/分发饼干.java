// 贪心算法：优先用最小的饼干去满足胃口最小的小朋友
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {// 饼干可以满足，这块饼干分配出去
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}