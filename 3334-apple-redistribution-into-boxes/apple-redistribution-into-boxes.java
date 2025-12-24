class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int i:apple){
            sum+=i;
        }
        Arrays.sort(capacity);
        int count=0;
        for(int i=capacity.length-1;i>=0;i--){
            if(sum>0){
                count++;
                sum-=capacity[i];
            }
        }
        return count;
    }
}