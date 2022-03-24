//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 1157 👎 0


package Problem.leetcode.editor.cn;

import java.util.Stack;

/**
 * 使用栈的原因就是：需要解题的要求具有->最近相关性
 */
public class MinStack{
    public static void main(String[] args){
        minStack minStack = new minStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minStack.getMin() = " + minStack.getMin());
        minStack.pop();
        System.out.println("minStack.top() = " + minStack.top());
        System.out.println("minStack.getMin() = " + minStack.getMin());

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class minStack {
        /*
        时间复杂度
        private Stack<Integer> stack = new Stack();
        private LinkedList<Integer> list = new LinkedList<>();

        public void push(int val) {
            stack.push(val);
            if (list.isEmpty()){
                list.add(val);
                return;
            }
            Iterator<Integer> iterator = list.iterator();
            int index = 0;
            while (iterator.hasNext()){
                if (val<iterator.next()){  // 若val比链表的节点值还要小，则将该链表节点加载该节点值的前面
                    list.add(index,val);
                    return;
                }
                index++;
            }
            list.add(val); // val为当前链表最大值时，就直接将节点加在末尾
        }

        public void pop() {
            Integer pop = stack.pop();
            list.remove(pop); // 删除指定的栈顶元素
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return list.getFirst();
        }

         */
        /**
         * 关键核心：如何找到最小值
         * 思路1（暴力解法）：直接遍历整个栈来找到最小值（时间复杂度O(n)）
         * 思路2（时间换空间）：通过链表来记录每个最小值或用最小堆来维护最小值（时间复杂度O(1)，空间复杂度O(n)）
         * 思路3（辅助栈）：一个栈作为数据栈，而另一个栈作为数据栈存储压入节点时，当前数据栈中最小的节点（维护当前时间结点的最小值）
         */
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();
        public void push(int val) {
            dataStack.push(val);
            if (!minStack.isEmpty()){
                Integer min = minStack.peek();
                if (val<min) minStack.push(val); // 压入新的当前节点最小值
                else minStack.push(min); // 压入旧的最小值
            }else minStack.push(val); // 若栈空则直接压入
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}