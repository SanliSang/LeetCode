//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 数组 链表 
// 👍 107 👎 0


package Problem.leetcode.editor.cn;
public class DesignCircularDeque{
    public static void main(String[] args){
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 总结：循环双端队列是循环队列的增强版，增强在于指针可以往前移动
     *      指针index后移公式：(index+1)%len
     *      指针index前移公式：(index-1+len)%len
     *      判空公式：front == rear
     *      判满公式：front == (rear+1)%len // rear从尾部追上front
     *      特别注意：队列要多一个空余的位置出来区分判空与判满
     */
    class MyCircularDeque {
        private int[] deque = null;
        private int len;
        private int front = 0; // 指向队头元素（插入向前走，删除向后走）
        private int rear = 0; // 指向队列尾元素的下一个位置（插入向后走，删除向前走）

        // 队头先赋值后后走，而队尾先赋值再走

        public MyCircularDeque(int k) {
            deque = new int[k+1];
            len = deque.length;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = (front - 1 + len) % len; // front指针向前移动-1后取模
            deque[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            deque[rear] = value;
            rear = (rear+1)%len;
            return true;
        }

        // 队头直接走，可以等待下一次赋值时候覆盖（惰性删除）
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front+1)%len;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + len) % len;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : deque[front]; // 因为队头直接指向队头元素所以直接返回
        }

        public int getRear() {
            return isEmpty() ? -1 : deque[(rear - 1 + len) % len];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return front == (rear+1)%len; // 若rear从后面追上front则表示满
        }
        /**
         * 思路（数组实现）：可以直接通过下标计算的方式完成循环的双端队列，如果使用链表的方式也可以实现，但需要消耗额外存储指针的空间大小。
         */
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}