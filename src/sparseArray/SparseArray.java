package sparseArray;

/**
 * @ Author: MaCode
 * @ Date: 2020-05-01
 * @ Github: HappyOnion801
 */
public class SparseArray {
    //获得稀疏数组的方法
    public static int[][] getSparseArray(int[][] arr) {
        //获得原来数组的行数和列数
        int rowNum = arr.length;
        int colNum = arr[0].length;
        int dataNum = 0;
        //获得数组内有效数据的个数
        for (int[] row : arr) {
            for (int data : row) {
                if (data != 0) dataNum++;
            }
        }
        //存放数组的行数、列数、有效数据个数
        int[][] res = new int[dataNum + 1][3];
        res[0][0] = rowNum;
        res[0][1] = colNum;
        res[0][2] = dataNum;
        int count = 1;
        //存放数据
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    res[count][0] = i;
                    res[count][1] = j;
                    res[count++][2] = arr[i][j];
                }
            }
        }
        return res;
    }

    //获得原数组
    public static int[][] getArray(int[][] arr) {
        //创建数组
        int[][] res = new int[arr[0][0]][arr[0][1]];
        //将稀疏矩阵的数据取出
        for (int i = 1; i < arr.length; i++) {
            res[arr[i][0]][arr[i][1]] = arr[i][2];
        }
        return res;
    }

}
