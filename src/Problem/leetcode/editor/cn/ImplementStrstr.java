//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1318 👎 0


package Problem.leetcode.editor.cn;

import java.util.HashMap;

public class ImplementStrstr{
    public static void main(String[] args){
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr3("abcabdcb", "abd"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.equals("")) return 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
                String s = haystack.substring(i,i + needle.length());
                map.put(s,i);
                if (map.containsKey(needle)){
                    return map.get(needle);
                }
            }
            return -1; // 表示没有找到相应的子字符串
        }

        public int strStr2(String haystack, String needle) {
            if (needle.equals("")) return 0;
            for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
                String s = haystack.substring(i,i + needle.length());
                if (s.equals(needle)) return i;
            }
            return -1;
        }

        // KMP算法
        public int strStr3(String haystack, String needle) {

            int[] next = new int[needle.length()];
            int n = haystack.length();
            int m = needle.length();
            char[] sup = haystack.toCharArray();
            char[] sub = needle.toCharArray();

            //needle为匹配串，m为匹配串的长度
            //i只前进不后退，j表示匹配串子串的长度
            //needle[i] != needle[j]，找上一个匹配串子串的开始匹配的位置
            //needle[i] == needle[j]，匹配串子串长度增加1。

            for (int i = 1, j = 0; i < m; i++) {
                while (j > 0 && sub[i] != sub[j]) {
                    j = next[j - 1];
                }
                if (sub[i] == sub[j]) {
                    j++;
                }
                next[i] = j;
            }

            //j表示匹配串子串的长度
            //haystack[i] != needle[j],利用next更新匹配串子串的开始匹配的位置
            //haystack[i] == needle[j], 匹配串子串长度增加1

            for (int i = 0, j = 0; i < n; i++) {
                while (j > 0 && sup[i] != sub[j]) {
                    j = next[j - 1];
                }
                if (sup[i] == sub[j]) {
                    j++;
                }
                if (j == m) {
                    return i - m + 1;
                }
            }
            return -1;
        }
    }
    /**
     * 题型：字符串匹配算法（暴力匹配、RF匹配、kmp匹配算法）
     * 审题：在haystack中找出needle首个出现的位置下标，若needle为空字符串则返回0，若没有找到则返回-1
     * 思路1：使用哈希映射needle，然后去除haystack部分字符和needle做哈希映射比对，若哈希值一致表示找到该元素。时间复杂度O(n-m+1)
     * 思路2：KMP算法。KMP的优点就是在模式串往后匹配的过程中可以选择性地跳过哪些必定不会匹配上的位置，从而大大地减少了不必要的匹配次数，kmp最差情况也就是退化成暴力匹配
     */
//leetcode submit region end(Prohibit modification and deletion)

}