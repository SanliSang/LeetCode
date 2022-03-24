//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2313 👎 0


package Problem.leetcode.editor.cn;

import java.util.List;

public class ReverseLinkedList{
    public static void main(String[] args){
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        solution.reverseList3(n1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p1 = head; // p1用于辅助p2反转的前一个节点
            ListNode p2 = head.next; // p2指向要反转的指针
            ListNode p3 = head.next.next; // p3为前进遍历的节点
            while (p3 != null){
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            }
            // 跳出循环时p2指针为当前队头元素，需要处理p3指针为新队头，和队尾下一个指针为空（因为一开始p1节点没法反转）
            head.next = null;
            p2.next = p1;
            head = p2;
            return head;
        }

        // 双指针版本（节省p3指针，以p1指针为反转节点，而p2作为前驱节点，因为p2需要跟进）
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p1 = null;
            ListNode p2 = head;
            while (p2 != null){
                ListNode t = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = t;
            }
            // 退出循环时，p1就是头节点
            return p1;
        }

        // 递归版本
        public ListNode reverseList3(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p1 = null;
            ListNode p2 = head;
            return reverse(p1,p2);
        }

        private ListNode reverse(ListNode p1 , ListNode p2){
            // 终止条件
            if (p2 == null) return p1;
            // 逻辑处理
            ListNode t = p2.next; // 临时保存变量p2的下一个变量
            p2.next = p1; // 反转
            // 递归调用
            return reverse(p2, t); // reverse(p1,p2) = reverse(p2,p2.next) + reverse(p2.next,p2.next.next) ...原先的p1后移一位即p2，p2也后移一位即p2的下一个临时变量
        }

        public ListNode reverseList4(ListNode head){
            if (head == null || head.next == null) return head;
            ListNode p1 = null;
            ListNode p2 = head;

            while (p2!=null){
                ListNode t = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = t;
            }
            return p1;
        }

        // 三刷（双指针）
        public ListNode reverseList5(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = null;
            ListNode q = head;

            while (q != null){
                ListNode pre = q.next;
                q.next = p;
                p = q;
                q = pre;
            }
            return p;
        }
    }

    /**
     * 审题：单链表为无头节点
     * 思路1：
     */
//leetcode submit region end(Prohibit modification and deletion)

}