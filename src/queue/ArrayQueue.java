package queue;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class ArrayQueue {
    private int[] date; //用来存放数据的数组
    private int maxSize; //设置队列的最大长度
    private int size;//用来表表示队列中内容的个数
    private int rear;//指向队尾
    private int front;//指向队首

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.date = new int[maxSize];
        this.front = -1;
        this.rear = this.size = 0;
    }

    public boolean push(int d) {
        if (!this.isFull()) {
            this.date[this.rear] = d;
            this.rear++;
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    public int pop() {
        this.size--;
        return this.date[++this.front];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize - 1;
    }

    public int size() {
        return this.size;
    }
}
