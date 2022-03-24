//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, sk
//ipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 
// 👍 157 👎 0


package Problem.leetcode.editor.cn;


public class IntersectionOfTwoLinkedListsLcci{
    public static void main(String[] args){
        Solution solution = new IntersectionOfTwoLinkedListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode curA = headA;
            ListNode curB = headB;
            int lenA = 0;
            int lenB = 0;
            while (curA!=null) {
                curA = curA.next;
                lenA++;
            }
            while (curB!=null) {
                curB = curB.next;
                lenB++;
            }
            curA = headA;
            curB = headB;
            // 这里假设A链表比B链表长，若存在B比A长时，交换两者身份数据
            if (lenA < lenB){
                // 让A链表为最长的那个
                ListNode t = curA;
                curA = curB;
                curB = t;
                // 让A长度为最长的那个、
                int max = lenA;
                lenA = lenB;
                lenB = max;
            }
            int size = lenA - lenB; // 链表A需要移动的位数
            // 末尾对齐时，找到重新找到A链表对应地B链表的头节点位置
            while (size != 0){
                curA = curA.next;
                size--;
            }
            // 从对其后的节点开始比较相同节点
            while (curB != null){
                if (curA == curB) return curA;
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }




        // 两次遍历
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
            int len_a = 0;
            int len_b = 0;
            ListNode ha = headA;
            ListNode hb = headB;

            // 分别遍历两个链表，得到其对应的长度
            while (ha!=null){
                ha = ha.next;
                len_a++;
            }
            while (hb!=null){
                hb = hb.next;
                len_b++;
            }
            // 这里特别注意：因为接下来还需要使用该节点进行重新遍历，所以需要该指针还原
            ha = headA;
            hb = headB;

            // 默认headA长度大于headB长度，否则两个链表处理数据交换
            if (len_a<len_b){
                // 交换链表
                ListNode t = ha;
                ha = hb;
                hb = t;
                // 交换长度
                int n = len_a;
                len_a = len_b;
                len_b = n;
            }

            // 到这里表示headA肯定是最长的链表，所以headA需要对齐headB
            for (int i = 0; i < len_a - len_b; i++) {
                ha = ha.next;
            }

            // 开始比对指针ha和指针hb，若不相同则继续往后遍历，找到相同说明找到了链表相交的入口
            while (ha!=null){
                if (ha == hb) return ha;
                ha = ha.next;
                hb = hb.next;
            }
            return null; // 退出循环表示没有找到链表相交入口
        }

        // 三刷
        public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
            // 1.首先分别遍历两个链表，分别求取两个链表的长度
            int len_a = 0;
            int len_b = 0;
            ListNode firstA = headA;
            ListNode firstB = headB;
            while (firstA!=null){
                firstA = firstA.next;
                len_a++;
            }
            while (firstB!=null){
                firstB = firstB.next;
                len_b++;
            }
            // 2.两个末尾节点对齐，选取较短的链表的头节点作为遍历两个链表的起点

            // 假设len_a长度大于len_b（否则将较长的那个链表数据进行交换）

            // 重置两个链表的头节点
            firstA = headA;
            firstB = headB;
            if (len_a <= len_b){
                int max = len_a;
                len_a = len_b;
                len_b = max;

                ListNode t = firstA;
                firstA = firstB;
                firstB = t;
            }

            int n = len_a - len_b; // n为长链表头对齐短链头结点的移动次数
            while (n > 0){
                firstA = firstA.next;
                n--;
            }
            // 3.同时遍历两个链表，当两个链表的指针相同时，找到链表的起始节点
            while (firstA != firstB){
                firstA = firstA.next;
                firstB = firstB.next;
            }
            return firstA; // 若first为null则表示没有入口，反之有入口
        }
    }

    /**
     * 审题：节点长度可以是0，返回相交的节点作为相同链表的头节点；首个相交节点后的所有节点都必定是相同的
     * 思路1：首先求取AB链表的长度，因为首个相交节点后的所有节点都必定是相同的，所以让AB链表的末尾对齐，然后长链表的队头和短链表的队头位置相同
     *      两个链表后面从头开始判断，当指针相同时（不是值相同）表示找到该相交的节点，然后返回该节点，当遍历到末尾时，没有找到两者共同指针则返回null
     */
//leetcode submit region end(Prohibit modification and deletion)

}