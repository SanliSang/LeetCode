//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
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
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 num
//s = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1182 👎 0


package Problem.leetcode.editor.cn;
public class RemoveElement{
    public static void main(String[] args){
        Solution solution = new RemoveElement().new Solution();
        solution.removeElement(new int[]{1,2,2,3,5,6,3,2,4},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0; // 慢指针，维护下一个应该正确插入的值
            int fast = 0; // 快指针，遍历判断每个数值，不等于val，就需要将该值插入到维护正确的指针slow上
            while (fast < nums.length){ // 快指针先到达数组末尾则表示遍历完成
                if (nums[fast] != val) { // 若出现不相等的数值，就需要将该数值插入到维护正确位置slow中
                    nums[slow] = nums[fast];
                    slow++; // 慢指针继续前
                }
                fast++; // 遇到相等的值需要删除，所以不能将该值放在slow中，只有快指针后移
            }
            return slow; // 每次遇到不等于val的数，slow++，所以实际数组最后长度为slow
        }

        public int removeElement2(int[] nums, int val) {
            int slow = 0;
            int fast = 0;
            int len = nums.length;
            while (fast < len){
                if (nums[fast]!=val){
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }

    /**
     * 审题：要求原地修改输入数组，空间复杂度O(1)，被删除的后面的数要往前挪，最后面可以为任意数，0 <= val <= 100
     * 思路1：暴力删除。时间复杂度为O(n^2)，每次删除一个数就将剩下所有的数遍历都往前挪所以复杂度为O(n^2)
     * 思路2：快慢指针（双指针）。使用slow维护正确插入的位置，而fast指针遍历找到需要删除的值
     *      初始两个指针都为0，当fast指针没有遇到val时，slow指针和fast指针都往前移动，若fast遇到val时，slow指针停留，并与fast进行交换
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}