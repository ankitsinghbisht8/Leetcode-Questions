// Approach 1: Sorting

class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) return false;
        }
        return true;
    }
}

// Approach 2 : Mapping

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int m = arr.length;

        if (n != m) return false;

        int[] map = new int[1001];

        for (int i = 0; i < n; i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            if (map[target[i]] != 0 || map[arr[i]] != 0) {
                return false;
            }
        }

        return true;
    }
}

// Approach 3: Frequency Counting With 1 Dictionary

class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        // Frequency count for arr
        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.put(num, arrFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : target) {
            // If num does not appear in target, then arrays are not equal
            if (!arrFreq.containsKey(num)) return false;

            // Decrement the frequency count for num and
            // remove key if the count goes to 0
            arrFreq.put(num, arrFreq.get(num) - 1);
            if (arrFreq.get(num) == 0) {
                arrFreq.remove(num);
            }
        }
        return arrFreq.size() == 0;
    }
}
