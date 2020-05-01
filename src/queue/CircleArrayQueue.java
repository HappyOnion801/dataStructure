package queue;

import java.util.concurrent.BlockingDeque;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class CircleArrayQueue {
    private int[] date;//用来存放数据的数组
    private int front;//指向队首
    private int rear;//指向队尾
    private int maxSize;//队列的最大容量
    private int size;//队列中当前元素个数

    public CircleArrayQueue(int maxSize) {
        this.date = new int[this.maxSize = maxSize];
        this.front = this.rear = this.size = 0;
    }

    public boolean push(int d) {
        if (!isFull()) {
            date[rear] = d;
            rear = (rear + 1) % maxSize;//使得队列循环
            size++;
            return true;
        }
        return false;
    }

    public Integer pop() {
        if (!isEmpty()) {
            int res = date[front];
            front = (front + 1) % maxSize;//使得队列循环
            this.size++;
            return res;
        }
        return null;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public int size() {
        return this.size;
    }
}


