//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228 
// 
// Related Topics 数组 哈希表 
// 👍 511 👎 0


package Problem.leetcode.editor.cn;

import java.util.HashMap;

public class FourSumIi{
    public static void main(String[] args){
        Solution solution = new FourSumIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            /**
             * 将a+b的所有情况都记录到哈希表中，若出现a+b的结果相同，则该结果的次数+1
             */
            for (int a : nums1) {
                for (int b : nums2) {
                    if (map.containsKey(a+b)){
                        map.put(a+b,map.get(a+b)+1); // 取出a+b，然后计数累加1
                    }else {
                        map.put(a+b,1); // 之前没有出现过则计数为1
                    }
                }
            }
            int result = 0;
            /**
             * 将-(c+d)匹配哈希表中a+b的所有情况，若满足a+b=-(c+d)表示满足四数之和条件，取出之前a+b的所有计数
             */
            for (int c : nums3) {
                for (int d : nums4) {
                    // 因为a+b = -(c+d)，所以需要找到满足-(c+d)的一组计数
                    if (map.containsKey(-(c+d))){
                        result+=map.get(-(c+d));
                    }
                }
            }
            return result;
        }
    }
    /**
     * 审题：返回满足nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0的次数
     * 思路1：暴力枚举
     * 思路2：分组+哈希表。将nums1和nums2为一组，nums3和nums4为一组。先计算nums1[i]和nums2[j]出现结果的次数，并将该次数存入哈希表中（键为nums[i]+nums[j]）
     */
//leetcode submit region end(Prohibit modification and deletion)

}