//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 哈希表 链表 双指针 
// 👍 1336 👎 0


package Problem.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

public class LinkedListCycle{
    public static void main(String[] args){
        Solution solution = new LinkedListCycle().new Solution();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        ListNode l5 = new ListNode(2);
        l1.next =l2;
        l2.next =l3;
        l3.next =l4;
        l4.next =l5;
        l5.next =l5;

        System.out.println("solution.hasCycle(l1) = " + solution.hasCycle(l1));

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
            }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head==null||head.next==null) return false;
            HashMap map = new HashMap<>(); // 节点为k，后一个节点为v
            ListNode t = head;
            while (t.next!=null){
                if (map.get(t.next)!=null) return true; // 取出v，判断v的后一个节点是否是存在的k（某个键值对的v连接到某个键值对的k，则表示有换）
                map.put(t,t.next);
                t=t.next;
            }
            return false;
        }

        // 快慢指针
        public boolean hasCycle2(ListNode head) {
            if (head==null||head.next==null) return false;

            ListNode slow = head;
            ListNode fast = head;

            // 因为快指针比慢指针要走得快，所以快指针肯定可以先走到环的末端，所以需要使用快指针来判断前路
            while (fast != null && fast.next!=null){ // 这里还有一个坑：快指针要走两步，所以需要保证fast.next也要不为空，否则空指针
                fast = fast.next.next;
                if (fast == slow) return true;
                slow = slow.next;
            }
            return false;
        }
    }
    /**
     * 思路1（暴力解法）：通过设置哈希表来记录每一个指针走过的节点，并且每走一步就先用哈希表获取该节点是否存在（也就是是否有键值对），如果没有就添加到哈希表中
     *      这里为什么要选择哈希表存储?因为需要直接获取到数据，使用哈希表是比较快的（节点与下一个节点其实就刚好构成一个键值对）
     * 思路2（快慢指针法）：快指针走两步，而慢指针走一步，当出现循环时，也就是快指针已经跑完一圈从后面追上慢指针时，就表示有环
     */
}