//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 953 👎 0


package Problem.leetcode.editor.cn;
public class MinimumSizeSubarraySum{
    public static void main(String[] args){
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 以下是没审对题，这里的连续不是数组中数值的连续，而是数组连续，也就是说不要求这里的数一定是+1递增或-1递减的
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLen(int target, int[] nums) {
            int len = Integer.MAX_VALUE; // 维护满足target且连续段中最长的那个段的长度
            for (int i = 0; i < nums.length; i++) {
                int size = 1;
                int increment = nums[i];
                int decrease = nums[i];
                while (i+1 < nums.length && nums[i] + 1 == nums[i+1]){ // 递增段
                    increment +=nums[i+1];
                    size++;
                    i++;
                    if (increment >= target){
                        len = Math.min(len,size);
                        break;
                    }
                }
                size = 1; // size重新清空
                while (i+1 < nums.length && nums[i] - 1 == nums[i+1]){ // 递减段
                    decrease += nums[i+1];
                    size++;
                    i++;
                    if (decrease >= target){
                        len = Math.min(len,size);
                        break;
                    }
                }
                // 执行到此处说明该数自己就是一个段
                if (nums[i] >= target) len = Math.min(len,1);
            }
            if (len == Integer.MAX_VALUE) return 0;
            else return len;
        }

        public int minSubArrayLen2(int target, int[] nums){
            int len = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                int size = 0;
                for (int j = i; j < nums.length; j++) {
                    sum+=nums[j];
                    size++;
                    if (sum >= target){
                        len = Math.min(size,len);
                        break;
                    }
                }
            }
            return len == Integer.MAX_VALUE ? 0 : len;
        }

        public int minSubArrayLen3(int target, int[] nums){
            int len = Integer.MAX_VALUE;
            int sum = 0; // 最小连续数值之和
            int i = 0; // 窗口起始位置
            int subLen = 0; // 窗口大小
            for (int j = 0; j < nums.length; j++) { // 窗口末尾负责遍历
                sum+=nums[j];
                while (sum>=target){ // 找到满足条件的连续数组，进行更新操作（移动窗口初始位置，更新窗口大小），不断循环来压缩宽口
                    subLen = j - i + 1; //计算窗口大小
                    len = Math.min(len,subLen);
                    sum-=nums[i++]; // 这里就是窗口移动的精髓，窗口起始位置移动，且维护了窗口内的数值，这样就可保证不会找到多余的连续数组，
                    // 因为如果sum累加了很大的nums[j]远远超出target，那么就需要不断缩减起始位置
                }
            }
            return len == Integer.MAX_VALUE ? 0 : len;
        }
    }
    /**
     * 审题：找出的数组累加要>=target，要求找出的最小数组是连续的（数组连续而非数值连续），相等不是连续
     * 思路1：暴力解法。直接两层for遍历，一旦找到>=target的数值就直接break，然后继续从下一个数开始累加计算，时间复杂度O(n^2)
     * 思路2：滑动窗口（双指针）。
     */
//leetcode submit region end(Prohibit modification and deletion)

}