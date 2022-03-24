//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 798 👎 0


package Problem.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString{
    public static void main(String[] args){
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new LinkedList<Integer>();
            // 找出p的键
            StringBuffer sb = new StringBuffer();
            int[] arr = new int[26];
            for (int i = 0; i < p.length(); i++) {
                arr[p.charAt(i)-'a']++; // 计数
            }
            for (int i = 0; i < 26; i++) { // 遍历并对应拼接字符和计数
                if (arr[i] != 0){
                    sb.append((char) ('a'+i)); // 还原字符
                    sb.append(arr[i]); // 还原计数
                }
            }
            String p_key = sb.toString(); // 得到p的键

            // 遍历s找出p_key
            for (int i = 0; i < s.length() - p.length() + 1; i++) { // 最大异位词个数
                int[] counts = new int[26];
                String sub = s.substring(i,i+p.length()); // 取出子串
                for (int j = 0; j < sub.length(); j++) {
                    counts[sub.charAt(j)-'a']++; // 计数
                }
                StringBuffer ss = new StringBuffer();
                for (int j = 0; j < 26; j++) {
                    if (counts[j]!=0){
                        ss.append((char) (j+'a')); // 拼接字符
                        ss.append(counts[j]); // 拼接计数
                    }
                }
                String s_key = ss.toString();
                if (s_key.equals(p_key)){
                    list.add(i);
                }
            }
            return list;
        }

        // 滑动窗口+双指针
        public List<Integer> findAnagrams2(String s, String p) {
            int n = s.length(), m = p.length();
            List<Integer> res = new ArrayList<>();
            if(n < m) return res;

            int[] pCnt = new int[26];
            int[] sCnt = new int[26];

            for(int i = 0; i < m; i++){ // 创建目标的数组值，用于比对窗口内是否存在和p相等的异位词
                pCnt[p.charAt(i) - 'a'] ++;
            }

            int left = 0;
            for(int right = 0; right < n; right++){ // 右指针
                int curRight = s.charAt(right) - 'a'; // 得到字符对应下标的值
                sCnt[curRight]++; // 累加记录字符出现的次数
                // 只有出现了p字符串中包含的字符，左指针才可以和右指针拉开距离（跳出循环，即左指针不会右移）
                while(sCnt[curRight] > pCnt[curRight]){ // 若记录了p字符串中没有的字符，则左指针向右移动（压缩）
                    int curLeft = s.charAt(left) - 'a';
                    sCnt[curLeft]--; // 减去p字符串中没有出现的字符记录
                    left++; // 左指针右移
                }
                if(right - left + 1 == m){ // 当恰好左指针到右指针的长度等于p字符串的长度时，恰好表示刚好找到该异位词
                    res.add(left); // 将当前左指针位置添加到列表中
                }
            }
            return res;
        }

        // 滑动窗口
        public List<Integer> findAnagrams3(String s, String p) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] sarr = new int[26]; // 记录p字符串字符出现的次数（下标对应字符映射，值代表出现的次数）
            int[] parr = new int[26]; //
            for (int i = 0; i < p.length(); i++) {
                parr[p.charAt(i)-'a']++;
            }

            /**
             * 右指针：遍历s字符串
             * 左指针：维护异位词字母的开头
             * 窗口：维护满足异位词的子字符串，也就是我们要找的结果
             * 左指针什么是否移动？因为窗口内只维护满足异位词的字符串，当右指针找到一个不存在与parr的字符（或字符数量不匹配）时，左指针和右指针一起移动
             *      当右指针找到了parr的一部分则停留只让右指针右移，窗口扩大，窗口内必定维护着parr的部分，
             *      当窗口长度等于p字符串长度时，表示窗口内已经存在一个parr了，所以记录当前左指针位置进入列表
             */
            int left = 0; // 左指针
            for (int right = 0; right < s.length(); right++) { // 右指针
                int curRight = s.charAt(right)-'a'; // 得到右指针对应的下标值
                sarr[curRight]++; // 记录s字符（后筛选判断）
                while (sarr[curRight]>parr[curRight]){ // 若sarr中记录了没用的字符（在parr中没有出现的字符），则左指针需要移动，保持窗口不要记录没用的字符
                    int curLeft = s.charAt(left) - 'a';
                    sarr[curLeft]--; // 丢弃左指针的字符记录
                    left++;
                }
                if (right - left + 1 == p.length()){
                    list.add(left); // 记录指针位置
                }
            }
            return list;
        }

    }
    /**
     * 审题：s 和 p 仅包含小写字母
     * 思路1：计数+哈希表方式来表示异位词
     */
//leetcode submit region end(Prohibit modification and deletion)

}