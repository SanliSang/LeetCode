//给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 
// 👍 1298 👎 0


package Problem.leetcode.editor.cn;
public class RotateArray{
    public static void main(String[] args){
        Solution solution = new RotateArray().new Solution();
        int arr[] = {1,2,3,4,5,6,7};
        solution.rotate3(arr,3);
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int[] arr = new int[nums.length];
            int len = arr.length;
            for (int i = 0; i < arr.length; i++) {
                arr[(i+k)%len] = arr[i];
            }
            System.arraycopy(arr,0,nums,0,len);
        }
        public void rotate2(int[] nums, int k) {
            int[] arr = new int[nums.length];
            int index = 0+k%nums.length;
            int p = nums.length-index;
            int q =
                    arr[index] = nums[0];
            for (int i = index+1; i < nums.length; i++) {
                arr[i] = nums[index+i];
            }
            for (int j = 0; j < index-1; j++) {

            }
        }

        public void rotate3(int[] nums, int k) {
            int temp = 0;
            for (int i = 0; i < k; i++) { // 负责循环次数
                do {
                    int x = (temp+k)%nums.length;
                    swap(nums,x,temp);
//                    nums[x] = nums[temp];
                    temp = x;
                }while (temp!=i);
            }
        }

        public void swap(int[] arr , int i , int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    /**
     * 思路1（暴力解法）：给出长度相等的空数组，对nums中每一个数字都使用求余的方式直接计算得到其最终位置
     * 思路2（记录相对位置）：因为数组每个元素之间的相对位置都是不变的，变的是它们所在数组的下标位置。
     *      初始取定第一个元素nums[0]为target，计算target元素轮转后最终得到的位置，然后计算从该位置到数组末尾的长度为p，
     *      将源数组target后长度p的所有元素直接拷贝到新数组内，然后计算该位置到数组头部的长度为q，同理将源数组target前长度为q的所有元素拷贝到新数组内
     * 思路3（环形替换，较难理解，但空间复杂度可以降到O(1)）：
     */
}