//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 1033 👎 0


package Problem.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args){
        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map map = new HashMap<String,LinkedList<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i)-'a']++; // 将str字符出现的次数累加起来
            }
            StringBuffer stringBuffer = new StringBuffer(); // 拼接字符+计数作为哈希键
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0){
                    stringBuffer.append((char) ('a'+i)); // 还原字符
                    stringBuffer.append(counts[i]); // 还原计数
                }
            }
            String key = stringBuffer.toString(); // 得到str的键

            // 若原先存在有key，则取出List并str放入列表中
//            if (map.containsKey(key)){
//                LinkedList list = (LinkedList) map.get(key);
//                list.add(str);
//            }else map.put(key,new LinkedList<String>().add(str)); // 若之前没有这个key，就新开一个List，专门存储这种类型的key
            List<String> list = (List<String>) map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values()); // 将map的数据取出并放入List的套娃内
    }
}
/**
 * 审题：将strs数组中遇到的单词进行归类，使用同种类型个数而排列顺序不同的单词为一类，返回所有单词的总类（类似于找出等价类）；
 *      所有源单词中的字母通常恰好只用一次（关键）；strs[i] 仅包含小写字母
 * 思路1：因为每个字母都恰好只用一次给字符做一个映射：a->0、b->1、c->2....注意：使用累加后作为哈希表的键还是不行的，比如1+2+3+4=10，而1+4+5也等于10
 *      所以无法区分每个他们是字母异位词，但是我们可以对每个字母进行计数的方式来进行区分，比如a1b2c3表示a出现1次，b出现2次，c出现3次（这里其实并不会出现重复字母的情况，即使出现也是可以解决的）
 */
//leetcode submit region end(Prohibit modification and deletion)

}