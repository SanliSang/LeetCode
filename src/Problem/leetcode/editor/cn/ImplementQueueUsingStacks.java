//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）： 
//
// 实现 MyQueue 类： 
//
// 
// void push(int x) 将元素 x 推到队列的末尾 
// int pop() 从队列的开头移除并返回元素 
// int peek() 返回队列开头的元素 
// boolean empty() 如果队列为空，返回 true ；否则，返回 false 
// 
//
// 说明： 
//
// 
// 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法
//的。 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用 100 次 push、pop、peek 和 empty 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
// 
// Related Topics 栈 设计 队列 
// 👍 601 👎 0


package Problem.leetcode.editor.cn;

import java.util.Stack;

public class ImplementQueueUsingStacks{
    public static void main(String[] args){
        MyQueue solution = new ImplementQueueUsingStacks().new MyQueue();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        System.out.println(solution.pop()); // 查看队头元素 1
        solution.push(5);
        System.out.println(solution.pop()); // 2
        System.out.println(solution.pop()); // 3
        System.out.println(solution.pop()); // 4
        System.out.println(solution.pop()); // 5
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        private Stack<Integer> s1; // 栈a（用于入队）
        private Stack<Integer> s2; // 栈b（用于出队）

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) { // 直接进栈即可
            s1.push(x);
        }

        public int pop() { // 因为要出栈的元素被其他元素堆积着，所以需要弹出s1的所有元素给s2，这个时候恰好s2栈顶元素就是要弹出的元素
            swap();
            return s2.pop();
        }

        public int peek() { // 和pop原理类似
            swap();
            return s2.peek();
        }

        public boolean empty() { // 两个栈同时为空则说明队列空
            return s1.isEmpty() && s2.isEmpty();
        }

        private void swap(){
            if (s2.isEmpty()){
                while (!s1.isEmpty()) s2.push(s1.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

/**
 * 审题：每个操作均摊时间复杂度为O(1)的队列，队列中每个操作都是有效地，只可以使用标注的栈来进行实现（只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的）
 * 思路1：双栈实现。在push数据的时候，只要数据放进输入栈就好，但在pop的时候，操作就复杂一些，输出栈如果为空，就把进栈数据全部导入进来（注意是全部导入），再从出栈弹出数据，如果输出栈不为空，则直接从出栈弹出数据就可以了。
 */
//leetcode submit region end(Prohibit modification and deletion)

}