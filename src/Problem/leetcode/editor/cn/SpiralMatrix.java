//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 992 👎 0


package Problem.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix{
    public static void main(String[] args){
        Solution solution = new SpiralMatrix().new Solution();
//        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4,5,6},{7,8,9}}));
//        System.out.println(solution.spiralOrder(new int[][]{{7,8,9}}));
//        System.out.println(solution.spiralOrder(new int[][]{{1},{2},{3}}));
//        System.out.println(solution.spiralOrder(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}}));
        // 1,2,3,4,8,12,11,10,9,5,6,7
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            LinkedList<Integer> list = new LinkedList<>();
            if (matrix[0].length > 1 && matrix.length == 1){ // 只有一行
                for (int i = 0; i < matrix[0].length; i++) {
                    list.add(matrix[0][i]);
                }
                return list;
            }
            if (matrix.length > 1 && matrix[0].length == 1){ // 只有一列
                for (int j = 0; j < matrix.length; j++) {
                    list.add(matrix[j][0]);
                }
                return list;
            }
            int size = matrix[0].length*matrix.length; // 二维数组的总数
            int leftBound = 0;
            int rightBound = matrix[0].length - 1; // 行
            int top = 0;
            int button = matrix.length - 1; // 列

            int i = 0;
            int j = 0;
            while (size >= 1){
                while (j < rightBound){ // 右
                    list.add(matrix[i][j]);
                    size--;
                    j++;
                }
                while (i < button){ // 下
                    list.add(matrix[i][j]);
                    size--;
                    i++;
                }
                while (j > leftBound){ // 左
                    list.add(matrix[i][j]);
                    size--;
                    j--;
                }
                while (i > top){ // 右
                    list.add(matrix[i][j]);
                    size--;
                    i--;
                }
                i++;
                j++;
                leftBound++;
                rightBound--;
                top++;
                button--;
            }
            if (matrix[0].length == matrix.length && matrix.length%2 != 0){
                list.add(matrix[matrix.length/2][matrix.length/2]);
            }
            return list;
        }
        /*
        public List<Integer> spiralOrder2(int[][] matrix) {
            LinkedList<Integer> result = new LinkedList<>();
            if(matrix==null||matrix.length==0) return result;
            int left = 0; // 左边界（列）
            int right = matrix[0].length - 1; // 右边界（列）
            int top = 0; // 上边界（行）
            int bottom = matrix.length - 1; // 下边界（行）
            int numEle = matrix.length * matrix[0].length; // 一共需要的操作数（每次操作后-1）

            // 就是将二维的矩阵看成是每个一维的矩阵的常规遍历，所以关键在于如何将划分成每一个一维矩阵、遍历起点和终点的位置是什么
            while (numEle >= 1) {
                for (int i = left; i <= right && numEle >= 1; i++) { // 向右走（上边界top不变）
                    result.add(matrix[top][i]);
                    numEle--;
                }
                top++; // 走完顶层后，顶层更新+1
                for (int i = top; i <= bottom && numEle >= 1; i++) { // 向下走（右边界right不变）
                    result.add(matrix[i][right]);
                    numEle--;
                }
                right--;
                for (int i = right; i >= left && numEle >= 1; i--) { // 向右走（下边界bottom不变）
                    result.add(matrix[bottom][i]);
                    numEle--;
                }
                bottom--;
                for (int i = bottom; i >= top && numEle >= 1; i--) { // 向上走（左边界left不变）
                    result.add(matrix[i][left]);
                    numEle--;
                }
                left++;
            }
            return result;
        }

        */

        public List<Integer> spiralOrder3(int[][] matrix) {
            LinkedList<Integer> list = new LinkedList<>();
            if(matrix==null||matrix.length==0) return list;
            int left = 0; // 左边界（列）
            int right = matrix[0].length - 1; // 右边界（列）
            int top = 0; // 上边界（行）
            int bottom = matrix.length - 1; // 下边界（行）
            int numEle = matrix.length * matrix[0].length; // 一共需要的操作数（每次操作后-1）

            while (numEle >= 1){
                for (int i = left; i <= right && numEle >= 1; i++) {
                    list.add(matrix[top][i]);
                    numEle--;
                }
                top++;
                for (int i = top; i <= bottom && numEle >= 1; i++) {
                    list.add(matrix[i][right]);
                    numEle--;
                }
                right--;
                for (int i = right; i >= left && numEle >= 1; i--) {
                    list.add(matrix[bottom][i]);
                    numEle--;
                }
                bottom--;
                for (int i = bottom; i >= top && numEle >= 1; i--) {
                    list.add(matrix[i][left]);
                    numEle--;
                }
                left++;
            }
            return list;
        }

    }
    /**
     * 审题：给出二维数组，并通过二维数组顺时针遍历放入列表内
     * 思路1：按层遍历。遍历规则：左闭右开。
     */
//leetcode submit region end(Prohibit modification and deletion)

}