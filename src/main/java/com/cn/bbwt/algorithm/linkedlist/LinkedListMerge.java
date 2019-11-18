package com.cn.bbwt.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * 将两个有序的链表合并
 * 1->3->5,1->2->3->6  合并后：1->1->2->3->3->5->6
 */
public class LinkedListMerge {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        Collections.sort(list);
//        System.out.println(list.toString());

        LinkedListMerge llm = new LinkedListMerge();
        Node node1 = llm.add1();
        Node node2 = llm.add2();
        llm.merage1(node1,node2);

    }

    public Node merage1(Node l1,Node l2){
        List<Integer> list = new ArrayList<Integer>();
        while(l1!=null || l2!=null){
          if(l1!=null){
              list.add(l1.data);
              l1 = l1.next;
          }
            if(l2!=null){
                list.add(l2.data);
                l2 = l2.next;
            }
        }
        Collections.sort(list);
        System.out.println(list.toString());
        Node node = null;
        for(int i = list.size()-1;i>=0;i--){
            if(node ==null){
                node = new Node(list.get(i));
            }else{
                Node n = new Node(list.get(i));
                n.next = node;
                node = n;
            }
        }
        System.out.println(node.toString());
        return l1;
    }

    /***
     * 新增节点
     * @return
     */
    public Node add1() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        return node1;
    }
    /***
     * 新增节点
     * @return
     */
    public Node add2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return node1;
    }


}
