//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 3064 👎 0


package Problem.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater{
    public static void main(String[] args){
        Solution solution = new TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int area = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                    int bottom = stack.pop(); // 取出底部
                    if (stack.isEmpty()) break; // 表示没有左边界
                    int left = stack.peek();
                    int height_length = Math.min(height[left],height[i]) - height[bottom];
                    int width = i - left - 1;
                    area += height_length*width;
                }
                stack.add(i);
            }
            return area;
        }
            /**
             * 思路1（单调栈）：和之前找到最大的矩形面积的思路相似，需要利用单调栈来维护左边界的柱子
             *      单调栈的作用：栈中存储柱子高度下标，且从栈底到栈顶是递减的高度。
             *      在遍历的时候，遇到比栈顶元素要高的柱子时，就说明栈顶元素可以作为底部弹出，新栈顶元素可以作为左边界与遍历遇到的那个柱子高度作为右边界形成低洼。（这也说明栈至少有两个元素和遇到比栈顶更大的元素就可构成低洼）
             *      而栈内存储高度下标就是为了方便获取低洼的长度与直接获取柱子的高度。
             *
             *      执行过程：
             *          1、遍历height数组，首先判断栈是否为空，若栈空则直接将遇到height[i]压入栈内，继续遍历
             *          2、栈不为空且栈顶元素小于遍历遇到的height[i]，取出栈顶元素bottom，并且判断新栈顶元素left是否为空，
             *              1.若为空，跳出（因为缺少新栈顶作为左柱子），继续循环数组
             *              2.若不为空，则不需要以新栈顶为低洼底部高度，height[left]作为左边界，height[i]作为右边界，宽度为 i-left-1，高度为 min{height[i],height[left]} - height[bottom]
             *              3.将面积计算并累加
             *              4.以上操作需要循环，因为当栈内存在超过2个元素时，表示栈内还有能够与height[i]形成低洼的左边界，直至栈内只有1个元素或栈空时，结束内循环，继续遍历数组
             */
        }
    //leetcode submit region end(Prohibit modification and deletion)

    }