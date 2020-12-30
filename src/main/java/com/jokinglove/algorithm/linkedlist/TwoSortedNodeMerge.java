package com.jokinglove.algorithm.linkedlist;

import com.jokinglove.algorithm.datastruct.SingletonNode;

/**
 * 两个有序单项链表的合并，结果还是有序的
 *
 * @author <a href="mailto:jokinglove@foxmail.com">JOKING</a>
 * @since 1.0.0
 */
public class TwoSortedNodeMerge {

    public static void main(String[] args) {

        SingletonNode<Integer> node0 = node(0);
        SingletonNode<Integer> node1 = node(1);
        SingletonNode<Integer> node2 = node(2);
        SingletonNode<Integer> node3 = node(3);
        SingletonNode<Integer> node4 = node(4);
        SingletonNode<Integer> node5 = node(5);
        SingletonNode<Integer> node6 = node(6);


        node0.setNext(node1);
        node1.setNext(node4);
        node4.setNext(node6);

        node2.setNext(node3);
        node3.setNext(node5);

        System.out.println("head1 = " + node0);
        System.out.println("head2 = " + node2);

        SingletonNode<Integer> node = mergeTwoSortedNode(node0, node2);
        System.out.println("result = " + node);
    }

    private static SingletonNode<Integer> node(Integer i) {
        return new SingletonNode<>(i);
    }

    /**
     * 递归合并两个链表
     * @param head1 第一个链表的头
     * @param head2 第二个链表的头
     * @return 合并后的链表
     */
    private static SingletonNode<Integer> mergeTwoSortedNode(SingletonNode<Integer> head1, SingletonNode<Integer> head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        SingletonNode<Integer> head;
        if(head1.getValue() < head2.getValue()) {
            head = head1;
            head.setNext(mergeTwoSortedNode(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(mergeTwoSortedNode(head1, head2.getNext()));
        }
        return head;
    }


}
