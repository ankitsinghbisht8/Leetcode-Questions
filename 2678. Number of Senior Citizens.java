// Approach 1: Character-Based Extraction 
class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(int i=0;i<details.length;i++){
            int tenthplace=details[i].charAt(11) -'0';
            int onesplace=details[i].charAt(12) -'0';
            int age =tenthplace*10 + onesplace;
            if(age>60){
                count++;
            }
            }
        return count;
        }
        
    }

// Approach 2: String Parsing

class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(int i=0;i<details.length;i++){
            int age=Integer.parseInt(details[i].substring(11,13));
            if(age>60){
                count++;
            }
            }
        return count;
        }
        
    }
