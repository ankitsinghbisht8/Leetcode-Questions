class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        String duplicate = s+s;
        System.out.println(duplicate); 
        int arr[]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=i+1;j<i+n;j++){
                if(duplicate.charAt(j-1) == duplicate.charAt(j)){
                    count++;
                }
            }
            System.out.println(""); 
            arr[i]=count;
        }
        for(int a:arr){
            System.out.print(a+" ");
        }

        for(int i=0;i<n;i++){
            if(arr[i]==k){
                ans++;
            }
        }
        return ans;
    }
}