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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int i = 0;
        int n = size(head);
        int arr[] = new int[n];
        while(temp!=null){
            ListNode nn = temp.next;
            boolean flag = false;
            while(nn!=null){
                if(nn.val>temp.val){
                    arr[i] = nn.val;
                    flag = true;
                    break;
                }
                nn = nn.next;
            }
            
            if(!flag){
                arr[i] =0;
            }
                temp = temp.next;
                i++;
        }
        return arr;
    }
    public int size(ListNode head){
        int cnt = 0;
        while(head!= null){
            cnt++;
            head = head.next;
        }
        return cnt;

    }
}
