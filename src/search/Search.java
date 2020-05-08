package search;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-08
 * @ Github: HappyOnion801
 */
public class Search {
    public static class Point {
        private int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
    }

    private static final int[][] NEXT = new int[][]{
            {0, 1, 0, -1},
            {1, 0, -1, 0}
    };

    private Stack<Point> step;

    private int[][] map = new int[][]{
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, 0, 0, 0, -1, 0, -1, -1, -1},
            {-1, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, 0, 0, 0, -1, -1, -1, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
    };

    public Search() {
        this.step = new Stack<>();
    }

    private boolean dfs(int bex, int bey, int enx, int eny) {
        step.push(new Point(bex, bey));
        if (bex == enx && bex == eny) return true;
        if (this.map[bex][bey] < 0) {
            this.step.pop();
            return false;
        }
        this.map[bex][bey] = -2;
        for (int i = 0; i < 4; i++) {
            boolean flag = this.dfs(bex + NEXT[0][i], bey + NEXT[1][i], enx, eny);
            if (flag) return true;
        }
        this.step.pop();
        this.map[bex][bey] = 0;
        return false;
    }

    public Stack<Point> getStep(int bex, int bey, int enx, int eny) {
        this.step = new Stack<>();
        this.dfs(bex, bey, enx, eny);
        return this.step;
    }

    private void bfs(int x, int y) {
        LinkedList<Point> flag = new LinkedList<>();
        this.map[x][y] = 1;
        flag.add(new Point(x, y));
        while (!flag.isEmpty()) {
            Point p = flag.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + NEXT[0][i], ny = p.y + NEXT[1][i];
                if (this.map[nx][ny] == 0) {
                    this.map[nx][ny] = this.map[p.x][p.y] + 1;
                    flag.add(new Point(nx, ny));
                } else if (this.map[nx][ny] > 0) {
                    this.map[nx][ny] = Math.min(this.map[nx][ny], this.map[p.x][p.y] + 1);
                }
            }
        }
    }

    public void printStep(int x, int y) {
        this.bfs(x, y);
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] h : this.map) {
            for (int num : h) {
                if (num == -1) sb.append("███");
                else if (num == -2) sb.append("♡♡♡");
                else sb.append(num + " ");
                if (num < 10 && num >= 0) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
