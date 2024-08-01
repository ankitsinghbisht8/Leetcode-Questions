class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int ans[]=new int [m+n];
        for(int i=0;i<n;i++){
            ans[i]=nums1[i];
        }
        for(int i=0;i<m;i++){
            ans[n+i]=nums2[i];
        }
        Arrays.sort(ans);

        int len=ans.length;
        if(len%2==1){
            return (float)ans[len/2];

        }
        else{
            return (float)(ans[len/2-1] + ans[len/2])/2;
        }

        
    }
}
