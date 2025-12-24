class Solution {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        Integer[] arr = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            arr[i] = capacity[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int need = 0;
        while (sum > 0) {
            sum -= arr[need];
            need += 1;
        }

        return need;
    }
}