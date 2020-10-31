class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return res;
    }

    private void generate(int left, int right, int max, String tmp) {
        if (left == max && right == max) {
            res.add(tmp);
            return;
        }
		// 剪枝
        if (left < max) {
            generate(left + 1, right, max, tmp + "(");
        }
        if (right < left) {
            generate(left, right + 1, max, tmp + ")");
        }
    }
}