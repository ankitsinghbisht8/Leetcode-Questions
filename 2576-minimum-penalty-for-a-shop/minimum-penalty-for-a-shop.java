class Solution {

    public int bestClosingTime(String customers) {
        int curPenalty = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                curPenalty++;
            }
        }
        int pen = curPenalty;
        int earliest = 0;

        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }
            if (curPenalty < pen) {
                earliest = i + 1;
                pen = curPenalty;
            }
        }

        return earliest;
    }
}