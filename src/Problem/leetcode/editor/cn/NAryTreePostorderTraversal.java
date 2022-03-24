//给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。 
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数在范围 [0, 104] 内 
// 0 <= Node.val <= 104 
// n 叉树的高度小于或等于 1000 
// 
//
// 
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
// Related Topics 栈 树 深度优先搜索 
// 👍 178 👎 0


package Problem.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class NAryTreePostorderTraversal{
    public static void main(String[] args){
        Solution solution = new NAryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        post(root,list);
        return list;
    }

    public void post(Node node , List<Integer> list){
        if (node == null) return;
        List<Node> children = node.children;
        for (Node child : children) {
            post(child,list);
        }
        list.add(node.val);
    }
        */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        while (root != null){
            list.add(root.val);
            List<Node> children = root.children;
            for (int i = children.size()-1; i >= 0; i--) {
                if (children.get(i)!=null) stack.push(children.get(i));
            }
            root = stack.poll();
        }
        // 反转链表
        Integer[] array = list.toArray(new Integer[0]);
        list.clear();
        for (int i = array.length-1; i >= 0; i--) {
            list.add(array[i]);
        }
        return list;
    }
    /**
     * 思路1（迭代）
     * 思路2（使用先序遍历后进行反转，也可迭代也可递归）
     * 思路3（纯后序遍历）
     */

//leetcode submit region end(Prohibit modification and deletion)
    }
}