import java.util.List;

/**
 * 24. 两两交换链表中的节点
 */
class Solution {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
public static ListNode swap(ListNode head){
        if(head==null|| head.next==null){
            return head;
        }
        ListNode temp=head.next;
        head.next=swap(temp.next);
        temp.next=head;
        return temp;
}
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        ListNode listNode6=new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        ListNode listNode = swap(listNode1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}