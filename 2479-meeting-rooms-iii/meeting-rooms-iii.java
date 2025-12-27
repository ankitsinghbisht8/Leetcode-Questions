class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomavailable = new long[n];
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long minroomavailable = Long.MAX_VALUE;
            int minAvailableTimeRoom = 0;
            boolean foundUnusedRoom = false;

            for (int i = 0; i < n; i++) {
                if (roomavailable[i] <= start) {
                    foundUnusedRoom = true;
                    count[i]++;
                    roomavailable[i] = end;
                    break;
                }

                if (minroomavailable > roomavailable[i]) {
                    minroomavailable = roomavailable[i];
                    minAvailableTimeRoom = i;
                }
            }

            if (!foundUnusedRoom) {
                roomavailable[minAvailableTimeRoom] += end - start;
                count[minAvailableTimeRoom]++;
            }
        }

        int maxcount = 0, maxcountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxcount) {
                maxcount = count[i];
                maxcountRoom = i;
            }
        }

        return maxcountRoom;
    }
}