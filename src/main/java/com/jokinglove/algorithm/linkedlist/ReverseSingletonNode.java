package com.jokinglove.algorithm.linkedlist;

import com.jokinglove.algorithm.datastruct.SingletonNode;

/**
 * 反转一个单项链表
 *
 * @author <a href="mailto:jokinglove@foxmail.com">JOKING</a>
 * @since   1.0.0
 */
public class ReverseSingletonNode {

    public static void main(String[] args) {
        SingletonNode<Integer> node1 = node(1);
        SingletonNode<Integer> node2 = node(2);
        SingletonNode<Integer> node3 = node(3);
        SingletonNode<Integer> node4 = node(4);
        SingletonNode<Integer> node5 = node(5);
        SingletonNode<Integer> node6 = node(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

//        System.out.println(node1);
//        SingletonNode<Integer> node = reverseSingletonNode(node1);
//        System.out.println("reverseSingletonNode 的结果是：" + node);

        SingletonNode<Integer> recursion = reverseSingletonByRecursion(node1);
        System.out.println("reverseSingletonByRecursion 的结果是：" + recursion);

//        SingletonNode<Integer> reverse = reverse(node1);
//        System.out.println("reverse 的结果是：" + reverse);
    }

    private static SingletonNode<Integer> reverse(SingletonNode<Integer> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        SingletonNode<Integer> rHead = head;
        SingletonNode<Integer> rCurr = head.getNext();
        while(rCurr != null) {
            SingletonNode<Integer> next = rCurr.getNext();
            rCurr.setNext(rHead);
            rHead = rCurr;
            rCurr = next;
        }
        return rHead;
    }


    /**
     * 1 -> 2 -> 3 -> 4
     * 1 <- 2 <- 3 <- 4
     *
     * @param head 链表的头元素
     * @return  反转后的链表
     */
    private static SingletonNode<Integer> reverseSingletonNode(SingletonNode<Integer> head) {
        if(head == null) return null;

        SingletonNode<Integer> pFirst = head;
        SingletonNode<Integer> pPre = pFirst;
        SingletonNode<Integer> pCur = head.getNext();

        while(pCur != null) {
            SingletonNode<Integer> pFuture = pCur.getNext();
            pPre.setNext(pFuture);
            pCur.setNext(pFirst);
            pFirst = pCur;
            pCur = pFuture;
        }
        return pFirst;
    }

    private static SingletonNode<Integer> reverseSingletonByRecursion(SingletonNode<Integer> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        SingletonNode<Integer> next = head.getNext();
        head.setNext(null);
        SingletonNode<Integer> reverseNode = reverseSingletonByRecursion(next);
        next.setNext(head);
        return reverseNode;
    }


    private static SingletonNode<Integer> node(Integer i) {
        return new SingletonNode<>(i);
    }
}
