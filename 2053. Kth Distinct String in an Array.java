// Approach 1: Brute Force

  class Solution {

    public String kthDistinct(String[] arr, int k) {
        int n = arr.length;
        List<String> distinctStrings = new ArrayList<>();

        // Iterate through each string in the array
        for (int i = 0; i < n; i++) {
            String currentString = arr[i];
            boolean isDistinct = true;

            // Check if the current string is distinct
            for (int j = 0; j < n; j++) {
                if (j == i) continue; // Skip comparing with itself
                if (arr[j].equals(currentString)) {
                    isDistinct = false;
                    break;
                }
            }

            // If the string is distinct, add it to the list
            if (isDistinct) {
                distinctStrings.add(currentString);
            }
        }

        // Check if there are enough distinct strings
        if (distinctStrings.size() < k) {
            return "";
        }

        return distinctStrings.get(k - 1);
    }
}

// Approach 2: Hash Set

  class Solution {

    public String kthDistinct(String[] arr, int k) {
        Set<String> distinctStrings = new HashSet<>();
        Set<String> duplicateStrings = new HashSet<>();

        // First pass: Identify distinct and duplicate strings
        for (String str : arr) {
            // If the string is already in duplicateStrings, skip further processing
            if (duplicateStrings.contains(str)) {
                continue;
            }
            // If the string is in distinctStrings, it means we have seen it before,
            // so move it to duplicateStrings
            if (distinctStrings.contains(str)) {
                distinctStrings.remove(str);
                duplicateStrings.add(str);
            } else {
                distinctStrings.add(str);
            }
        }

        // Second pass: Find the k-th distinct string
        for (String str : arr) {
            if (!duplicateStrings.contains(str)) {
                // Decrement k for each distinct string encountered
                k--;
            }
            // When k reaches 0, we have found the k-th distinct string
            if (k == 0) {
                return str;
            }
        }

        return "";
    }
}

// Approach 3: Hash Map

  class Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // First pass: Populate the frequency map
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Second pass: Find the k-th distinct string
        for (String str : arr) {
            // Check if the current string is distinct
            if (frequencyMap.get(str) == 1) {
                k--;
            }
            // When k reaches 0, we have found the k-th distinct string
            if (k == 0) {
                return str;
            }
        }

        return "";
    }
}
