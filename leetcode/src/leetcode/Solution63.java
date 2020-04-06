package leetcode;

/**
 * 63. 不同路径 II 存在障碍物
 */
public class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] arr = obstacleGrid;
        //初始化原数组，障碍物以及第一行或是第一列障碍物右边或是下面的位置设置为0，
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                } else {
                    if (i == 0 && j != 0 && arr[0][j - 1] == 0) {
                        arr[i][j] = 0;
                    } else if (j == 0 && i != 0 && arr[i - 1][0] == 0) {
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = 1;
                    }

                }
            }
        }
        //每行一个元素
        if (m == 1) {
            for (int i = 1; i < n; i++) {
                if (arr[0][i] == 1) {
                    arr[0][i] = arr[0][i - 1];
                }
            }
        }
        //每列一个元素
        if (n == 1) {
            for (int i = 1; i < m; i++) {
                if (arr[i][0] == 1) {
                    arr[i][0] = arr[i - 1][0];
                }
            }
        }
        //计算路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 0}, {1, 1}, {0, 0}};
        int i = uniquePathsWithObstacles(arr);
        System.out.println(i);
    }
}
