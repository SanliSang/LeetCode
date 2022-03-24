//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 
// 👍 649 👎 0


package Problem.leetcode.editor.cn;
public class BinarySearch{
    public static void main(String[] args){
        Solution solution = new BinarySearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 左闭右闭的版本
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            // 当左指针小于右指针时还有可能再该范围内找到target元素
            while (left <= right){ // 注意：当左右边界的值相等时，还有可能该边界值就是目标值，所以需要写上等于号
                int mid = (right + left)/2;
                if (nums[mid] > target) right = mid - 1; // 目标值过小，target在mid与左边界的区域上，右边界变成mid-1
                else if (nums[mid] < target) left = mid + 1; // 目标值过大，target在mid与右边界的区域上，左边界变成mid+1
                else return mid; // 满足条件
            }
            return 0; // 没找到该数值
        }
        // 思路1：二分查找。通过维护左右边界指针，计算边界中间元素和目标target元素的比较来缩小指针边界，直至找到该元素位置。
        // 思路2：递归。查找的过程中，存在最小可重复单元，也就是计算mid和比较target的过程，且必须一层一层往下深入
    }
//leetcode submit region end(Prohibit modification and deletion)

}