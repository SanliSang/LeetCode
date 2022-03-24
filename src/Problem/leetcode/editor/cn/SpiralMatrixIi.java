//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 602 👎 0


package Problem.leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi{
    public static void main(String[] args){
        Solution solution = new SpiralMatrixIi().new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(5)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] arr = new int[n][n];
            if (n == 1){
                arr[0][0] = 1;
                return arr;
            }
            int num = 1;
            int i = 0;
            int j = 0;
            int leftBound = 0;
            int rightBound = n-1;
            int top = 0;
            int button = n-1;
            while (num < n*n){
                while (arr[i][j] == 0 && j < rightBound){ // 右
                    arr[i][j] = num;
                    j++;
                    num++;
                }
                while (arr[i][j] == 0 && i < button){ // 下
                    arr[i][j] = num;
                    i++;
                    num++;
                }
                while (arr[i][j] == 0 && j > leftBound){ // 左
                    arr[i][j] = num;
                    j--;
                    num++;
                }
                while (arr[i][j] == 0 && i > top){ // 上
                    arr[i][j] = num;
                    i--;
                    num++;
                }

                i++;
                j++;
                rightBound--;
                leftBound++;
                top++;
                button--;
            }
            if (n%2 != 0) arr[n/2][n/2] = num;
            return arr;
        }

        public int[][] generateMatrix2(int n) {
            int[][] arr = new int[n][n];
            for (int k = 1; k <= n * n ; k++) {
            }
            return arr;
        }
    }
    /**
     * 审题：提交二维矩阵，1 <= n <= 20
     */
//leetcode submit region end(Prohibit modification and deletion)

}