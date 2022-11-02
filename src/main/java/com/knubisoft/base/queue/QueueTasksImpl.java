package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.*;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        Integer data = queue.peek();
        queue.remove();
        queue = reverseQueueUsingRecursion(queue);
        queue.add(data);
        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        return new LinkedList<>(new TreeSet<>(queue));
    }

    @Override
    public boolean validParentheses(String parentheses) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char x = parentheses.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                deque.push(x);
            }
            if (deque.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = deque.pop();
                    if (check == '{' || check == '[') return false;
                    break;
                case '}':
                    check = deque.pop();
                    if (check == '(' || check == '[') return false;
                    break;
                case ']':
                    check = deque.pop();
                    if (check == '(' || check == '{') return false;
                    break;
            }
        }
        return deque.isEmpty();
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>(new CarComparator());
        priorityQueue.addAll(cars);
        return priorityQueue;
    }

}
