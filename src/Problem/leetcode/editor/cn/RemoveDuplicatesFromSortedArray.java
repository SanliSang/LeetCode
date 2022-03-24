//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 
// 👍 2431 👎 0


package Problem.leetcode.editor.cn;

/**
 * 删除有序数组的重复项
 */
public class RemoveDuplicatesFromSortedArray{
    public static void main(String[] args){
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = {0,0,1,2,2,3,4,4,5,6};
        System.out.println(solution.removeDuplicates(nums));
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int p = 0; // 前指针
            int q = 1; // 后指针
            while(q < nums.length){
                if(nums[p] != nums[q]){
                    if(q - p > 1){ // 优化点：可以使得不必要的原地赋值
                        nums[p + 1] = nums[q];
                    }
                    p++;
                }
                q++;
            }
            return p + 1; // 因为最后一层应该要满足循环中的if的，但是q已经跳出循环，所以需要补加一个1
        }

        public int removeDuplicates2(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int p = 0; // 前指针（维护需要插入的位置的前一个位置，第一位置不需要插入）
            int q = 1; // 后指针（遍历并和p进行判断是否需插入）
            // p和q的目的就是一致维护p和q的不同
            while (q < nums.length){
                if (nums[p] != nums[q]){ // q指针找到一个不同的元素就插入
                    nums[p+1] = nums[q]; // 这里为什么q+1因为q起始位置为0，而第一个位置肯定不需要插入时指针p需要+1
                    p++; // 插入后p指针后移一位，等待下一次插入
                }
                q++;
            }
            return p + 1;
        }
    }

    /**
     * 思路1（双指针）：比较 p 和 q 位置的元素是否相等。
     * 如果相等，q 后移 1 位
     * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
     * 重复上述过程，直到 q 等于数组长度。
     * 返回 p + 1，即为新数组长度。
     */

}