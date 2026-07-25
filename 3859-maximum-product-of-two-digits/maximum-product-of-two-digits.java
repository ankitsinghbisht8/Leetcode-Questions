class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            al.add(rem);
        }
        Collections.sort(al);
        return al.get(al.size() - 1) * al.get(al.size() - 2);
    }
}