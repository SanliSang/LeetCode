//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1255 👎 0


package Problem.leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            inorder(root,list);
//            return list;
//        }

//        private void inorder(TreeNode node , List<Integer> list){
//            if (node == null) return;
//            inorder(node.left,list);
//            list.add(node.val);
//            inorder(node.right,list);
//        }
/*
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>(100);
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()){
                while (root != null){ // 判断是否存在左节点，若存在左节点则将该节点压入栈内
                    stack.push(root);
                    root = root.left;
                }
                // 执行到此处说明没有左节点，需要弹出栈顶节点处理（加入到列表内）
                root = stack.pop();
                list.add(root.val);
                root = root.right; // 取出右节点作为当前节点继续重新判断中序遍历
            }
            return list;
        }
*/
    }
    /**
     * 思路1（递归）：递归的关键在于找出最小可重复执行单元，然后写出递归公式
     *      inorder(node.left);
     *      process(node.val)
     *      inorder(node.right);
     *
     * 思路2（迭代）：
     */
//leetcode submit region end(Prohibit modification and deletion)

}