class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int result=0;
        int customerLeft=0;
        for(int i=0;i<n;i++){
            char ch=customers.charAt(i);
            if(ch=='Y'){
                customerLeft++;
                if(customerLeft>0){
                    result=i+1;
                    customerLeft=0;
                }
            }
            else customerLeft--;
        }
        return result;
    }
}