class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        if (words[startIndex].equals(target)) {
            return 0;
        }
        int moves = 0;
        for (int i = 1; i < n; i++) {
            moves++;
            if (words[(startIndex + i) % n].equals(target)) {
                return moves;
            }
            if (words[(startIndex - i + n) % n].equals(target)) {
                return moves;
            }
        }
        return -1;
    }
}