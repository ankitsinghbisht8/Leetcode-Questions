class Solution {
    public int largestAltitude(int[] gain) {
        int maxi = 0;
        int currsum = 0;
        for (int i = 0; i < gain.length; i++) {
            currsum += gain[i];
            maxi = Math.max(maxi, currsum);
        }
        return maxi;
    }
}