package search;

import java.util.Stack;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-08
 * @ Github: HappyOnion801
 */
public class Demo {
    public static void main(String[] args) {
        Search s = new Search();
        System.out.println(s);
        Stack<Search.Point> step = s.getStep(1, 1, 8, 8);
        System.out.println(step);
        s.printStep(1,1);
    }
}
