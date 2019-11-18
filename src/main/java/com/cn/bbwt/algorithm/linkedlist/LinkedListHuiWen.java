package com.cn.bbwt.algorithm.linkedlist;

import java.util.Stack;

public class LinkedListHuiWen {

    static LinkedListMerge llm = new LinkedListMerge();

    /***
     * ����ջ���ȱ���һ��ѹջ���ٱ���һ�ε�ջ���ж�
     * ʱ�临�Ӷ�O(1),��Ϊ����ջ�������˿ռ�
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
     * ������ת�ж�
     * ʱ��O(1)�ռ临�Ӷ�O(n)
     * @param node
     * @return
     */
    public boolean isHuiWen2(Node node) {
        Node tmp = node;
        Node newNode = null;
        while(tmp!=null){//һ��ѭ�� ʱ�临�Ӷ�O(1)
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
     * �����ڵ�
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
