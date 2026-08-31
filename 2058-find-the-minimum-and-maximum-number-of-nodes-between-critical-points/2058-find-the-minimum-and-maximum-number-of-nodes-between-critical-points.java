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
        int count=0;
        int first=-1;
        int currprev=-1;
        int min =10000000;
        int max=-1;
        int prev = -1;
        prev=head.val;
        int n=0;
        head=head.next;
        n=2;
        while(head.next!=null){
            if((head.val > prev && head.val>head.next.val) || (head.val < prev && head.val<head.next.val)){
                count++;
                if(first==-1){
                    first=n;
                    currprev=n;
                }
                else{
                    min=Math.min(min,n-currprev);
                    currprev=n;
                }
            }
            prev=head.val;
            head=head.next;
            n++;
        }

        if(count >=2) {
            return new int[] {min,currprev-first};
        }

        return new int[] {-1,-1};
    }
}