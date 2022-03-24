//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 360 👎 0


package Problem.leetcode.editor.cn;

import java.util.Arrays;

public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args){
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        System.out.println(Arrays.toString(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[]{};
            int n = matrix.length*matrix[0].length;
            int[] arr = new int[n];

            int index = 0;
            int left = 0; // 左边界指针
            int right = matrix[0].length-1; // 右边界指针
            int top = 0; // 上边界指针
            int button = matrix.length-1; // 下边界指针

            while (n >= 1){
                for (int i = left; i <= right && n >= 1; i++) {
                    arr[index++] = matrix[top][i];
                    n--;
                }
                top++; // 上边界往下移
                for (int i = top; i <= button && n >= 1; i++) {
                    arr[index++] = matrix[i][right];
                    n--;
                }
                right--;
                for (int i = right; i >= left && n >= 1; i--) {
                    arr[index++] = matrix[button][i];
                    n--;
                }
                button--;
                for (int i = button; i >= top && n >= 1; i--) {
                    arr[index++] = matrix[i][left];
                    n--;
                }
                left++;
            }
            return arr;
        }
    }

    /**
     * 审题：顺时针打印矩阵
     */
//leetcode submit region end(Prohibit modification and deletion)

}