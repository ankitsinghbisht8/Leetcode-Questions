class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        int n = arr.length;
        int j=0;
        for (int i = 0; i < n; i++) {
            st.add(arr[i]);
            // System.out.println(sortedarr[i]);
            // System.out.println(arr[i]);
            // map.containsKey()
        }
        int sortedarr[] = new int[st.size()];
        for (int num : st) {
            sortedarr[j++] = num;
        }
        Arrays.sort(sortedarr);
        for (int i = 0; i < sortedarr.length; i++) {
            map.put(sortedarr[i], i + 1);
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}