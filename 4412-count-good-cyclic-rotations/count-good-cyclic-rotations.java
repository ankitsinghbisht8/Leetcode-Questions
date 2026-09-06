class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int newarr[]= new int [n*2];
        int ans=0;
        for(int i=0;i<2*n;i++){
            newarr[i] = nums[(i%n)];
        }
        long prefixarr[]=new long[2*n];
        prefixarr[0]=nums[0];
        for(int i=1;i<2*n;i++){
            prefixarr[i]=prefixarr[i-1]+newarr[i];
        }
        for(int i=0;i<n;i++){
            long lefthalf=0;
            int middleguy = n/2+i-1;
            if(i-1>=0){
                lefthalf = prefixarr[middleguy] - prefixarr[i-1];
            }
            else{
                lefthalf =  prefixarr[n/2+i-1];
            }
            long righthalf = prefixarr[i+n-1]-prefixarr[middleguy];
            // System.out.println("firsthalf "+lefthalf+"..lasthalf.."+righthalf);
            if(lefthalf>righthalf){
                ans++;
            }
        }
        // for(int a:prefixarr){
        //     System.out.print(a+"....");
        // }
        // for(int a:newarr){
        //     System.out.print(a+"....");
        // }
        // for(int i=0;i<n;i++){
        //     int firsthalf=0;
        //     int lasthalf=0;
        //     for(int j=i;j<i+half;j++){
        //         firsthalf+=newarr[j];
        //     }
        //     for(int k=n-1+i;k>=i+half;k--){
        //         lasthalf+=newarr[k];
        //     }
            // System.out.println("firsthalf "+firsthalf+"..lasthalf.."+lasthalf);
            // if(firsthalf>lasthalf){
            //     ans++;
            // }
        
        return ans;
    }
}