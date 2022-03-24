//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1380 👎 0


package Problem.leetcode.editor.cn;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow2(new int[]{1,-1},1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            // 优化：初始队列压入第一个元素就可以不需要判空
            for (int i = 0; i < k; i++) {
                if (list.isEmpty()) list.add(i);
                else if (nums[list.getFirst()] < nums[i]) { // 弹出所有数，并压入nums[i]
                    list.clear();
                    list.add(i);
                } else { // 依次从队尾开始弹出比nums[i]还要小的元素
                    while (nums[list.getLast()] < nums[i]) list.pollLast(); // 弹出末尾元素
                    list.add(i);
                }
            }
            result[0] = nums[list.getFirst()]; // 建成窗口后压入窗口的最大元素
            int index = 1; // 维护当前窗口中最大数组的指针
            for (int i = k; i < nums.length; i++) {
//                if (list.size() >= k) list.poll(); // 弹出队头
                if (i-k+1 > list.getFirst()) list.poll(); // 若当前最大值已经脱离窗口，则要弹出最大值
                if (!list.isEmpty() && nums[list.getFirst()] < nums[i]) { // 清空队列，并添加nums[i]为最大值
                    list.clear();
                } else {
                    // 特别注意：等于时也不需要弹出
                    while (!list.isEmpty() && nums[list.getLast()] < nums[i]) list.pollLast(); // 弹出末尾元素
                }
                list.add(i);
                result[index++] = nums[list.getFirst()];
            }
            return result;
        }

        /**
         * 简略优化判空
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow2(int[] nums, int k) {
            if (nums.length == 1) return new int[]{nums[0]};
            LinkedList<Integer> list = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            // 优化：初始队列压入第一个元素就可以不需要判空
            list.add(0);
            for (int i = 1; i < k; i++) { // 从1开始判断（因为已经压入了第一个元素）
                if (nums[list.getFirst()] < nums[i]) { // 弹出所有数，并压入nums[i]
                    list.clear();
                } else { // 依次从队尾开始弹出比nums[i]还要小的元素
                    while (nums[list.getLast()] < nums[i]) list.pollLast(); // 弹出末尾元素
                }
                list.add(i);
            }
            result[0] = nums[list.getFirst()]; // 建成窗口后压入窗口的最大元素
            int index = 1; // 维护当前窗口中最大数组的指针
            for (int i = k; i < nums.length; i++) {
                if (i-k+1 > list.getFirst()) list.poll(); // 若当前最大值已经脱离窗口，则要弹出最大值
                if (!list.isEmpty() && nums[list.getFirst()] < nums[i]) { // 清空队列，并添加nums[i]为最大值
                    list.clear();
                } else {
                    // 特别注意：等于时也不需要弹出
                    while (!list.isEmpty() && nums[list.getLast()] < nums[i]) list.pollLast(); // 弹出末尾元素
                }
                list.add(i);
                result[index++] = nums[list.getFirst()];
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    /**
     * 思路1（暴力解法）：通过遍历窗口找到最大值
     *      时间复杂度：O(n*k)
     *      空间复杂度：O(1)
     * 思路2（队列或双端队列）：使用双端队列来维护当前窗口的最大值序列（从大到小），且需要判断最大值是否还在窗口中。
     *      1、建立窗口过程
     *          初始化双端队列，左右边界初始为0，只有右边界（i）向后移动，移动的同时维护队列队列从大到小，直到i=k-1时窗口建立完成，将当前队头加入最大值数组
     *      2、窗口移动过程
     *          i向后移动一位
     *              1.判断当前队列元素是否等于k，若等于k则弹出队头（表示队头离开窗口），否则继续向下判断
     *              2.比较nums[i]与当前队头（最大值）
     *                  若nums[i]大于队头则将队列当前所有元素弹出，nums[i]从队尾入队，
     *                  若nums[i]小于队头则需要依次从队尾弹出小于nums[i]的元素，然后将nums[i]从队尾入队（注意：等于队尾的元素不需要弹出）
     *                  （可以进一步优化代码行数，不需要判断队头与nums[i]大小，直接从末尾开始向队头判断即可，即使nums[i]比队头元素还要大，也是可以将数组清空的，达到同样的效果）
     *
     *              3.将当前队头加入最大值数组，每循环以上过程i++，直到i遍历到数组末尾结束该过程，返回最大值数组
     *
     */
}