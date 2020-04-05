package leetcode;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * 21. 合并两个有序链表
 */
public class Solution21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int min = 0;
        //合并
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                min = l1.val;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                min = l2.val;
                l2 = l2.next;
            } else if (l1.val == l2.val) {
                min = l1.val;
                head.next = new ListNode(min);
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            head.next = new ListNode(min);
            head = head.next;
        }
        //l1多余
        if (l1 != null) {
            head.next = l1;
        }
        //l2多余
        if (l2 != null) {
            head.next =l2;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
        ListNode listNode = mergeTwoLists(listNode2, listNode1);
        System.out.println(listNode.val);
    }
}
