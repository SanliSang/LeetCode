//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 
// 👍 239 👎 0


package Problem.leetcode.editor.cn;
public class TiHuanKongGeLcof{
    public static void main(String[] args){
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            // 1. 统计空格数量并扩容
            char[] array = s.toCharArray();
            int size = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == ' ') size++;
            }
            char[] newArray = new char[array.length + size * 2];

            // 2. 从后往前扫描字符，判断是否需要插入%20
            for (int i = array.length-1 , j =newArray.length-1;i >= 0 && i <= j; i-- , j--) { // 当j==i时表示没有需要插入的%20，但不保证剩下的字符已经插入，所以还需要继续插入剩下的字符（i<=0或j<=0）
                if (array[i] != ' '){ // 不需要插入
                    newArray[j] = array[i];
                }else { // 插入%20
                    newArray[j] = '0';
                    newArray[j-1] = '2';
                    newArray[j-2] = '%';
                    j-=2; // 这里j没有前进3格单位是，因为j始终会向前移动一位
                }
            }
            return new String(newArray);
        }
    }
    /**
     * 审题：将每一个空格替换成%20，若存在多个空格则替换多个%20
     * 思路1：统计空格数+双指针。因为并不能推测当前字符串的空格大小，但是题目不可以返回存在多余的字符串，所以第一步需要统计空格数量
     *      第二步就是从后往前移动字符串，如果采用从前往后移动字符串，则实践复杂度退化成O(n^2)，因为需要移动当前位置以后的所有字符，通过双指针移动的方式来控制每次移动字符还是填充%20
     *      指针移动策略：i指针负责探测空格，当出现空格时，维护该空格的位置，另一个指针j用来填充%20（同时j指针也往前移动），填充完成后，i指针继续寻找空格，若没有找到空格，也需要将i指针的字符赋值到j指针位置上，维护非空格字符
     *      总结：数组类填充类问题都是，都可以预先给数组扩容带填充后的大小，然后往后面往前开始操作，好处就是：1.申请新数组 2.从后面开始往前面开始填充不需要移动额外的字符（就像数组中插入元素那样需要其他所有元素让一个位置给该元素插入位置）
     */

}