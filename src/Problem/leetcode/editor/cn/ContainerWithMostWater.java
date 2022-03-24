//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 3150 👎 0


package Problem.leetcode.editor.cn;
public class ContainerWithMostWater{
    public static void main(String[] args){
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] arr = {1,8,6,2,5,4,8,3,7};
//        System.out.println(solution.maxArea(arr));
        System.out.println(solution.maxArea2(arr));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0 , j = height.length -1 ; i < j ; ) { // 保持左指针小于右指针才可能有面积
                int min_height = height[i] < height[j] ? height[i++] : height[j--]; // 这里有很重要的细节，就是往中间靠拢的那个指针一定是较小的那个指针，因为目的是找到高度较高的一组而不是较低的一组
                max = Math.max(max,min_height*(j - i + 1)); // 这里要记得+1
            }
            return max;
        }

        public int maxArea2(int[] height){
            int max = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1 ; j < height.length; j++) {
                    int min_height = height[i] < height[j] ? height[i] : height[j];
                    max = Math.max(max,min_height*(j-i));
                }
            }
            return max;
        }

    }
    /**
     * 思路1（暴力枚举）：简单粗暴，直接对每一组棒子高度与其之间的距离乘积得到面积
     * 思路2（双指针）：我们的目的就是要找出相距较大且棒子均为较高的一组，所以一开始假设左右两端i，j指针的相聚长度都是最大的，
     *      将二维决定因素（一组高度与距离）降低到只需要选取一组高度即可（因为距离一开始就是选择最大的，所以影响因素只有高度），
     *      就可以逐渐的往中间靠拢得到高度与距离乘积面积的最佳匹配
     *      提问：为什么不选择最高的两组棒子然后在逐步将棒子之间的距离扩大（也就是将影响因素降低到只需要选取距离）？
     *          很简单，因为棒子的高度排序是乱序的，一开始并不知道最大的棒子是什么，但可以知道最大的距离是什么，
     *          所以就可以从最大距离开始慢慢缩减到较高高度得到最佳匹配
     *     左右夹逼的思想：从多个影响因素中找到
     */
}