package sparseArray;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class Demo {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        arr = SparseArray.getSparseArray(arr);
        System.out.println("稀疏矩阵：");
        for(int[] row : arr){
            for(int data : row){
                System.out.print("\t" + data);
            }
            System.out.println();
        }
        System.out.println();
        arr = SparseArray.getArray(arr);
        System.out.println("原矩阵：");
        for(int[] row : arr){
            for(int data : row){
                System.out.print("\t" + data);
            }
            System.out.println();
        }
    }
}
