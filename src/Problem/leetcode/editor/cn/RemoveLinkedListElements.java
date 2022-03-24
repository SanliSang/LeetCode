//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 812 👎 0


package Problem.leetcode.editor.cn;

import java.util.List;

public class RemoveLinkedListElements{
    public static void main(String[] args){
        Solution solution = new RemoveLinkedListElements().new Solution();
        System.out.println(solution.removeElements2(solution.getList(new int[]{7, 7, 7, 7}), 7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    /**
     * 不设置虚拟头节点方式
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 需要特殊处理头节点恰好是待删除的节点的情况
        while(head!=null && head.val == val){
            head = head.next;
        }
        ListNode t = head;
        while(t!=null){ // 常规删除操作
            if(t.next != null && t.next.val == val){
                t.next = t.next.next;
            }else t = t.next;
        }
        return head;
    }

    /**
     * 设置虚拟头节点的方式
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode first = new ListNode();
        first.val = -1;
        first.next = head;

        ListNode t = first;
        while (t.next != null){
            if (t.next.val == val){
                t.next = t.next.next;
            }else t = t.next;
        }
        return first.next;
    }

    // 二刷
    public ListNode removeElements3(ListNode head, int val){
        // 设置虚拟头节点（方便处理头节点恰好是要删除的元素的情况）
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode t = node;
        while (t.next!=null){
            if (t.next.val == val){
                t.next = t.next.next;
            }else t = t.next;
        }
        return node.next;
    }

    // 二刷
    public ListNode removeElements4(ListNode head, int val){
        while (head!=null && head.val == val){
            head = head.next;
        }
        ListNode t = head;
        while (t != null){
            if (t.next != null && t.next.val == val){
                t.next = t.next.next;
            }else t = t.next;
        }
        return head;
    }

        class ListNode {
           int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }

            @Override
            public String toString() {
                return "ListNode{" +
                        "val=" + val +
                        ", next=" + next +
                        '}';
            }
        }

    private ListNode getList(int[] arr){
        ListNode node = new ListNode();
        ListNode first = node;
        node.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            node.next = listNode;
            node = listNode;
        }
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}