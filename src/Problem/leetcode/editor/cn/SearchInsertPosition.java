//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为无重复元素的升序排列数组 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 1352 👎 0


package Problem.leetcode.editor.cn;
public class SearchInsertPosition{
    public static void main(String[] args){
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.search(new int[]{1, 3, 5, 6}, 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = (right + left)/2;
                if (nums[mid] > target) right = mid - 1;
                else if (nums[mid] < target) left = mid + 1;
                else return mid; // 插入到元素本身位置
            }
            return right + 1; // 或者返回left
        }
    }
    /**
     * 审题：nums 为无重复元素的升序排列数组；若数组中存在与target的数，则插入位置在该数的最前面的那位置；要求时间复杂度为O(logn)
     * 思路1：暴力遍历（时间复杂度为O(n)>O(logn)）
     * 思路2：类似于二分查找。时间复杂度为O(logn)
     *      插入的情况只有插入到所有元素前面、后面、中间和恰好是元素本身位置
     *      若num[mid]==target，则返回mid
     *      若num[mid]>target，则右边界左移：right = mid - 1
     *      若num[mid]<target，则左边界右移：left = mid + 1
     *      若没有找到该元素（直接跳出循环），返回right + 1 或 left
     * 思路3：
     */
//leetcode submit region end(Prohibit modification and deletion)

}