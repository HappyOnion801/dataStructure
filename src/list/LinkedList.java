package list;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class LinkedList {
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

    //在指定位置添加元素
    public boolean add(int index, int d) {
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

    public void add(int data) {
        Node t = header;
        while (t.next != null) t = t.next;
        t.next = new Node(data, null);
        size++;
    }

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

    public boolean set(int index, int date) {
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

    public Integer getLast(int index) {
        if (index < 0) return null;
        int count = -index;
        Node front = header, t = header;
        while ((t = t.next) != null) {
            count++;
            if (count > 0) front = front.next;
        }
        return front == header ? null : front.data;
    }

    public Integer get(int index) {
        Node t = header;
        while (index != 0 && t.next != null) {
            index--;
            t = t.next;
        }
        if (t.next != null) {
            return t.next.data;
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }
}
