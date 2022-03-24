//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 503 👎 0


package Problem.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IntersectionOfTwoArrays{
    public static void main(String[] args){
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        solution.intersection(new int[]{1,2,2,1},new int[]{2,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int[] arr = new int[1001];
            int index = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                if (arr[nums1[i]] == 0){
                    arr[nums1[i]]++; // 如果已经是大于0的，不可以继续重复计数
                }
            }
            for (int i = 0; i < nums2.length; i++) {
                if (arr[nums2[i]] == 1){
                    list.add(nums2[i]);
                    arr[nums2[i]]--;
                }
            }
            int[] result = new int[list.size()];
            for (Integer integer : list) {
                result[index++] = integer;
            }
            return result;
        }
    }
    /**
     * 审题：返回交集的数组每个数都是唯一的，没有顺序要求
     * 思路1：使用数组来记录数组出现的个数（因为要求返回结果的数组是唯一的，只要没有出现过就是+1，否则不需要再+1）。
     *      先记录nums1的数，然后减去num2的数（不唯0的表示）
     * 思路2：使用set自动去重。先将所有num1的数都放入set自动去重，然后判断num2是否存在set内，若存在则添加到另一个记录交集结果的set中，然后取出另一个set的所有结果
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}