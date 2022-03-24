//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2945 👎 0


package Problem.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args){
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("{[]}");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length()%2 != 0) return false;
            char[] left = {'(','{','['};
            char[] right = {')','}',']'};
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (containsLeft(left,c)){
                    stack.push(c);
                    continue;
                }
                if (stack.empty()) return false;
                Character peek = stack.peek();
                if (index(left,peek) != index(right,c)){
                    return false;
                }
                stack.pop(); // 弹出栈顶元素
            }
            if (stack.empty()) return true;
            else return false;
        }

        public boolean containsLeft(char[] left , char c){
//            char[] left = {'(','{','['};
            for (int i = 0; i < left.length; i++) {
                if (c == left[i]) return true;
            }
            return false;
        }

        public int index(char[] chars , char c){
            for (int i = 0; i < chars.length; i++) {
                if (c==chars[i]) return i;
            }
            return -1;
        }

        /**
         * 最优解：使用两个栈辅助
         * @param s
         * @return
         */
        public boolean isValid2(String s){
            if (s == null || s.isEmpty()) return true;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                // 这里压入有括号的原因其实就是：左括号都不满足的情况下，直接匹配右括号时不需要括号类型对应匹配
                // 因为已经在左括号前面提前压入右括号，也就是栈中根据左括号只留下正确类型的右括号，
                // 相比于正常的将所有括号压入栈的写法，将左括号也压入栈内，当遇到右括号时，寻找对应的左括号就麻烦（需要遍历所有括号类型，当括号类型特别多的时候效率会因为遍历而下降）
                if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');
                else if (c == '(') stack.push(')');
                // 若以上三条if均不满足，则表示c为右括号
                else if (stack.isEmpty() || stack.pop() != c) return false;
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路1（栈实现）：取出每一个字符串的括号，将括号压入栈
 *      1、判断压入的括号是若左括号，将直接压入栈
 *      2、若压入栈的括号是右括号，判断栈顶元素是否为空，再判断栈顶元素括号种类是否是匹配，若匹配则弹出栈顶的右括号
 */
}