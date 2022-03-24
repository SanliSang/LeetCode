//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1458 👎 0


package Problem.leetcode.editor.cn;
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args){
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 边界优化
            if (nums.length==0 || nums[0]>target || nums[nums.length-1]<target) return new int[]{-1,-1};

            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = (right + left)/2;
                if (nums[mid] > target) right = mid - 1;
                else if (nums[mid] < target) left = mid + 1;
                else {
                    int l = mid;
                    int r = mid;
                    while (l > 0 && nums[l-1] == nums[mid]) l--; // 向左遍历
                    while (r < nums.length-1 && nums[r+1] == nums[mid]) r++; // 现有遍历
                    return new int[]{l,r};
                }
            }
            return new int[]{-1,-1};
        }

        public int[] searchRange2(int[] nums, int target) {
            int leftBorder = getLeftBorder(nums, target);
            int rightBorder = getRightBorder(nums, target);
            // 情况一
            if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
            // 情况三
            if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
            // 情况二
            return new int[]{-1, -1};
        }

        int getRightBorder(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
            while (left <= right) {
                int middle = left + ((right - left) / 2);
                if (nums[middle] > target) {
                    right = middle - 1;
                } else { // 寻找右边界，nums[middle] == target的时候更新left
                    left = middle + 1;
                    rightBorder = left;
                }
            }
            return rightBorder;
        }

        int getLeftBorder(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
            while (left <= right) {
                int middle = left + ((right - left) / 2);
                if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                    right = middle - 1;
                    leftBorder = right;
                } else {
                    left = middle + 1;
                }
            }
            return leftBorder;
        }

    }
    /**
     * 审题：nums是非递减数组，存在重复元素；要求使用O(logn)时间复杂度解决
     * 思路1：暴力遍历。时间复杂度O(n)
     * 思路2：二分查找+遍历。改动部分就是当找到target时，就从mid左右两边开始遍历寻找两端边界，找到后返回该边界，如果没有找到target，则返回[-1,-1]。
     *      最差情况为整个数组都是target，二分查找没用，直接遍历左右两端，时间复杂度为O(n)
     *      最好情况为第一次mid就是target，时间复杂度为O(1)
     *
     * 思路3：两个二分查找+特殊情况排除。对于二分查找，必须满足数组有序的前提下，当若数组出现重复元素，
     *      则使用二分法查找出来的元素不一定是target之中第一个元素，但是可以使用记录边界的方式，
     *      继续使用二分查找（而不是直接返回），每当可能出现其他target时，最后一次记录肯定是边界，当满足nums[mid]==target时，而是继续更新边界，
     */
//leetcode submit region end(Prohibit modification and deletion)

}