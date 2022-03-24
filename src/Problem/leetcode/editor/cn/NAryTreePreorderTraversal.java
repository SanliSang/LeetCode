//给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历 。 
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
//示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数在范围 [0, 104]内 
// 0 <= Node.val <= 104 
// n 叉树的高度小于或等于 1000 
// 
//
// 
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
// Related Topics 栈 树 深度优先搜索 
// 👍 203 👎 0


package Problem.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal{
    public static void main(String[] args){
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Solution {
        /*
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            pre(root,list);
            return list;
        }

        public void pre(Node node , List<Integer> list){
            if (node == null) return;
            list.add(node.val);
            List<Node> children = node.children;
            for (Node child : children) {
                pre(child,list);
            }
        }
        */
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            while (root != null || !stack.isEmpty()){
                list.add(root.val);
                List<Node> children = root.children;
                for (int i = children.size()-1; i >= 0; i--) {
                    if (children.get(i)!=null){
                        stack.push(children.get(i));
                    }
                }
                if (stack.peek()!=null) root = stack.pop();
            }
            return list;
        }

    }
    /**
     * 思路1（递归）：和二叉树不同的是，子节点个数有可能大于两个，所以需要依次遍历子节点的方式来递归调用
     * 思路2（迭代）：
     */
//leetcode submit region end(Prohibit modification and deletion)

}