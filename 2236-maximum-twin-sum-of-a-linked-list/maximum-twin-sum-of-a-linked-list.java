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
    public int pairSum(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        while (head != null) {
            al.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < al.size() / 2; i++) {
            maxi = Math.max(maxi, al.get(i) + al.get(al.size() - i - 1));
        }
        return maxi;
    }
}