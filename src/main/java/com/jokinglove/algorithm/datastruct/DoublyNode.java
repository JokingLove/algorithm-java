package com.jokinglove.algorithm.datastruct;

/**
 * 双向链表 Node
 *
 * @author <a href="mailto:jokinglove@foxmail.com">JOKING</a>
 * @since   1.0.0
 */
public class DoublyNode<T> {

    private T value;

    private DoublyNode<T> pre;

    private DoublyNode<T> next;

    public DoublyNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyNode<T> getPre() {
        return pre;
    }

    public void setPre(DoublyNode<T> pre) {
        this.pre = pre;
    }

    public DoublyNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "value=" + value +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
