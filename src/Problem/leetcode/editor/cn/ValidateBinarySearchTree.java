//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 104] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1404 👎 0


package Problem.leetcode.editor.cn;

import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    class Solution {
        /*
        public boolean isValidBST(TreeNode root) {
            return isValid(root,true);
        }

        public boolean isValid(TreeNode node , boolean flag){
            // 终止条件
            if (!flag) return false;
            // 递归调用（处理下一层）
            if (node.left != null) flag = isValid(node.left,flag);
            if (node.right != null) flag = isValid(node.right,flag);
            // 处理逻辑
            if (node.left == null && node.right == null) return true;
            else if (node.left == null) return node.val < node.right.val;
            else if (node.right == null) return node.val > node.left.val;
            else return node.val > node.left.val && node.val < node.right.val;
            // 清理当前层
        }
        */

        /*
        public boolean isValidBST(TreeNode root) {
            return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        private boolean isValid(TreeNode node , long lower , long upper){
            // 终止条件（当节点为空则直接返回，这里不能返回false，因为遍历到底部不能标识不满足条件）
            if (node == null) return true;
            // 处理逻辑（当前节点要满足边界值的范围，该边界值其实就是上一个根节点的值和左右两侧的值）
            if (node.val<=lower || node.val>=upper) return false;
            // 递归调用（遍历左子树时，左边界为根节点，左边界为最小值；遍历右子树时，右边界为最大值）
            return isValid(node.left,lower,node.val) && isValid(node.right,node.val,upper);
            // 清理当前层
        }
        */

    }
    /**
     *  思路1（暴力解法，错解）：通过遍历所有二叉树，判断每个节点的左右子节点是否存在，每个节点是否大于其左节点且小于其右节点，如果两个条件都不满足则不是有效地二叉搜索树
     *  思路2（优化暴力解法，错解）：最后一层节点不需要进行遍历，因为最后一层节点没有左节点和右节点
     *  思路3（递归）：根据二叉搜索树的特性，不仅需要满足每个节点大于其左节点且小于其右节点，还需满足该结点的左子树都要小于该节点，而右子树所有节点都要大于该节点
     *  思路4（中序遍历）：使用中序遍历得到的结果就是单调的递增的序列，所以使用一个单调栈来维护得到
     */
    public boolean isValidBST(TreeNode root){
        Stack<Long> stack = new Stack<>();
        stack.push(Long.MIN_VALUE);
        return isValid(root,stack);
    }

    public boolean isValid(TreeNode root , Stack<Long> list) {
        if (root == null) return true;
        isValid(root.left,list);
        if (list.peek() >= root.val){
            return false;
        } else list.push((long) root.val);
        isValid(root.right,list);
        return false;
    }

//leetcode submit region end(Prohibit modification and deletion)

}