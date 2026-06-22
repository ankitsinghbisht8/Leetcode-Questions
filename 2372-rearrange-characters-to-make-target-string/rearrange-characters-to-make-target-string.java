class Solution {
    public int rearrangeCharacters(String s, String target) {
        if(target.length()>s.length()) return 0;
        int ans =Integer.MAX_VALUE;
        Map<Character,Integer> need=new HashMap<>();
        Map<Character,Integer> have=new HashMap<>();
        for(char c: s.toCharArray()){
            have.put(c,have.getOrDefault(c,0)+1);
        }
        for(char c: target.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        for(char c: need.keySet()){
            if(!have.containsKey(c)){
                return 0;
            }
        }

        for(char c:target.toCharArray()){
            int fh=have.get(c);
            int fn=need.get(c);
            ans=Math.min(fh/fn,ans);
        }
        return ans;
    }   
}