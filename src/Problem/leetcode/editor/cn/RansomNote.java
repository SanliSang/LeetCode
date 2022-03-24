//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 105 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 281 👎 0


package Problem.leetcode.editor.cn;
public class RansomNote{
    public static void main(String[] args){
        Solution solution = new RansomNote().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] arr = new int[26];
            for(char c : ransomNote.toCharArray()) arr[c-'a']++;
            for(char c : magazine.toCharArray()) arr[c-'a']--;
            for (int i = 0; i < arr.length; i++) if (arr[i] > 0) return false;
            return true;
        }
    }
    /**
     * 审题：magazine每个字符只能在ransomNote使用一次，ransomNote 和 magazine 由小写英文字母组成，两个字符串长度至少为1
     * 思路1：哈希表记录次数。和lc.242题目相似，而lc.242题目要求两个字符串的出现的字符对应数量不多不少，而这里magazine出现的字符比ransomNote相等或比其多
     *      先通过哈希表（数组实现）记录ransomNote字母出现的次数，然后在减去magazine出现的次数，若数组存在有正数，则表示magazine缺少某些字符可拼成ransomNote
     */
//leetcode submit region end(Prohibit modification and deletion)

}