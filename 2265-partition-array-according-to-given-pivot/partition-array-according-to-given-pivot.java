class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        int n = nums.length;
        int ans[] = new int[n];
        int countp = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                lesser.add(nums[i]);
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            } else {
                countp++;
            }
        }
        int counter = 0;
        for (int i = 0; i < lesser.size(); i++) {
            ans[counter++] = lesser.get(i);
        }
        for (int i = 1; i <= countp; i++) {
            ans[counter++] = pivot;
        }
        for (int i = 0; i < greater.size(); i++) {
            ans[counter++] = greater.get(i);
        }
        return ans;
    }
}