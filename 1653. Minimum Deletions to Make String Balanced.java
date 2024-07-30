Approach 1: Using stack (one pass)

  class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> charStack = new Stack<>();
        int deleteCount = 0;

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            // If stack is not empty, top of stack is 'b',
            // and current char is 'a'
            if (
                !charStack.isEmpty() &&
                charStack.peek() == 'b' &&
                s.charAt(i) == 'a'
            ) {
                charStack.pop(); // Remove 'b' from stack
                deleteCount++; // Increment deletion count
            } else {
                charStack.push(s.charAt(i)); // Push current character onto stack
            }
        }

        return deleteCount;
    }
}

Approach 2: Three-Pass Count Method TC 0(n) SC 0(2n)

  class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int[] countB = new int[n];
        int bCount = 0;

        // First pass: compute count_b which stores the number of
        // 'b' characters to the left of the current position.
        for (int i = 0; i < n; i++) {
            countB[i] = bCount;
            if (s.charAt(i) == 'b') bCount++;
        }

        int aCount = 0;
        // Second pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
        for (int i = n - 1; i >= 0; i--) {
            countA[i] = aCount;
            if (s.charAt(i) == 'a') aCount++;
        }

        int minDeletions = n;
        // Third pass: iterate through the string to find the minimum deletions
        for (int i = 0; i < n; i++) {
            minDeletions = Math.min(minDeletions, countA[i] + countB[i]);
        }

        return minDeletions;
    }
}

Approach 3: Combined Pass Method TC O(n) SC o(n)

class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int aCount = 0;

        // First pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
        for (int i = n - 1; i >= 0; i--) {
            countA[i] = aCount;
            if (s.charAt(i) == 'a') aCount++;
        }

        int minDeletions = n;
        int bCount = 0;
        // Second pass: compute minimum deletions on the fly
        for (int i = 0; i < n; i++) {
            minDeletions = Math.min(countA[i] + bCount, minDeletions);
            if (s.charAt(i) == 'b') bCount++;
        }

        return minDeletions;
    }
}

Approach 4: Two-Variable Method SC O(1) TC O(n)

  class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int aCount = 0;

        // First pass: count the number of 'a's
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') aCount++;
        }

        int bCount = 0;
        int minDeletions = n;

        // Second pass: iterate through the string to compute minimum deletions
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') aCount--;
            minDeletions = Math.min(minDeletions, aCount + bCount);
            if (s.charAt(i) == 'b') bCount++;
        }

        return minDeletions;
    }
}
