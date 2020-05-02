package list;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-02
 * @ Github: HappyOnion801
 */
public class DoubleLinkedList implements List {
    private class Node {
        Node last;
        Node next;
        Integer date;

        Node(Integer date) {
            next = last = null;
            this.date = date;
        }
    }

    private Node header;
    private int size;

    public DoubleLinkedList() {
        header = new Node(null);
        header.next = header.last = null;
        size = 0;
    }

    @Override
    public void add(Integer date) {
        Node node = new Node(date);
        Node t = header;
        while (t.next != null) t = t.next;
        t.next = node;
        node.last = t;
        size++;
    }

    @Override
    public boolean add(int index, Integer date) {
        Node t = header;
        while (t != null && index != 0) {
            t = t.next;
            index--;
        }
        if (t != null) {
            Node node = new Node(date);
            node.last = t;
            node.next = t.next;
            if (t.next != null) t.next.last = node;
            t.next = node;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        Node t = header;
        while (t.next != null && index != 0) {
            t = t.next;
            index--;
        }
        if (t.next != null) {
            if (t.next.next != null) {
                t.next.next.last = t;
                t.next = t.next.next;
            } else {
                t.next.last = null;
                t.next = null;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean set(int index, Integer date) {
        Node t = header;
        while (t.next != null && index != 0) {
            t = t.next;
            index--;
        }
        if (t.next != null) {
            t.next.date = date;
            return true;
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        Node t = header;
        while (t.next != null && index != 0) {
            t = t.next;
            index--;
        }
        return t.next == null ? null : t.next.date;
    }

    @Override
    public Integer getLast(int index) {
        int count = -index;
        Node res = header, t = header;
        while ((t = t.next) != null) {
            count++;
            if (count > 0) res = res.next;
        }
        return res == header ? null : res.date;
    }

    @Override
    public int size() {
        return size;
    }
}
