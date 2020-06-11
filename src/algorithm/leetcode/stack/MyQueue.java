package algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author O
 * @since 2020/3/24
 */
public class MyQueue {
    public static void main(String[] args) {
        final MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());;  // 返回 1
        System.out.println(queue.pop());;   // 返回 1
        System.out.println(queue.empty());; // 返回 false
    }

    private Stack<Integer> in;
    private Stack<Integer> out;
    private boolean inputStatus;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
        inputStatus = true;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (!inputStatus) {
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            inputStatus = true;
        }
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (inputStatus) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            inputStatus = false;
        }
        return out.isEmpty() ? -1 : out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (inputStatus) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            inputStatus = false;
        }
        return out.isEmpty() ? -1 : out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}