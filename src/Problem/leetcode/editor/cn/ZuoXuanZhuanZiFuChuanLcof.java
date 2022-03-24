//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 
// 👍 210 👎 0


package Problem.leetcode.editor.cn;

public class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args){
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            char[] array = s.toCharArray();
            int index = array.length-1;
            for (int i = n-1; i >= 0; i--) { // 外层控制每个需要移动的字符
                char c = array[i]; // 要移动的字符
                for (int j = i+1; j < array.length; j++) { //
                    array[j-1] = array[j];
                }
                array[index] = c;
                index--;
            }
            return new String(array);
        }

        public String reverseLeftWords2(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }
    /**
     * 审题：左反转：左边前n个字符反转到字符串的右边
     * 思路1：使用额外空间（对应字符拷贝过去即可）。时间复杂度O(n)，空间复杂度O(n)
     * 思路2：原地反转。前n个字符从后往前依次向后交换元素，直至达到对应位置。时间复杂度O(O^2)，空间复杂度O(1)
     * 思路3：切片后反转重组
     */
//leetcode submit region end(Prohibit modification and deletion)

}