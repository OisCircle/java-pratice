package algorithm.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

        System.out.println();
        System.out.println();

        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.pop());
        System.out.println(stack1.top());

    }

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private boolean elementsInQueue1;
    private int count;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        elementsInQueue1 = true;
        count = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (elementsInQueue1) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
        count++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (count <= 0) {
            return -1;
        }
        exchange();
        count--;
        return elementsInQueue1 ? queue2.poll() : queue1.poll();
    }

    private void exchange() {
        int rest = count - 1;
        while (rest-- > 0) {
            if (elementsInQueue1) {
                queue2.offer(queue1.poll());
            } else {
                queue1.offer(queue2.poll());
            }
        }
        elementsInQueue1 = !elementsInQueue1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (count <= 0) {
            return -1;
        }
        exchange();
        int top;
        if (elementsInQueue1) {
            top = queue2.poll();
            queue1.offer(top);
        } else {
            top = queue1.poll();
            queue2.offer(top);
        }
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return count <= 0;
    }
}