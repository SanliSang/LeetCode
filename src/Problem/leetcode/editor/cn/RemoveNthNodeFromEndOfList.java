//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1830 👎 0


package Problem.leetcode.editor.cn;
public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args){
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        solution.removeNthFromEnd5(n1,2);
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
        // 两次扫描
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null) return null;
            int len = 0;
            for (ListNode t = head; t != null ; t = t.next) len++;
            if (len == n) { // 恰好要删除的就是头部时，需要特殊处理
                head = head.next;
                return head;
            }
            ListNode t = head;
            for (int i = 0; i < len-n+1; i++) { // 遍历到要删除位置的前一个位置
                t = t.next;
            }
            t.next = t.next.next; // 删除节点
            return head;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode dummy = new ListNode(-1); // 创建临时节点（方便操作）
            dummy.next = head; // 装上虚拟头节点
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (n-- > 0) fast = fast.next; // 先让指针fast先走
            ListNode prev = null; // 临时保存需要删除的节点的前一个节点（否则需要控制指针指向待删除节点的前一个结点的节点，注意空指针）
            while (fast != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = slow.next; // 删除节点
            return dummy.next; // 返回实际头节点
        }


        // 二刷
        public ListNode removeNthFromEnd3(ListNode head, int n) {
            if (head == null || head.next == null) return null;
            ListNode first = new ListNode(-1);
            first.next = head;
            ListNode fast = first;
            ListNode slow = first;

            ListNode pre = null;
            for (int i = n; i > 0; i--) {
                fast = fast.next;
            }

            while (fast!=null){
                pre = slow;
                fast = fast.next;
                slow = slow.next;
            }
            pre.next = slow.next;
            return first.next;
        }


        //【失败，带虚拟头节点的容易判断】 三刷（快慢指针）
        public ListNode removeNthFromEnd4(ListNode head, int n) {
            if (head.next == null || n <= 0) return null;
            // 1. 首先定义两个快慢指针
            ListNode fast = head;
            ListNode slow = head;
            // 2. 让快指针向前进n步，然后快慢指针同时移动，当fast移动到末尾最后一个元素时，slow前一个节点就是要删除的节点
            while (n > 0) {
                fast = fast.next;
                n--;
            }
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }

        public ListNode removeNthFromEnd5(ListNode head, int n) {
            ListNode first = new ListNode(-1);
            first.next = head;
            // 1. 首先定义两个快慢指针
            ListNode fast = first;
            ListNode slow = first;
            // 2. 让快指针向前进n步，然后快慢指针同时移动，当fast移动到末尾最后一个元素时，slow前一个节点就是要删除的节点
            while (n > 0) {
                fast = fast.next;
                n--;
            }
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return first.next;
        }
    }
    /**
     * 审题：删除倒数第一节点为n-1号节点，第二个节点为n-2号节点；链表为不带头节点
     * 思路1：两次遍历。首先遍历一次后得到链表个数，然后再次遍历顶点删除，时间复杂度O(n)
     * 思路2：一次遍历（快慢思想）。如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。
     *      删掉slow所指向的节点就可以了，因为预留的slow和fast已经预留了n个节点位置
     */
//leetcode submit region end(Prohibit modification and deletion)

}