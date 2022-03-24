//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 
// 👍 1411 👎 0


package Problem.leetcode.editor.cn;
public class MoveZeroes{
    public static void main(String[] args){
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes4(new int[]{0,1,0,3,12});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
            // 双指针
        public void moveZeroes(int[] nums) {
            int j = 0; // j负责维护从左到右首个0位置
            for (int i = 0; i < nums.length; i++) { // i负责遍历寻找非0元素
                if (nums[j] != 0) j++; // 当j位置元素不为0时，需要继续往后移一位，直至找到0
                else { // 当j为0时，判断i是否为非0，当i也是非0时，就交换j与i元素，并将j继续往前寻找0
                    if (nums[i] != 0){
                        nums[j] = nums[i];
                        nums[i] = 0;
                        j++; // 最后记得j后移（其实影响不大）
                    }
                }
            }
        }
        // 两次遍历
        public void moveZeroes2(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) nums[i-j] = nums[i];
                else j++;
            }

            for (int k = nums.length-1; k <= nums.length-j; k--) { // 注意边界问题，不要多或少补0，要拿捏准确
                nums[k] = 0; // 补0
            }
        }

        //（三刷）双指针实现
        public void moveZeroes3(int[] nums) {
            // i指针负责遍历，j指针维护正确的位置（将0移动到末尾）
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (nums[i] != 0){
//                    swap(nums,i,j);
                    if (i != j){
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }

        public void moveZeroes4(int[] nums) {
            int p = 0; // 维护正常的位置
            int q = 0; // 遍历，判断是否需要插入
            while (q < nums.length){
                if (nums[q] != 0){
                    nums[p] = nums[q];
                    p++;
                }
                q++;
            }
            System.out.println(p);
            // 从末尾赋值0
            for (int i = p; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        private void swap(int[] nums , int i , int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//    思路1(双指针)：j维护0元素，i指针维护非0元素，j遇到0元素时就停下来且判断i是否为非0元素，如果是，则交换两者元素，否则就继续等待i后移找到非0元素再判断交换
//    思路2（两次遍历）：j维护出现0元素的个数，遍历i指针，判断i指针是否指向0，若指向0则j++，且i后移一位，若i不指向0则表示i位置元素前进j位
}