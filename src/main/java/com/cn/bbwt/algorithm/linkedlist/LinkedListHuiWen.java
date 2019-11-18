package com.cn.bbwt.algorithm.linkedlist;

import java.util.Stack;

public class LinkedListHuiWen {

    static LinkedListMerge llm = new LinkedListMerge();

    /***
     * 利用栈，先遍历一次压栈，再遍历一次弹栈做判断
     * 时间复杂度O(1),因为用了栈，牺牲了空间
     * @param node
     * @return
     */
    public boolean isHuiWen(Node node) {
        Stack<Node> stack = new Stack<Node>();
        Node tep = node;
        while (tep != null) {
            stack.push(tep);
            tep = tep.next;
        }
        Node cur = node;
        while (cur != null) {
            if (stack.pop().data != cur.data) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /***
     * 把链表翻转判断
     * 时间O(1)空间复杂度O(n)
     * @param node
     * @return
     */
    public boolean isHuiWen2(Node node) {
        Node tmp = node;
        Node newNode = null;
        while(tmp!=null){//一次循环 时间复杂度O(1)
            int data = tmp.data;
            Node n = new Node();
            n.data=data;
            n.next = newNode;
            tmp = tmp.next;
            newNode = n;
        }
        while(node!=null){
            if(node.data!=newNode.data){
                return false;
            }
            node = node.next;
            newNode = newNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListHuiWen ll = new LinkedListHuiWen();
        Node node = ll.add();
        System.out.println(ll.isHuiWen2(node));
    }

    /***
     * 新增节点
     * @return
     */
    public Node add() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        return node1;
    }
}
