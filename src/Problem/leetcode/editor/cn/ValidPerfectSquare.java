//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 349 👎 0


package Problem.leetcode.editor.cn;
public class ValidPerfectSquare{
    public static void main(String[] args){
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(39));
        System.out.println(Math.sqrt(39));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 0 || num == 1) return true;
            int left = 0;
            int right = num;
            while (right - left >= 0) {
                int mid = left + (right - left) / 2;
                if (mid > num/mid) right = mid - 1;
                else if (mid < num/mid) left = mid + 1;
                else return num % mid == 0; // 因为int的进度差异，即使找到了平方根，但是不保证该平方根是否存在小数点，所以要求余判断是否存在小数点
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}