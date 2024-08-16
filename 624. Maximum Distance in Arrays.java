class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int size=arrays.size();
        int maxdistance=0;
        int minVal=arrays.get(0).get(0);
        int maxVal=arrays.get(0).get(arrays.get(0).size()-1);

        for(int i=1;i<size;i++){
            int currMin=arrays.get(i).get(0);
            int currMax=arrays.get(i).get(arrays.get(i).size()-1);

            maxdistance=Math.max(maxdistance,Math.abs(currMax-minVal));
            maxdistance=Math.max(maxdistance,Math.abs(maxVal-currMin));

            minVal=Math.min(minVal,currMin);
            maxVal=Math.max(maxVal,currMax);
        }
        return maxdistance;
       


    }
}
