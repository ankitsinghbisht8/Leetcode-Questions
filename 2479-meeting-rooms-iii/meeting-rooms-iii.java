class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int i = 0; i < n; i++) free.offer(i);

        for (int[] m : meetings) {
            long s = m[0], d = m[1] - m[0];

            while (!busy.isEmpty() && busy.peek()[0] <= s) {
                free.offer((int) busy.poll()[1]);
            }

            if (!free.isEmpty()) {
                int r = free.poll();
                busy.offer(new long[]{m[1], r});
                count[r]++;
            } else {
                long[] x = busy.poll();
                busy.offer(new long[]{x[0] + d, x[1]});
                count[(int) x[1]]++;
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}