// Dynamic Programming (Optimized)

class Solution {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;

        // Iterate through each soldier as the middle soldier
        for (int mid = 0; mid < n; mid++) {
            int leftSmaller = 0;
            int rightLarger = 0;

            // Count soldiers with smaller rating on the left side of the current soldier
            for (int left = mid - 1; left >= 0; left--) {
                if (rating[left] < rating[mid]) {
                    leftSmaller++;
                }
            }

            // Count soldiers with larger ratings on the right side of the current soldier
            for (int right = mid + 1; right < n; right++) {
                if (rating[right] > rating[mid]) {
                    rightLarger++;
                }
            }

            // Calculate and add the number of ascending rating teams (small-mid-large)
            teams += leftSmaller * rightLarger;

            // Calculate soldiers with larger ratings on the left and smaller ratings on the right
            int leftLarger = mid - leftSmaller;
            int rightSmaller = n - mid - 1 - rightLarger;

            // Calculate and add the number of descending rating teams (large-mid-small)
            teams += leftLarger * rightSmaller;
        }

        // Return the total number of valid teams
        return teams;
    }
}
