//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4251 👎 0


package Problem.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args){
        Solution solution = new ThreeSum().new Solution();
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < nums.length-2; i++) {
                for (int j = i+1; j < nums.length-1; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[i]+nums[j]+nums[k] == 0){
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(list); // 注意添加数据的使用不重复的列表进行添加
                        }
                    }
                }
            }
            return lists;
        }

        public List<List<Integer>> threeSum2(int[] nums) {
            Arrays.sort(nums);
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (int k = 0 ; k < nums.length-2; k++) {
                if(nums[k] > 0) break;
                if(k > 0 && nums[k] == nums[k - 1]) continue;

                int i = k + 1, j = nums.length - 1;
                while (i<j){
                    int s  = nums[i]+nums[j]+nums[k];
                    if (s > 0){
                        while (i < j && nums[j] == nums[--j]);
                    } else if (s < 0){
                        while (i < j && nums[i] == nums[++i]);
                    } else {
                        lists.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while (i < j && nums[i] == nums[++i]);
                        while (i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return lists;
        }

        public List<List<Integer>> threeSum3(int[] nums) {
            Arrays.sort(nums); // 进行排序
            List<List<Integer>> list = new LinkedList<>();

            for (int k = 0; k < nums.length - 2; k++) { // k最多可以遍历到倒数第三个数
                if (nums[k]>0) return list;
                if (k > 0 && nums[k] == nums[k]-1) continue;

                int i = k+1; // 左指针
                int j = nums.length-1; // 右指针
                while (i<j){
                    int s = nums[i] + nums[j] + nums[k];
                    if (s>0){ // 结果偏大，右指针左移
                        while (i < j && nums[j] == nums[--j]); // 若右指针和右指针的左边一位指针相同，则右指针可以继续左移（防止重复记录右指针）
                    }else if (s<0){ // 结果偏小，做指针右移
                        while (i < j && nums[i] == nums[++i]); // 若左指针和左指针的右边一位相同，则左指针可以继续向有移动
                    }else {
                        ArrayList<Integer> arr = new ArrayList<>(3);
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        list.add(arr);
                        while (i < j && nums[i] == nums[++i]); // 继续去重
                        while (i < j && nums[j] == nums[--j]); // 继续去重
                    }
                }
            }
            return list;
        }


        public List<List<Integer>> threeSum4(int[] nums) {
            // 1. 从小到大排序，这一步对去重操作有妙用
            // 2. 定义三个指针，使得 nums[a] + nums[b] = -nums[c]，其中c指针在数组前面，ab指针在c指针后面（理论上，a的范围：0~nums.length-3，b的范围：1~nums.length-2，c的范围：2~num.length-1）
                // 当nums[c]>0时，可以推断没有a和b可以满足公式，直接退出返回（因为nums[a]和nums[b]一定是正数）
                // 当nuns[c]<0时，左边界指针a和右边界指针b向中间靠拢（靠拢的过程需要nums[a]和nums[b]去重，否则指针下一次移动时候会将重复的数值添加到列表中），当满足公式时，将该数值添加到列表中
                // 找到一组a、b、c以后，nums[c]也要去重
            // 3. 返回列表

            List<List<Integer>> list = new LinkedList<>();
            Arrays.sort(nums);
            for (int c = 0; c < nums.length - 2; c++) {
                if (nums[c] > 0) return list;
                if (c > 0 && nums[c] == nums[c]-1) continue; // 去重，此处的c>0是为了防止c-1指针越界

                int a = c+1; // 左边界指针
                int b = nums.length-1; // 右边界指针
                while (a < b){
                    int result = nums[a] + nums[b];
                    if (result < nums[c]){ // 左指针右移
                        while (a < b && nums[a] == nums[++a]); // 去重
//                        a++; // 此时的nums[a]肯定不是重复的那一个
                    }else if (result > nums[c]){ // 右指针左移
                        while (a < b && nums[b] == nums[--b]); // 去重
//                        b--;
                    }else { // 找到满足公式的a b c
                        ArrayList<Integer> arr = new ArrayList<>(3);
                        arr.add(nums[a]);
                        arr.add(nums[b]);
                        arr.add(nums[c]);
                        list.add(arr);
                        while (a < b && nums[a] == nums[++a]); // 去重
                        while (a < b && nums[b] == nums[--b]); // 去重
                    }
                }
            }
            return list;
        }

    }
    /**
     * 思路1（暴力枚举）：嵌套三层循环时间复杂度高
     * 思路2（哈希表）：
     * 思路3（双指针）：
     *      1、进行排序
     *      2、k表示第三个指针可以理解成target指针（num[i] + num[j] == -num[k]），初始k指针在最左侧；i，j指针在 k~num.length 范围移动
     *      3、当num[k]>0时，肯定不满足式子（因为数组已经排序过，k为最小值，若k为正数，则i和j肯定为正数，所以必定不满足该公式），直接退出；
     *         当k>0（因为若k==0时，nums[k+1]就会空指针）且num[k]==num[k-1]时，跳过num[k]，防止得到重复的组合（因为nums[k]、nums[k-1]可能会和nums[i]、nums[j]进行匹配，从而导致记录重复的一组数据）
     *         当i<j时循环以下
     *          1. 当num[i] + num[j] + num[k]<0时（需要选择更大的num[j]得到0），i+=1 （因为已经排好序，我们的目的就是让i与j的指针逼近0得到组合）
     *          2. 当num[i] + num[j] + num[k]>0时，（需要选择更小的num[i]得到0），j-=1
     *          3. 当num[i] + num[j] + num[k]==0时，表示获取一组i、j、k，该值放入列表中，然后i+=1，j-=1，继续循环，直至i>j为止，表示找到所有以k为target的组合，k+=1然后重复以上步骤
     */
}