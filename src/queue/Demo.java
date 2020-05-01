package queue;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class Demo {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);
        int count = 0;
        while (!aq.isFull()) aq.push(count++);
        while (!aq.isEmpty()) System.out.print(aq.pop() + " ");
        System.out.println();
        CircleArrayQueue caq = new CircleArrayQueue(10);
        while (!caq.isFull()) caq.push(count++);
        while (!caq.isEmpty()) System.out.print(caq.pop() + " ");
        System.out.println();
        while (!caq.isFull()) caq.push(count++);
        while (!caq.isEmpty()) System.out.print(caq.pop() + " ");
        System.out.println();
    }
}
