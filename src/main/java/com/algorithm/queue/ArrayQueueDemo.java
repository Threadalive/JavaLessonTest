package com.algorithm.queue;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/12/10 15:40
 */
public class ArrayQueueDemo {
    public static void main(String args[]) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);

        queue.showQueue();
        System.out.println(queue.showHead());

        System.out.println(queue.getQueue());

        System.out.println(queue.showHead());
        queue.showQueue();
    }
}

/**
 * @author zhenxing.dong
 * @Description 数组模拟队列
 */
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        //尾指针后移
        rear++;

        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法取值");
        }

        front++;

        return arr[front];
    }

    public void showQueue() {
        for (int i = front + 1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法取值");
        }
        return arr[front + 1];
    }
}