package com.cn.bbwt.algorithm.linkedlist;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }


    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
