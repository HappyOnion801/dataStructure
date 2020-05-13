package queen8;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-13
 * @ Github: HappyOnion801
 */
public class QueenEight {
    private static final int MAX = 8;
    private static int count = 0;
    private static int countJudge = 0;
    private static int[] queen = new int[MAX];

    private static boolean judge(int n) {
        countJudge++;
        for (int i = 0; i < n; i++)
            if (queen[i] == queen[n] || Math.abs(n - i) == Math.abs(queen[n] - queen[i])) return false;
        return true;
    }

    private static void check(int n) {
        if (n == MAX) {
            for(int num : queen){
                System.out.print(num + " ");
            }

            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < MAX; i++) {
            queen[n] = i;
            if (judge(n)) check(n + 1);
        }
    }

    public static void main(String[] args) {
        check(0);
        System.out.println(count + " " + countJudge);
    }
}
