//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 
// 👍 364 👎 0


package Problem.leetcode.editor.cn;
public class DesignLinkedList{
    public static void main(String[] args){
        /**
         *
         ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead",
         "addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
         [[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
         */
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);

        System.out.println("顺序打印");
        list.order();
        System.out.println("逆序打印");
        list.reorder();

        System.out.println("list.get(1) = " + list.get(1));
        list.deleteAtIndex(1);
        System.out.println("list.get(1) = " + list.get(1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyLinkedList {

        private Node head;
        private Node tail;
        private int len;

        public MyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.pre = head;
            len = 0;
        }

        /**
         * 返回第n个节点，节点编号应该从0计算
         * 若从头节点开始遍历，index=0则遍历1次，index=2则遍历2次，以此类推
         * 若从尾节点开始遍历，index=0则遍历1次，index=2则遍历2次，以此类推
         * @param index
         * @return
         */
        public int get(int index) {
            if(index < 0 || index >= len){return -1;}
            Node cur = head;

            // 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
            if(index < (len - 1) / 2){ // 从头结点开始遍历
                for(int i = 0; i <= index; i++){
                    cur = cur.next;
                }
            }else{ // 从尾节点开始遍历（要注意边界条件，最好自己简单画一个示意图）
                cur = tail;
                for(int i = 0; i <= len - index - 1; i++){
                    cur = cur.pre;
                }
            }
            return cur.val;
        }


        public void addAtHead(int val) {
            Node t = new Node(val);
            t.next = head.next;
            head.next.pre = t;
            head.next = t; //
            t.pre = head;
            len++;
        }

        public void addAtTail(int val) {
            Node t = new Node(val);
            t.next = tail;
            t.pre = tail.pre;
            tail.pre.next = t;
            tail.pre = t;
            len++;
        }

        /**
         * 为了更好记忆，实现思路应该使用统一，比如从头节点还是遍历还是头节点的后一个节点开始遍历
         * @param index
         * @param val
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }else if (index == len){
                addAtTail(val);
                return;
            }

            Node t = head; // 从头节点开始遍历
            Node node = new Node(val);
            for (int i = 0; i < index; i++) { // 遍历到要插入节点的前一个节点，所以不用写等号
                t = t.next;
            }
            node.next = t.next;
            t.next.pre = node;
            node.pre = t;
            t.next = node;
            len++;
        }

        /**
         * 为了更好记忆，实现思路应该使用统一，比如从头节点还是遍历还是头节点的后下一个节点开始遍历
         * @param index
         */
        public void deleteAtIndex(int index) {
            if (len <= 0 || index < 0) return;
            Node t = head;
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
            t.next.next.pre = t;
            t.next = t.next.next;
            len--;
        }

        class Node{
            Node next;
            Node pre;
            int val;

            public Node() {
            }

            public Node(int val) {
                this.val = val;
            }

            public Node(Node next, Node pre, int val) {
                this.next = next;
                this.pre = pre;
                this.val = val;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "next=" + next +
                        ", pre=" + pre +
                        ", val=" + val +
                        '}';
            }
        }

        /**
         * 审题：链表设计关键在于如何把控边界条件和遍历条件
         */
    }


    static class MyLinkedList2 {

        private Node2 head;
        private Node2 tail;
        private int len;

        public MyLinkedList2() {
            head = new Node2(-1);
            tail = new Node2(-1);
            head.next = tail;
            tail.pre = head;
            len = 0;
        }

        /**
         * 返回第n个节点，节点编号应该从0计算
         * 若从头节点开始遍历，index=0则遍历1次，index=2则遍历2次，以此类推
         * 若从尾节点开始遍历，index=0则遍历1次，index=2则遍历2次，以此类推
         * 若len为奇数时，中间值从head处理
         * @param index
         * @return
         */
        public int get(int index) {
            if(index < 0 || index >= len){return -1;}
            Node2 node = head;
            if ((len-1)/2 < index){ // 从head开始遍历
                for (int i = 0; i <= index; i++) {
                    node = node.next;
                }
            }else { // 从tail开始遍历
                node = tail;
                for (int i = 0; i <= len-index-1; i++) {
                    node = node.pre; // 往前遍历
                }
            }
            return node.val;
        }


        public void addAtHead(int val) {
            Node2 n = head.next;
            Node2 t = new Node2(val);
            head.next = t;
            t.pre = head;
            n.pre = t;
            t.next = n;
            len++;
        }

        public void addAtTail(int val) {
            Node2 n = tail.pre;
            Node2 t = new Node2(val);
            tail.pre = t;
            t.next = tail;
            n.next = t;
            t.pre = n;
            len++;
        }

        /**
         * 为了更好记忆，实现思路应该使用统一，比如从头节点还是遍历还是头节点的后一个节点开始遍历
         * 指针指向是在要添加的节点的前面一个位置还是直接指向要添加的位置
         * @param index
         * @param val
         */
        public void addAtIndex(int index, int val) {
            if(index > len) return;
            if(index < 0) index = 0;
            Node2 t = head; // 从头节点开始遍历
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
            Node2 n = new Node2(val);
            n.next = t.next;
            t.next.pre = n;
            t.next = n;
            n.pre = t;
            len++;
        }

        /**
         * 为了更好记忆，实现思路应该使用统一，比如从头节点还是遍历还是头节点的后下一个节点开始遍历
         * @param index
         */
        public void deleteAtIndex(int index) {
            if(index >= len || index < 0) return;
            Node2 t = head;
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
            Node2 n = t.next;
            t.next = n.next;
            n.next.pre = t;
            len--;
        }

        public void order(){
            for (Node2 n = head; n!=null; n=n.next) {
                System.out.print(n.val+" ");
            }
            System.out.println();
        }

        public void reorder(){
            for (Node2 n = tail; n!=null; n=n.pre) {
                System.out.print(n.val+" ");
            }
            System.out.println();
        }

        class Node2{
            Node2 next;
            Node2 pre;
            int val;

            public Node2() {
            }

            public Node2(int val) {
                this.val = val;
            }

            public Node2(Node2 next, Node2 pre, int val) {
                this.next = next;
                this.pre = pre;
                this.val = val;
            }

            @Override
            public String toString() {
                return "Node2{" +
                        "next=" + next +
                        ", pre=" + pre +
                        ", val=" + val +
                        '}';
            }
        }

        /**
         * 审题：链表设计关键在于如何把控边界条件和遍历条件
         */
    }



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}