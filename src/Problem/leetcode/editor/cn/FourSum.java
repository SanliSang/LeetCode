//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1155 👎 0


package Problem.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum{
    public static void main(String[] args){
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum2(new int[]{2, 2, 2, 2, 2}, 8));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> list = new LinkedList<>();
            // 将c和d作为合并成同一个指针index，并将条件满足式改成nums[a]+nums[b] == target-(nums[c]+nums[d])
            for (int c = 0; c < nums.length - 3; c++) {
                if (c > 0 && nums[c] == nums[c-1]) continue; // 保证c也是改变的
                for (int d = c + 1; d < nums.length-2; d++) {
                    int index = target-(nums[c]+nums[d]);
//                    if (index > 0) return list; // index之后的都a和b都不可能满足条件了，所以可以直接返回
                    if(d > c + 1 && nums[d]==nums[d-1]) continue; // 若当前d指针和d指针的右一位相等，则直接跳过排除重复元素
                    int a = d+1; // 左指针
                    int b = nums.length-1; // 右指针
                    while (a < b){
                        int s = index - nums[a] + nums[b];
                        if (s < 0){ // 说明右指针过大，需要往左移动
                            b--;
//                            while (a < b && nums[b] == nums[b-1]) b--; // 排除重复
                        }else if (s > 0){ // 说明左指针过小，需要向右移动
                            a++;
//                            while (a < b && nums[a] == nums[a+1]) a++;
                        }else { // 表示恰好找到满足该式子指针序列
                            list.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                            while (a < b && nums[a] == nums[a+1]) a++; // 继续去重
                            while (a < b && nums[b] == nums[b-1]) b--;
                            a++;
                            b--;
                        }
                    }
                }
            }
            return list;
        }

        // 二刷
        public List<List<Integer>> fourSum2(int[] nums, int target) {
            // 总体思路和三数之和显示，因为多了一个变量d，所以在遍历c的时候需要多套一层循环d，c由d决定
            // nums[a] + nums[b] = target - (nums[c] + nums[d])
            Arrays.sort(nums);
            List<List<Integer>> list = new LinkedList<>();
            // 将c和d作为合并成同一个指针index，并将条件满足式改成nums[a]+nums[b] == target-(nums[c]+nums[d])
            for (int c = 0; c < nums.length - 3; c++) { // 多套一层循环来控制nums[c]
                if (c > 0 && nums[c] == nums[c-1]) continue; // 保证c也是改变的
                for (int d = c + 1; d < nums.length-2; d++) {
                    int index = target-(nums[c]+nums[d]);
                    // if (index > 0) return list;
                    if(d>c+1&&nums[d]==nums[d-1]) continue; // 若当前d指针和d指针的右一位相等，则直接跳过排除重复元素

                    int a = d+1; // 左指针
                    int b = nums.length-1; // 右指针
                    while (a < b){
                        int s = index - (nums[a] + nums[b]);
                        if (s < 0){ // 说明右指针过大，需要往左移动
                            b--;
                            // while (a < b && nums[b] == nums[b-1]) b--;
                        }else if (s > 0){ // 说明左指针过小，需要向右移动
                            a++;
                            // while (a < b && nums[a] == nums[a+1]) a++;
                        }else { // 表示恰好找到满足该式子指针序列
                            list.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                            while (a < b && nums[a] == nums[a+1]) a++; // 继续去重
                            while (a < b && nums[b] == nums[b-1]) b--;
                            a++;
                            b--;
                        }
                    }
                }
            }
            return list;
        }
    }
    /**
     * 审题：结果队列中可以存在乱序的nums结果，但是每个队列中nums出现的次数不可以重复。
     *      和四数之和II不同的是，该题需要记录每个满足条件的元素下标为位置，而不是满足条件出现的次数
     * 思路1：（排序+双指针）和三数组之和做法类似，只是需要多套一层指针作为新的target，nums[a]和nums[b]分别作为左右指针（从两侧向中间靠近），其他思路基本和三数之和类似
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}