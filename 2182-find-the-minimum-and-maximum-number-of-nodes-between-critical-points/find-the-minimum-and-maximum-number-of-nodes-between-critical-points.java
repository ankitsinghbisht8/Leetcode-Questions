/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List <Integer> al=new ArrayList<>();
        int prev=head.val;
        int idx=1;
        head=head.next;
        while(head!=null){
            int curr=head.val; //since head=head.next and curr=head.next.val
            if(head.next!=null){
                int next=head.next.val; //here next=head.next.next.val
                if((curr>prev && curr>next) || (curr<prev && curr<next)){
                    al.add(idx);
                }
            }
                head=head.next;
                idx++;
                prev=curr;
            
        }
        int n=al.size();
        if(n<2){
            return new int []{-1,-1};
        }
        int max=al.get(n-1)-al.get(0);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<al.size();i++){
            int diff=al.get(i)-al.get(i-1);
            if(diff<min){
                min=diff;
            } 
        }

        return new int []{min,max};

    }
}