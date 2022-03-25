//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 字符串 
// 👍 352 👎 0


package Problem.leetcode.editor.cn;

import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args){
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        System.out.println(solution.removeDuplicates2("abbaca"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 审题错误：实现了删除所有相同项，而不是两两消除
        public String removeDuplicates(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); ) {
                if (stack.isEmpty()){
                    stack.push(s.charAt(i));
                    i++;
                }
                else {
                    if (s.charAt(i) == stack.peek()){
                        Character peek = stack.peek();
                        while (i < s.length() && s.charAt(i) == peek) i++;
                        stack.pop(); // 删除和peek相等的元素
                    }
                    else{
                        stack.push(s.charAt(i));
                        i++;
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()){
                builder.append(stack.pollLast()); // 注意不可以直接弹出，需要反转
            }
            return builder.toString();
        }


        public String removeDuplicates2(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) stack.push(c);
                else if (stack.peek() == c) {
                    stack.pop();
                }else stack.push(c);
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()){
                stringBuilder.append(stack.pollLast());
            }
            return stringBuilder.toString();
        }
    }

    /**
     * 思路：消除所有相同的项，消消乐
     * 思路：使用栈。
     *      1.当前栈为空，直接压入元素
     *      2.栈不为空
     *          1、匹配当前元素和栈顶元素：若不相等则压入，相等则循环跳过忽略直至s为空或遇到不同于栈顶的元素，然后弹出当前栈顶元素
     *          2、当s为空时，当前栈内元素就是需要返回的字符串
     *
     *
     * 正确思路：遇到相邻的就消除，若出现三个则相邻则前两个消除，只留下第三个
     */
//leetcode submit region end(Prohibit modification and deletion)

}