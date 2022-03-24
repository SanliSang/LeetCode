//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 
// 👍 1253 👎 0


package Problem.leetcode.editor.cn;
public class SwapNodesInPairs{
    public static void main(String[] args){
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        solution.swapPairs(n1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        // 双指针没法进行（至少需要三指针）
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p1 = head;
            ListNode p2 = head.next;
            int index = 1;
            while (p2 != null){
                ListNode t = p2.next;
                if (index%2 == 1){ // 反转
                    p2.next = p1;
                    p1.next = t;
                    p2 = t;
                }else {
                    p1 = p2;
                    p2 = t;
                }
                index++;
            }
            head = head.next;
            return head;
        }


        public ListNode swapPairs2(ListNode head) {
            ListNode pre = new ListNode(0); // 设置虚拟头节点，pre.next表示为实际头节点
            pre.next = head; // 将虚拟头节点拼在链表中
            ListNode temp = pre; // temp作为临时指针，用来遍历

            /**
             * start和end节点表示两个要交换的节点，start表示交换前的头节点，而end表示交换前的为尾节点
             */

            while(temp.next != null && temp.next.next != null) {
                // 交换前将缓冲下一次要交换的指针为止
                ListNode start = temp.next; // 找到交换前头节点
                ListNode end = temp.next.next; // 找到交换前尾节点
                temp.next = end;
                // 交换（主要是两步骤）
                start.next = end.next;
                end.next = start;
                // 往后遍历（更新临时节点）
                temp = start;
            }
            return pre.next; // pre.next一直维护实际头节点
        }

        // 不设置虚拟头节点（失败，对尾节点还需要特殊处理）
        public ListNode swapPairs3(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head.next;
            ListNode first = head.next;
            ListNode temp = head;
            while (temp != null && temp.next != null){
                p1.next = p2.next;
                p2.next = p1;

                temp = temp.next;
                if (temp != null && temp.next != null){
                    p1 = temp;
                    p2 = p1.next;
                }
            }
            return first;
        }

        public ListNode swapPairs4(ListNode head) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode temp = pre; // 维护遍历
            while (temp.next!=null && temp.next.next!=null){
                ListNode p1 = temp.next;
                ListNode p2 = temp.next.next;
                // temp.next = p2;
                p1.next = p2.next;
                p2.next = p1;

                temp = p1; // 前进遍历
            }
            return pre.next;
        }


    }

    /**
     * 审题：链表为不带头的节点，从第一个节点开始两两交换
     */
//leetcode submit region end(Prohibit modification and deletion)

}