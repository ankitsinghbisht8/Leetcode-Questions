class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollars=0;
        int tenDollars=0;

        for(int bill :bills){
            if(bill == 5){
                fiveDollars++;
            }
            else if(bill == 10){// 10 dollars bill
                if(fiveDollars>0){
                    fiveDollars--;
                    tenDollars++;
                }
                else{
                    return false;
                }
            }
            else{ // 20 dollars bill
                if(tenDollars>0 && fiveDollars>0){
                    tenDollars--;
                    fiveDollars--;
                }
                else if(fiveDollars>=3){
                    fiveDollars -=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
