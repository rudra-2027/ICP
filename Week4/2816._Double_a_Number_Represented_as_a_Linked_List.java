class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int carry = 0;
        while(temp!=null){
            int val = temp.val*2+carry;
            temp.val = val%10;
            carry = val/10;
            if(temp.next==null &&carry>0){
                temp.next = new ListNode(carry);
                carry = 0;
                break;
            }
            temp= temp.next;
        }
        return reverse(head);
    }
    
}
