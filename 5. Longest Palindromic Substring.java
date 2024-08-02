// Approach : 1

class Solution {
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        for (int i = 0; i < n - 1; i++) {
            expandAroundCenter(s, i, i); // Odd length palindromes
            expandAroundCenter(s, i, i + 1); // Even length palindromes
        }
        return s.substring(start, end + 1);

    }

    public void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > end - start) {
            start = left + 1;
            end = right - 1;
        }
    }
}

// Approach : 2

import java.util.ArrayList;

class Solution {
    public String longestPalindrome(String s) {
        // Edge case for empty string
        if (s == null || s.length() < 1) {
            return "";
        }

        String longestPalindrome = "";
        
        // Iterate through all possible substrings
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                String subStr = s.substring(i, j);
                
                // Check if the substring is a palindrome
                if(isPalindrome(subStr)){
                    // Update the longest palindrome found
                    if(subStr.length() > longestPalindrome.length()){
                        longestPalindrome = subStr;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    // Helper function to check if a string is a palindrome
    public Boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babad";
        System.out.println("Longest Palindromic Substring: " + solution.longestPalindrome(s));
    }
}
