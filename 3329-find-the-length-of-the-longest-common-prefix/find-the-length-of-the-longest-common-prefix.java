class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        int maxilen = 0;
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            st.add(num);
            while (num != 0) {
                num = num / 10;
                st.add(num);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            while (arr2[i]!= 0) {
                if (st.contains(arr2[i])) {
                    int len = String.valueOf(arr2[i]).length();
                    maxilen = Math.max(maxilen, len);
                    break;
                }
                arr2[i] = arr2[i] / 10;
            }
        }
        return maxilen;
    }
}