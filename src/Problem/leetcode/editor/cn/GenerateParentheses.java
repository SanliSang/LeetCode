//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2346 👎 0


package Problem.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args){
        Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            LinkedList<String> list = new LinkedList<>();
            _generate(0,0,n,"",list);
            return list;
        }

        /**
         *
         * @param left 左括号的数量
         * @param right 左括号的数量
         * @param n 括号总数
         * @param s 正在被添加括号的字符串
         * @param list 存储括号字符串结果的列表
         */
        public void _generate(int left , int right , int n , String s , List<String> list){
            // 终止条件
            if (left == n && right == n){
                list.add(s);
                return;
            }
            // 处理逻辑 && 递归调用（因为添加括号比较简单，可以与递归调用写在一起）
            if (left < n) _generate(left+1,right,n,s+"(",list);
            if (left > right) _generate(left,right+1,n,s+")",list);
            // 清除当前层（这里不需要清除）
        }
    }

    /**
     * 思路1（递归求解）：为什么会想到使用递归？递归的关键在于找到最小最近的重复子问题。
     *      如果将所有将括号所占用的空间看成一个个格子，那么重复子问题就是：在格子中放入左括号或右括号，直至放满所有格子
     *      明白了这点其实就相当于明白了如何递归的方式，递归就是重复放括号的过程，而放满所有格子就是递归终止条件，递归的每一层之间通过参数来交流
     *      若不加以限制地放括号，就有可能导致出现括号不合法的情况，所以我们可以考虑在递归的过程中正确地放置格子。
     *      1.左括号与右括号的数量肯定都等于括号总数
     *      2.左括号可以任意加，直至达到其规定数量
     *      3.只有当右括号数量没有超出左括号时，才可以添加右括号，若超出则括号不合法
     */
//leetcode submit region end(Prohibit modification and deletion)

}