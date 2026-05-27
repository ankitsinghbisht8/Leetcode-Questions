class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // last occurance of small letter
            if (Character.isLowerCase(ch)) {
                map.put(ch, i);
            }
            // first occurance of capital letter 
            if (Character.isUpperCase(ch) && !map.containsKey(ch)) {
                map.put(ch, i);
            }
        }
        for (int i = 0; i < 26; i++) {
            char lower = (char) ('a' + i);
            char upper = (char) ('A' + i);
            if (map.containsKey(lower) && map.containsKey(upper) && map.get(lower) < map.get(upper)) {
                count++;
            }
        }
        return count;
    }
}