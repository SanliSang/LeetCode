//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 105 
// 0 <= fruits[i] < fruits.length 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 162 👎 0


package Problem.leetcode.editor.cn;

import java.util.HashMap;

public class FruitIntoBaskets{
    public static void main(String[] args){
        Solution solution = new FruitIntoBaskets().new Solution();
        solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        public int totalFruit(int[] fruits) {
            int len = 0; // 窗口大小（表示可采摘两种水果的最大长度）
            int left = 0; // 窗口左边，出现新水果时，需要更新左边窗口滑动到第一类水果的最后一个位置+1处
            int
            HashMap<Object, Object> map = new HashMap<>();
            for (int right = 0; right < fruits.length; right++) {

                while (){

                }
            }
        }
        */

        public int totalFruit(int[] fruits) {
            int left = 0; // 窗口左边界
            int maxLen = 0; // 窗口最大长度（也是最终要求的值）
            int[] count = new int[fruits.length]; // 计数器，数组下标作为水果种类，数值作为该水果种类对应的水果个数
            int size = 0; // 表示当前计数器中装载的水果种类个数
            for (int right = 0; right < fruits.length; right++) {
                if (count[fruits[right]] == 0) size++; // 如果对应水果种类的计数器数值为0，代表该水果之前没有出现过，是新水果，所以种类+1
                count[fruits[right]]++; // 该种类的水果值+1
                // 滑动窗口内水果种类大于 2 个时，需要从窗口左边遍历剔除掉所有第一类水果
                while (size > 2) {
                    count[fruits[left]]--; // 剔除第一类水果数
                    if (count[fruits[left]] == 0) { // 若要剔除掉的水果个数为0表示已经完全剔除掉第一类水果，所以水果种类-1
                        size--;
                    }
                    left++; // 继续遍历
                }
                // 扩大窗口的时候更新 最大长度
                maxLen = Math.max(maxLen, right - left + 1); // 维护当前窗口大小和历史窗口大小的最大值
            }
            return maxLen;
        }
    }
    /**
     * 审题：求只有数组中最长的且仅有两个种类的连续数组
     * 思路1：滑动窗口。解释写在代码上了
     * 滑动窗口解题的关键：
     *      1.通常用来数组上，属于双指针的一种解法
     *      2.关键在于如何理解左边界和右边界以及限制条件就是窗口大小（往往是解题的最终结果）
     *      3.模板如下：
     *      for (int right = 0; right < arrSize ; right++) {
     *          // 将新进来的右边的数据，计算进来
     *          // 更新数据
     *
     *          // 判断窗口数据是否不满足要求了
     *          while (窗口数据不满要求 && left < arrSize) {
     *               // 移除left数据，更新窗口数据
     *              left++;
     *            }
     *            // 记录当前窗口状态
     *      }
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}