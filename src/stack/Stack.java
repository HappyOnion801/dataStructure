package stack;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-03
 * @ Github: HappyOnion801
 */

//实现最简单的栈
public class Stack {
    private class Node {
        String date;
        Node next, last;

        Node(String date) {
            this.date = date;
            this.last = this.next = null;
        }
    }

    private Node header, rear;
    int size;

    public Stack() {
        this.header = this.rear = new Node(null);
        this.size = 0;
    }

    public void push(String date) {
        Node node = new Node(date);
        this.rear.next = node;
        node.last = this.rear;
        this.rear = node;
        this.size++;
    }

    public String pop() {
        String res = this.rear.date;
        if (this.rear != this.header) {
            this.rear = this.rear.last;
            this.size--;
        }
        this.rear.next = null;
        return res;
    }

    public String get() {
        return this.rear == this.header ? null : this.rear.date;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node t = this.header.next;
        while (t != this.rear) {
            sb.append(t.date + "-");
            t = t.next;
        }
        sb.append(":size=" + this.size);
        return sb.toString();
    }
}
