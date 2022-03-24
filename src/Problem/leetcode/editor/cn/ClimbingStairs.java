//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2150 👎 0


package Problem.leetcode.editor.cn;
public class ClimbingStairs{
    public static void main(String[] args){
        Solution solution = new ClimbingStairs().new Solution();
//        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs2(3));
    }

    class Solution {
        public int climbStairs(int n) {
            if (n <= 1) return 1;
            return climbStairs(n-1) + climbStairs(n-2);
        }

        public int climbStairs2(int n) {
            return _climb(new int[n+1],n);
        }

        public int _climb(int[] arr , int n){
            if (arr[n] != 0) return arr[n];
            if (n <= 1) return 1;
            arr[n] += _climb(arr,n-2) + _climb(arr,n-1);
            return arr[n];
        }

        // 因为如果使用缓存表的方式时间复杂度虽然一样很低，但是因为多一个数组导致空间复杂度变得很高，所以可以将递归改造成普通循环方式节省空间
        // 其实f(n)=f(n-1)+f(n-2) 反过来说明我们可以从低级别的n的循环到高级别的n
        public int climbStairs3(int n){
            int f1 = 1; // 走一步方式
            int f2 = 2; // 走两步方式
            int f3 = 0; // 走一步+走两步的方式
            for (int i = 1; i <= n; i++) {
                f3 = f1 + f2;
                f1 = f2; // 低层次的n可以累加变成高层次的n，然后继续与其他低层次的n得到更高层次的n
                f2 = f3;
            }
            return f3;
        }
    }
    /**
     * 思路1（暴力递归解法）：关键找出最小重复子问题，这个可以在一点点枚举中得到规律，比如走第i阶台阶其实就相当在第i-1阶台阶走一步加上在第i-2阶台阶走两步
     *      很快就可以得到递归公式: f(n) = f(n-1) + f(n-2)，如果我们画出递归树，可以看到f(xxx)有很多重复的情况。所以为了避免超时或栈溢出，
     *      可以加记录表来记录已经完成的f(xxx)对应的次数即可，不必重新又继续递归计算，这个也是空间换时间的一种常见的
     */
}