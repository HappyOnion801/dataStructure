package list;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class LinkedList implements List {
    private class Node {
        Integer data;
        Node next;

        //创建链表的节点对象
        private Node(Integer data, Node next) {
            this.data = data;
            //指向下一个节点
            this.next = next;
        }
    }

    //创建头节点方便操作链表
    Node header;
    private int size;

    public LinkedList() {
        header = new Node(null, null);
        size = 0;
    }

    @Override
    public void add(Integer data) {
        Node t = header;
        while (t.next != null) t = t.next;
        t.next = new Node(data, null);
        size++;
    }

    @Override
    public boolean add(int index, Integer d) {
        Node t = header;
        //查找需要操作的对象的直接前驱
        while (index != 0 && t != null) {
            index--;
            t = t.next;
        }
        //对元素进行操作
        if (t != null) {
            t.next = new Node(d, t.next);
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int index) {
        Node t = header;
        while (index != 0 && t.next != null) {
            index--;
            t = t.next;
        }
        if (t.next != null) {
            t.next = t.next.next;
            size--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean set(int index, Integer date) {
        Node t = header;
        while (index != 0 && t.next != null) {
            index--;
            t = t.next;
        }
        if (t.next != null) {
            t.next.data = date;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer get(int index) {
        Node t = header;
        while (index != 0 && t.next != null) {
            index--;
            t = t.next;
        }
        return t.next == null ? null : t.next.data;
    }

    public Integer getLast(int index) {
        if (index < 0) return null;
        int count = -index;
        Node front = header,t  = header;
        while ((t = t.next) != null) {
            count++;
            if (count > 0) front = front.next;
        }
        return front == header ? null : front.data;
    }


    public int size() {
        return size;
    }
}
