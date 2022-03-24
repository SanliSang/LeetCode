//给你一个字符串 s ，颠倒字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：颠倒后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
// Related Topics 双指针 字符串 
// 👍 487 👎 0


package Problem.leetcode.editor.cn;
public class ReverseWordsInAString{
    public static void main(String[] args){
        Solution solution = new ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords2("  hello   world  "));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int start = 0;
            int end = s.length()-1;
            // 1.去除字符串前后空格
            while (s.charAt(start)==' ') start++;
            while (s.charAt(end) == ' ') end--;
            StringBuilder stringBuilder = new StringBuilder();
            //  2. 去除字符内的空格
            for (int i = start; i <= end; ) {
                char c = s.charAt(i);
                if (c != ' '){
                    stringBuilder.append(c);
                    i++;
                } else {
                    while (i < end && s.charAt(i) == ' ') i++; // 遍历所有空格
                    stringBuilder.append(' '); // 只保留一个空格
                }
            }
            reverse(0,stringBuilder.length()-1,stringBuilder);

            // 4.局部反转单词字符（这部分可以复用第三步反转字符串，只需要提供需要反转的字符以及需要反转的范围接口）
            for (int right = 0; right < stringBuilder.length(); right++) { // 控制需要反转的单词范围
                int left = right; // 记录单词开始位置
                while (right < stringBuilder.length() && stringBuilder.charAt(right)!=' ') right++;
                reverse(left,right-1,stringBuilder); // 反转单词指定部分
            }
            return stringBuilder.toString();
        }

        private void reverse(int start , int end , StringBuilder stringBuilder){
            // 3.反转字符串（复用）
            while (start < end){
                char t = stringBuilder.charAt(start);
                stringBuilder.setCharAt(start,stringBuilder.charAt(end));
                stringBuilder.setCharAt(end,t);
                start++;
                end--;
            }
        }


        // 二刷0
        public String reverseWords2(String s) {
            // 1.排除字符串的多余空格（前后空格和中间空格）
            StringBuilder stringBuilder = new StringBuilder(); // 要求返回的字符串必须是没有任何多余的字符，所以字符串需要重新构造
            int left = 0;
            int right = s.length()-1;
            while (s.charAt(left) == ' ') left++;
            while (s.charAt(right) == ' ') right--;
            // 此时的left和right指针都指向前后单词的首个字符

            for (int i = left; i <= right; ) {
                while (i <= right && s.charAt(i) != ' '){
                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                // 当跳出循环时表示单词结束，遍历所有空格
                while (i <= right && s.charAt(i) == ' ') i++;
                // 遍历最后一个空格后，需要加一个空格，若是最后一个单词则不需要加空格
                if (i <= right) stringBuilder.append(' '); // 若i大于right时，不需要添加空格
            }

            // 此时得到的字符就是没有多余空格的字符串

            // 2.反转整个字符串
            reverse2(0,stringBuilder.length()-1,stringBuilder);

            // 3.对每个单词进行反转
            int start = 0; // 维护单词首个字符
            int end = 0; // 维护单词末尾的后一个字符
            while (end < stringBuilder.length()){
                while (end < stringBuilder.length() && stringBuilder.charAt(end) != ' '){
                    end++;
                }
                reverse2(start,end-1,stringBuilder); // 部分反转字符串
                start = end+1; // 新的其实位置
                end++; // 此时的end为空格，所以需要再进一位判断，否则内while循环
            }

            return stringBuilder.toString();
        }

        private void reverse2(int left , int right , StringBuilder s){
            while (left < right){
                char t = s.charAt(left);
                s.setCharAt(left,s.charAt(right));
                s.setCharAt(right,t);
                left++;
                right--;
            }
        }
    }
    /**
     * 审题：每个字符之间空格方式隔开，反转后空格只保留1格，只反转单词的顺序，而不反转单词字符，反转后不可有前导后导空格
     * 思路1：双指针（非原地反转）。首先统计单词字符，并计算空格数量，创建反转后字符数组大小。
     * 思路2：去除多余空格字符串、字符串反转，每个单词再反转（局部字符串反转：一边遍历一边统计需要反转的字符范围）
     */
//leetcode submit region end(Prohibit modification and deletion)

}