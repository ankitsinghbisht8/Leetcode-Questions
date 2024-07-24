class Solution {
    public String longestCommonPrefix(String[] strs) {

        Method - 1
        Arrays.sort(strs);
        StringBuilder result= new StringBuilder();
      
        char[] first=strs[0].toCharArray();
        char[] last=strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i]!=last[i]){
                break;
            }
            else{
                result.append(first[i]);
            }
            
        }
        return result.toString();
    }
}


      Method - 2

        class Solution {
    public String longestCommonPrefix(String[] strs) {

       int idx = 0;
       Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];

        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
            }
      }
