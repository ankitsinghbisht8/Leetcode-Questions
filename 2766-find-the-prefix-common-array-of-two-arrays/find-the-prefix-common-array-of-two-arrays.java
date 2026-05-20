class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int[] arr = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (++arr[A[i]] == 2) max++;
            if (++arr[B[i]] == 2) max++;
            result[i] = max;
        }
        
        return result;
    }
}