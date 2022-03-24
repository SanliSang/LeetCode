//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
// Related Topics 栈 双指针 字符串 模拟 
// 👍 366 👎 0


package Problem.leetcode.editor.cn;
public class BackspaceStringCompare{
    public static void main(String[] args){
        Solution solution = new BackspaceStringCompare().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            StringBuilder ss = new StringBuilder();
            StringBuilder ts = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c != '#'){
                    ss.append(c);
                }else if (ss.length()>0){
                    ss.deleteCharAt(ss.length()-1);
                }
            }

            for (char c : t.toCharArray()) {
                if (c != '#'){
                    ts.append(c);
                }else if (ts.length()>0){
                    ts.deleteCharAt(ts.length()-1);
                }
            }

            return ss.toString().equals(ts.toString());
        }
    }
    /**
     * 审题：s 和 t 只含有小写字母以及字符 '#'；要求时间复杂度O(n)，空间复杂度O(1)
     * 思路1：快慢指针（双指针）。类似与移动零的做法，遍历
     */
//leetcode submit region end(Prohibit modification and deletion)

}