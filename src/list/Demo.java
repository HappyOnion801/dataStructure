package list;

import java.util.Random;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class Demo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Random r = new Random();
        //进行对链表操作的模拟，进行100次
        int count = 100;
        while (count-- != 0) {
            int num = r.nextInt(4);
            if (num == 0) {
                num = r.nextInt(100);
                ll.add(num);
                System.out.println("添加" + num + "，当前链表长度：" + ll.size());
            } else if (num == 1) {
                num = r.nextInt(100);
                int w = r.nextInt(20);
                System.out.println("在" + w + "处添加" + num + "，状态：" + ll.add(w, num) + "，当前链表长度：" + ll.size());
            } else if (num == 2) {
                int w = r.nextInt(20);
                System.out.println("删除" + w + "处的" + ll.get(w) + "，状态：" + ll.delete(w) + "，当前链表长度：" + ll.size());
            } else if (num == 3) {
                int w = r.nextInt(20);
                num = r.nextInt(100);
                System.out.println("将" + w + "处的" + ll.get(w) + "设置成" + num + "，状态：" + ll.set(w, num) + "，当前链表长度：" + ll.size());
            }
            System.out.print("\t内容：");
            for (int i = 0; i < ll.size(); i++) {
                System.out.print(ll.get(i) + " ");
            }
            System.out.println("\n");
        }
    }
}
