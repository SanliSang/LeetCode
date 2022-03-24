//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文组成 
// 1 <= k <= 104 
// 
// Related Topics 双指针 字符串 
// 👍 263 👎 0


package Problem.leetcode.editor.cn;
public class ReverseStringIi{
    public static void main(String[] args){
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr2("abcdefg", 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] array = s.toCharArray();
            int j = 0; // 反转指针
            int index = 0; // 用于记录一趟遍历字符的次数
            for (int i = 0; i < array.length; i++) { // i用于遍历字符，当判断index等于k时，表示需要开始反转
                if (index == 2*k){ // 遍历了k次，反转前k个字符
                    // 反转（双指针）
                    int left = j;
                    int right = j+k-1;
                    while (left<right){
                        char t = array[left];
                        array[left] = array[right];
                        array[right] = t;
                        left++;
                        right--;
                    }
                    j = i;
                    index = 0;
                }
                index++;
            }
            // 跳出循环时判断index是否的大小而判断是否需要剩下字符都反转还是需要反转前k个字符
            int left = j;
            int right = 0;
            if (index <= k){ // 完全反转
                right = array.length-1;
            }else { // 部分反转
                right = j+k-1;
            }
            while (left<right){
                char t = array[left];
                array[left] = array[right];
                array[right] = t;
                left++;
                right--;
            }
            return new String(array);
        }

        // 存在一个bug：当s小于k时right会导致指针异常（第一次遍历时会导致指针越界）
        public String reverseStr2(String s, int k) {
            char[] array = s.toCharArray();
            int j = 0; // 记录反转字符串的起始位置
            for (int i = 0; i < array.length; ) { // 如果满足该循环说明当前指针i就是需要反转的位置
                int left = j;
                int right = j+k-1;
                while (left<right){
                    char t = array[left];
                    array[left] = array[right];
                    array[right] = t;
                    left++;
                    right--;
                }
                i+=k*2;
                j = i;
            }
            // 当跳出循环时才开始判断j位置到数组末尾的还有多少个字符
            int len = array.length-j+1;
            int left = j;
            int right = 0;
            if (len<k){ // 全部反转
                right = array.length-1;
            }else { // 部分反转
                right = j+k-1;
            }
            while (left<right){
                char t = array[left];
                array[left] = array[right];
                array[right] = t;
                left++;
                right--;
            }
            return new String(array);
        }


    }
    /**
     * 审题：遍历2k就反转前k个，下一次反转中不足k，则将不足k的剩余所有反转，若不足2k但大于或等于k，则反转前k个
     * 思路1：循环+双指针。循环控制指针k的移动，而双指针负责反转
     * 思路2：优化思路1。不需要使用计时器来规判断当前运行的指针位置是否需要反转，只需要移动到恰好要反转的位置即可（因为需要反转的位置时有规律的），使得指针i+=k*2，然后再反转即可
     *      总结：当出现有规律的计时器时，不妨可以直接在循环for中做文章，可以通过改变循环来代替定时器的使用
     */
//leetcode submit region end(Prohibit modification and deletion)

}