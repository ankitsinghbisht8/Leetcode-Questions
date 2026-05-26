class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        int n = word.length();
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(word.charAt(i));
        }
        for (char ch : st) {
            if (Character.isLowerCase(ch)) {
                if (st.contains(Character.toUpperCase(ch))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}