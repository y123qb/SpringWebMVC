package com.cn.bbwt.algorithm.linkedlist;

/***
 * �����л��ļ��
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
     * ˫ָ�뷨��һ����ָ��ÿ����������һ����ָ��ÿ����һ����������ڻ�������ָ��϶��߲��꣬���һ����غϵ�ʱ��
     * ʱ�临�Ӷ�O(n);�ռ临�Ӷ�O(1)��Ϊ��ֻ�����������ָ�룬û�з��������ڴ棻
     * ���ѭ�����ܲ�ֹѭ��n�Σ���Ϊ���غϣ������п��ܿ�ָ����ظ��߹��ü����ڵ�
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
     * �����ڵ�
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
