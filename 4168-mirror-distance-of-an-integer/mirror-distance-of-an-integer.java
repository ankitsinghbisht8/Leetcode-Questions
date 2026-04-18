class Solution {
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n)).reverse();
        String finalstr = sb.toString();
        int val = Integer.parseInt(finalstr);
        System.out.println(val);
        return Math.abs(val - n);
    }
}