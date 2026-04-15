class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        // if (words[startIndex].equals(target)) {
        //     return 0;
        // }
        // int moves = 0;
        for (int i = 0; i < n/2+1; i++) {
            // moves++;
            if (words[(startIndex + i) % n].equals(target)) {
                return i;
            }
            if (words[(startIndex - i + n) % n].equals(target)) {
                return i;
            }
            // if (((startIndex + i) % n) == ((startIndex - i + n) % n) ||
            //         ((startIndex + i) % n) == ((startIndex - i + n) % n) + 1) {
            //     return -1;
            // }
        }
        return -1;
    }
}