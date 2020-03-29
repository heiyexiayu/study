import org.w3c.dom.NodeList;

/**
 * 两数相加
 */
public class Solution2 {
    /**
     * 分别遍历两个list，注意进位也要相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode newNode = new ListNode(0);
        ListNode x = newNode;
        int over = 0;
        while (p != null && q != null) {
            int sum = p.val + q.val + over;
            int mod = sum % 10;
            over = sum / 10;
            p.val=mod;
            x.next = p;
            x = x.next;
            p=p.next;
            q=q.next;
        }
        while(p != null ){
            int sum = p.val + over;
            int mod = sum % 10;
            over = sum / 10;
            p.val=mod;
            x.next =p;
            x = x.next;
            p=p.next;
        }
        while ( q != null) {
            int sum = q.val + over;
            int mod = sum % 10;
            over = sum / 10;
            q.val=mod;
            x.next = q;
            x = x.next;
            q=q.next;
        }
        if (over!=0){
            x.next = new ListNode(over);
        }
        return newNode.next;
    }

    public static void main(String[] args) {

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}