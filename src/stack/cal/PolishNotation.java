package stack.cal;

import stack.Stack;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-06
 * @ Github: HappyOnion801
 */
public class PolishNotation {
    private StringBuffer mind;

    //对字符串进行初步处理
    public PolishNotation(String m) {
        this.mind = new StringBuffer(m);
        for (int i = 0; i < mind.length(); i++) {
            if ("()+-*/".contains(String.valueOf(mind.charAt(i)))) {
                mind.insert(i, ' ');
                mind.insert(i + 2, ' ');
                i += 2;
            }
        }
    }

    //利用输入的字符串获得中缀表达式
    public String[] getMindPolishNotation() {
        return this.mind.toString().trim().split(" +");
    }

    private int getPriority(String a) {
        if (a == null) return 0;
        switch (a) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    /*
    * 后缀表达式求法：
    * 1）如果是数字就输出
    * 2）如果是左括号就压栈
    * 3）如果是右括号就将栈中左括号上边的所有运算符出栈输出，然后出栈左括号，不输出
    * 4）如果是运算符，就将栈中所有运算级大于等于它的运算符出栈输出，然后改运算符出栈
    * 5）直至将中缀表达式扫描完毕
    * 6）将栈中的所有内容出栈并输出
    * */
    public String[] getResverPolishNotation() {
        Stack s1 = new Stack(), s2 = new Stack();
        String[] mind = this.getMindPolishNotation();
        for (int i = 0; i < this.getMindPolishNotation().length; i++) {
            String str = mind[i];
            if (!"()+-*/".contains(str)) {
                s2.push(str);
            } else if ("(".equals(str)) {
                s1.push(str);
            } else if (")".equals(str)) {
                while (!"(".equals(s1.get())) s2.push(s1.pop());
                s1.pop();
            } else if ("+-*/".contains(str)) {
                while ((this.getPriority(str) <= this.getPriority(s1.get())) && s1.size() != 0) s2.push(s1.pop());
                s1.push(str);
            }
        }
        while (s1.size() != 0) s2.push(s1.pop());
        String[] res = new String[s2.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s2.pop();
        }
        return res;
    }

    private Double c(double a, double b, String c) {
        switch (c) {
            case "+":
                return a + b;
            case "-":
                return b - a;
            case "*":
                return a * b;
            case "/":
                return b / a;
            default:
                return null;
        }
    }

    /*
    * 后缀表达式计算结果：
    * 1）如果是数字就压栈
    * 2）如果是符号就取出两次栈顶元素做该运算，并将结果入栈
    * 3）直至运算结束
    * */
    public Double cal() {
        double res = 0;
        java.util.Stack<Double> s = new java.util.Stack<Double>();
        String[] resverPolishNotation = this.getResverPolishNotation();
        for (String str : resverPolishNotation) {
            if ("+-*/".contains(str)) {
                Double a = s.pop();
                Double b = s.pop();
                s.push(res = this.c(a, b, str));
            } else {
                s.push(Double.valueOf(str));
            }
        }
        return res;
    }
}
