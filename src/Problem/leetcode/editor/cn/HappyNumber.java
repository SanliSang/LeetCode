//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 双指针 
// 👍 843 👎 0


package Problem.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber{
    public static void main(String[] args){
        Solution solution = new HappyNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = getNext(n);
            while (slow!=fast && fast != 1){ // 若fast为1表示找到环
                slow = getNext(slow); // 走一步
                fast = getNext(getNext(fast)); // 走两步
            }
            return fast == 1; // 即使slow==fast，也还需要判断fast是否为1
        }

        private int getNext(int n){
            int next = 0;
            while (n > 0){
                int i = n%10;
                n/=10;
                next+=i*i; // 加上每个位的平方数
            }
            return next;
        }

    }
    /**
     * 审题：将数以及结果的每个位平方累加是否等于1，若等于1则表示为快乐数，若无限循环则不是快乐数，快乐数的条件：存在一个1，其他都是0
     * 思路1：（快慢双指针）如果给出的数为快乐数，则快指针先到达最终结果为1（实际上没有尾节点，后面的节点数都是1），若该数不是快乐数，则肯定回有环，所以可以采用指针相遇来判断是否出现环
     *      节点表示数的计算得到的结果，使用一个getNext(int n)来计算每个n的下一个节点结果
     */
//leetcode submit region end(Prohibit modification and deletion)

}