//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 515 👎 0


package Problem.leetcode.editor.cn;

import java.util.HashMap;

public class ValidAnagram{
    public static void main(String[] args){
        Solution solution = new ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] ss = new int[26];
            int[] ts = new int[26];
            for(char c :s.toCharArray()) ss[c - 'a']++;
            for(char c :t.toCharArray()) ts[c - 'a']++;
            // 取出比较
            int index = 0;
            while (index < 26 && ss[index] == ts[index]) index++;
            return index == 26; // 若index为26则说明所有类型的字母都匹配数量都匹配得上
        }
    }
    /**
     * 审题：s和t只能是小写字母（26个），s和t的长度最少为1
     * 思路1：创建两个26个位置的哈希表（数组实现，0号代表a，1号代表b...），遍历每个字母并进行哈希映射得到键，并对该字母对应的存储值+1，最后判断两个哈希表对应出现的值是否相同
     * 优化思路：不需要设置两个数组，只需要一个即可，第一个字符串遍历就记录累加，而第二个字符串遍历就相对累减，最后数组的所有位置不为0则说明字母数量不匹配，反之匹配
     */
//leetcode submit region end(Prohibit modification and deletion)

}