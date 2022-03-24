//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 895 👎 0


package Problem.leetcode.editor.cn;
public class Sqrtx{
    public static void main(String[] args){
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt2(2147395599));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;
            int left = 1;
            int right = x;
            while (right - left >= 0) {
                int mid = left + (right - left) / 2;
                if (mid > x/mid) right = mid - 1; // mid^2大于x的数肯定不是我们要找的
                else { // 如果mid^2小于x的数时有可能是我们要找的数
                    if ((mid+1) > x/(mid+1)) return mid; // 消除小数点
                    left = mid + 1;
                }
            }
            return 0;
        }
        public int mySqrt2(int x) {
            if (x == 0 || x == 1) return x;
            int left = 1;
            int right = x;
            int ans = -1;
            while (right - left >= 0) {
                int mid = left + (right - left) / 2;
                if (mid > x/mid) right = mid - 1; // mid^2大于x的数肯定不是我们要找的
                else { // 如果mid^2小于x的数时有可能是我们要找的数
                    ans = mid;
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
//
//    class Solution {
//
//        public int mySqrt(int x) {
//            // 特殊值判断
//            if (x == 0) {
//                return 0;
//            }
//            if (x == 1) {
//                return 1;
//            }
//
//            int left = 1;
//            int right = x / 2;
//            // 在区间 [left..right] 查找目标元素
//            while (left < right) {
//                int mid = left + (right - left + 1) / 2;
//                // 注意：这里为了避免乘法溢出，改用除法
//                if (mid > x / mid) {
//                    // 下一轮搜索区间是 [left..mid - 1]
//                    right = mid - 1;
//                } else {
//                    // 下一轮搜索区间是 [mid..right]
//                    left = mid;
//                }
//            }
//            return left;
//        }
//    }
        /**
         * 审题：若出现小数点则舍弃小数点；0 <= x <= 2^31 - 1
         * 思路1：暴力枚举。时间复杂度为O(n^(1/2))
         * 思路2：二分法。通过二分查找得到的数和自己进行相乘比较x，来判断左右边界
         *      注意点：当出现x的数值很大时，mid^2很有可能会导致数值溢出，所以可以使用x/mid和mid进行比较可以避免数值溢出
         *
         */

}