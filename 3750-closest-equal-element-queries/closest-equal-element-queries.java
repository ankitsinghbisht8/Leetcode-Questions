class Solution {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (ArrayList<Integer> al : map.values()) {
            int x = al.get(0);
            int last = al.get(al.size() - 1);
            al.add(0, last - n);
            al.add(x + n);
        }
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int x = nums[q];
            ArrayList<Integer> positions = map.get(x);

            if (positions.size() == 3) {
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(positions, q);
            // if (idx < 0) idx = -idx - 1;

            int dist = Math.min(
                positions.get(idx + 1) - positions.get(idx),
                positions.get(idx) - positions.get(idx - 1)
            );
            result.add(dist);
        }
        return result;
    }
}