package com.cn.bbwt.algorithm.linkedlist;

/***
 * 链表中环的检测
 * https://leetcode-cn.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        Node head = llc.add();
        boolean hasCycle = llc.hasCycle(head);
        System.out.println(hasCycle);
    }

    /***
     * 双指针法：一个快指针每次走两步，一个慢指针每次走一步，如果存在环，快慢指针肯定走不完，并且会有重合的时候；
     * 时间复杂度O(n);空间复杂度O(1)因为它只利用自身带的指针，没有分配其他内存；
     * 这个循环可能不止循环n次，因为是重合，所以有可能快指针会重复走过好几个节点
     * @param head
     * @return
     */
    public boolean hasCycle(Node head){
        if(head==null || head.next==null){
            return false;
        }
        Node fast =head.next.next;
        Node slow = head.next;
        while(fast!=null && fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    /***
     * 新增节点
     * @return
     */
    public Node add() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
//        node6.next = node3;
        return node1;
    }

}
