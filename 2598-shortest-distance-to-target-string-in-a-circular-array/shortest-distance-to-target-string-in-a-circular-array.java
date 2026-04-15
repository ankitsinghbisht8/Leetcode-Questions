class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if (words[startIndex].equals(target)) {
            return 0;
        }
        int rightmove = 0;
        int leftmove = 0;
        for (int i = 1; i < n; i++) {
            rightmove++;
            leftmove++;
            if (words[(startIndex + i) % n].equals(target)) {
                return rightmove;
            }
            if (words[(startIndex - i + n) % n].equals(target)) {
                return leftmove;
            }
        }
        return -1;
    }
}