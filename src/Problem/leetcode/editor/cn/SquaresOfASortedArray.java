//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 434 👎 0


package Problem.leetcode.editor.cn;

import java.util.Stack;

public class SquaresOfASortedArray{
    public static void main(String[] args){
        Solution solution = new SquaresOfASortedArray().new Solution();
//        solution.sortedSquares(new int[]{-2,-1,0,3,5,7,9});
        solution.sortedSquares(new int[]{0,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            Stack<Integer> positiveStack = new Stack<>();
            Stack<Integer> negativeStack = new Stack<>();
            int i = nums.length - 1;
            while (i >= 0 && nums[i] >= 0){
                positiveStack.push(nums[i]*nums[i]);
                i--;
            }

            int j = 0;
            while (j <= i){
                negativeStack.push(nums[j]*nums[j]);
                j++;
            }

            int k = 0;
            while (k < nums.length){
                if (positiveStack.isEmpty()) nums[k++] = negativeStack.pop();
                else if (negativeStack.isEmpty()) nums[k++] = positiveStack.pop();
                else if (positiveStack.peek() < negativeStack.peek()) nums[k++] = positiveStack.pop();
                else nums[k++] = negativeStack.pop();
            }
            return nums;
        }

        public int[] sortedSquares2(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            int k = nums.length-1;
            int[] tempArr = new int[nums.length];
            while (left <= right){
                int leftNum = nums[left]*nums[left];
                int rightNum = nums[right]*nums[right];
                if (leftNum < rightNum) {
                    tempArr[k--] = rightNum;
                    right--;
                }else {
                    tempArr[k--] = leftNum;
                    left++;
                }
            }
            return tempArr;
        }
    }
    /**
     * 审题：nums 已按非递减顺序排序，进行平方后的数也要求非递减顺序排序
     * 思路1：两个栈。第一个栈从nums末尾开始，维护nums数组中所有正数和零的平方（压栈），另一个栈从nums队头开始，维护nums数组中所有负数的平方
     *      将所有数计算得到平方后压入栈内，然后根据两个栈顶取出较小的数形成新的非递减顺序数组排序，直至某一个栈空时直接将该栈的元素全部放入到该数组
     * 思路2：思路1的改进方案：使用两个指针代替栈，因为负数相乘等于正数，数组所有数平方后就变成两头高而中间低的情况，所以我们可以对数据排序从大到小，
     *      从两端较高的数先开始比较维护，直至两个指针相遇，就构成了非递减顺序排序的数组
     * 总结：有关匹配（消除）问题都是栈的强项，对于有次序的数组都可以优先考虑双指针的方式，其中双指针包括快慢指针，相遇指针等等
     */
//leetcode submit region end(Prohibit modification and deletion)

}