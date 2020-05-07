package stack;

import stack.cal.PolishNotation;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-03
 * @ Github: HappyOnion801
 */
public class Demo {
    public static void main(String[] args) {
        PolishNotation polishNotation = new PolishNotation("((1+2)*(3+5)-2)*2");
        String[] mind = polishNotation.getMindPolishNotation();

        System.out.print("中缀表达式：");
        for (String str : mind) {
            System.out.print(str + " ");
        }
        System.out.println();

        String[] resverPolishNotation = polishNotation.getResverPolishNotation();
        System.out.print("后缀表达式：");
        for (String str : resverPolishNotation) {
            System.out.print(str + " ");
        }
        System.out.println();

        System.out.println("结果：" + polishNotation.cal());
    }
}
