class Solution {
     public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tmp = new int[1001];
        int[] res = new int[arr1.length];
        for (int i:arr1) {
            tmp[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            while (tmp[i] > 0) {
                res[index++] = i;
                tmp[i]--;
            }
        }
        for (int i = 0; i < 1001; i++){
            while (tmp[i] > 0) {
                res[index++]=i;
                tmp[i]--;
            }
        }
        return res;
    }
}