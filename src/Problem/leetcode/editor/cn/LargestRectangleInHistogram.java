//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1730 👎 0


package Problem.leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram{
    public static void main(String[] args){
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{4,8});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights.length == 0) return 0;
            if (heights.length == 1) return heights[0];
            Stack<Integer> stack = new Stack<>();
            int ares = 0;
            for (int ans = 0; ans < heights.length; ans++) { // ans指针维护当前柱子的高度
                // 如果当前栈顶元素比指针元素要大，则表示当前指针元素为右边界，以右边界计算栈内元素小于该有边界的面积
                while (!stack.isEmpty() && heights[stack.peek()]>heights[ans]){
                    int height = heights[stack.pop()]; // 取出并记录当前高度

                    if (!stack.isEmpty() && heights[stack.peek()] == height) stack.pop(); // 特殊情况：当新栈顶与取出的高度相同时，不需要直接跳过（删除新栈顶）

                    int width;
                    if (stack.isEmpty()) width = ans; // 特殊情况：若取出高度后恰好栈空，则左边界一定是数组最左侧（也就是0），而右边界就是ans（注意取不到右边界），所以宽度就等于ans-0
                    else width = ans - stack.peek() - 1; // 反之，左边界就是新栈定元素（这里额外-1就是减去这个offset的偏差）

                    ares = Math.max(ares,width*height); // 计算弹出栈顶元素柱子作为高度的最大面积（扩散的最大面积）
                }
                stack.add(ans); // 若当前栈顶为空或者指针元素比栈顶元素要大，则直接压入
            }

            // 当跳出循环时，若栈内仍然存在数据，则以每个栈顶元素为柱子高度，计算栈内的左右边界来得到宽度，更新最大面积
            // 如果当前栈顶元素比指针元素要大，则表示当前指针元素为右边界，以右边界计算栈内元素小于该有边界的面积
            while (!stack.isEmpty()){
                int height = heights[stack.pop()]; // 取出并记录当前高度

                if (!stack.isEmpty() && heights[stack.peek()] == height) stack.pop(); // 特殊情况：当新栈顶与取出的高度相同时，不需要直接跳过（删除新栈顶）

                int width;
                if (stack.isEmpty()) width = heights.length; // 特殊情况：若取出高度后恰好栈空，则左边界一定是数组最左侧，而右边界也一定是数组最右侧（因为最后一个一定是最小的那个，所以左右两边都可以触及）
                else width = heights.length - stack.peek() - 1; // 反之，左边界一定是新栈顶元素，而右边界一定是数组最右侧

                ares = Math.max(ares,width*height); // 计算弹出栈顶元素柱子作为高度的最大面积（扩散的最大面积）
            }
            return ares;
        }

        /**
         * 使用哨兵进行优化：
         *      1、在数组最前面添加一个0（没有任何高度小于他们），所以0就肯定是左边界，节省判空的情况
         *      2、在数组末尾最后添加一个0，当指针指向最右边肯定是右边界，并且0比任何高度都要小，在没有优化的情况下还要考虑指针指向最右侧时栈内仍有元素的情况
         * @param heights
         * @return
         */
        public int largestRectangleArea2(int[] heights) {
            if (heights.length == 0) return 0;
            if (heights.length == 1) return heights[0];
            Stack<Integer> stack = new Stack<>();
            int[] newHeights = new int[heights.length + 2];
            for (int i = 0; i < heights.length; i++) {
                newHeights[i+1] = heights[i]; // 给数组前后添加两个哨兵
            }
            heights = newHeights;
            int ares = 0;
            stack.push(0); // 直接往栈中添加0，然后指针从1开始计算，就避免走一趟for（其实加不加也影响不大）
            for (int ans = 1; ans < heights.length; ans++) { // ans指针维护当前柱子的高度
                // 如果当前栈顶元素比指针元素要大，则表示当前指针元素为右边界，以右边界计算栈内元素小于该有边界的面积
                while (heights[stack.peek()]>heights[ans]){
                    int height = heights[stack.pop()]; // 取出并记录当前高度
                    int width = ans - stack.peek() - 1;
                    ares = Math.max(ares,width*height); // 计算弹出栈顶元素柱子作为高度的最大面积（扩散的最大面积）
                }
                stack.add(ans); // 若当前栈顶为空或者指针元素比栈顶元素要大，则直接压入
            }
            return ares;
        }
    }
    /**
     * 思路1（暴力解法）：嵌套两层循环i、j，分别来控制面积的宽度，然后从两层循环中遍历最小高度，相乘得到从i到j的面积（不一定i到j中最大的面积，所以需要遍历所有i到j的可能性），时间复杂度为O(n^3)，，空间复杂度为O(1)
     * 思路2（辅助栈）：遍历所有柱子，以每一个柱子的高度作为矩形高度，宽度为该高度能够扩散的最大范围为宽度。然后通过遍历所有柱子得到该矩形的面积
     *              核心关键在于找到该高度的边界，可以使用栈来维护左边界，然后通过向右遍历找到右边界（所谓的边界其实就是小于左右两侧的柱子高度的下标）
     */
//leetcode submit region end(Prohibit modification and deletion)
}