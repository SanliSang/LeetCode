//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
// Related Topics 哈希表 链表 双指针 
// 👍 1409 👎 0


package Problem.leetcode.editor.cn;
public class LinkedListCycleIi{
    public static void main(String[] args){
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast!=null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){ // 第一次相遇，证明存在环
                    ListNode index1 = head;
                    ListNode index2 = slow; // 或者fast
                    while (index1!=index2){ // 跳出循环时就是环的入口
                        index1 = index1.next;
                        index2 = index2.next;
                    }
                    return index1; // 或者index2
                }
            }
            return null; // 若快指针跳出外层则说明没有环
        }

        public ListNode detectCycle2(ListNode head) {
           ListNode slow = head;
           ListNode fast = head;
           while (fast!=null && fast.next != null){
               fast = fast.next.next;
               slow = slow.next;
               if (fast == slow){ // 找到相遇点
                   slow = head; // slow负责从头节点开始
                   while (fast != slow){ // 一步一步往后遍历
                       fast = fast.next;
                       slow = slow.next;
                   }
                   return fast; // 跳出循环说明已经找到入口直接返回即可
               }
           }
           return null; // 退出循环表示没有环（fast到达了尽头）
        }

        public ListNode detectCycle3(ListNode head) {
            // 1.定义快慢指针，找到两个指针的交点
            ListNode fast = head;
            ListNode slow = head;
            while (fast!=null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                // 2.一个指针重新开始从链表开始遍历，另一个指针从交点开始遍历，每次遍历只走一步，当指针相遇时找到环入口
                if (fast == slow) { // 找到相遇点
                    fast = head;
                    while (fast!=slow){
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }

    /**
     * 审题：返回的节点是环形链表开始的节点，head为无头结点
     * 思路1：快慢指针。检验环只需要使用一次双指针即可，而想要检测环的入口就必须要首先找到相遇的点，然后在从相遇点和起点同步移动，再次相遇时才会是环入口
     *      时间复杂度：O(n)，空间复杂度：O(1)
     */
//leetcode submit region end(Prohibit modification and deletion)

}