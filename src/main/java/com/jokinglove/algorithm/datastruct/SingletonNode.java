package com.jokinglove.algorithm.datastruct;

/**
 * 单项链表
 *
 * @author <a href="mailto:jokinglove@foxmail.com">JOKING</a>
 * @since 1.0.0
 */
public class SingletonNode<T> {
    private T value;
    private SingletonNode<T> next;

    public SingletonNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SingletonNode<T> getNext() {
        return next;
    }

    public void setNext(SingletonNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
