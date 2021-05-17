import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class 包含min函数的栈 {
    Stack<Integer> stack_data;
    Stack<Integer> stack_min;

    public 包含min函数的栈() {
        stack_data = new Stack();
        stack_min = new Stack();
    }

    public void push(int x) {
        stack_data.push(x);
        if (stack_min.size() == 0 || x < stack_min.peek()) {
            stack_min.push(x);
        } else {
            stack_min.push(stack_min.peek());
        }
    }

    public void pop() {
        stack_data.pop();
        stack_min.pop();
    }

    public int top() {
        return stack_data.peek();
    }

    public int min() {
        return stack_min.peek();
    }
}
