class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            unique.add(num);
        }
        for (int num : unique) {
            int divisorsum = getfour(num);
            if (divisorsum > 0) {
                ans += divisorsum * map.get(num);
            }
        }
        return ans;
    }

    private int getfour(int num) {
        if (num <= 1)
            return 0;

        int count = 0;
        int sum = 1 + num;

        int sqrt = (int) Math.sqrt(num);

        if (sqrt * sqrt == num)
            return 0;

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                count += 2;
                sum += i + (num / i);

                if (count > 4) {
                    return 0;
                }
            }
        }
        return count == 2 ? sum : 0;
    }
}