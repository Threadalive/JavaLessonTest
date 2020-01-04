package com.algorithm.queue;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/12/10 16:39
 */
public class CircleArrayQueueDemo {
    public static void main(String args[]){
        CircleArray queue = new CircleArray(4);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);


        queue.showQueue();

        System.out.println(queue.showHead());

        System.out.println(queue.getQueue());

        queue.addQueue(4);
        queue.showQueue();

    }
}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        arr[rear] = n;

        rear = (rear+1)%maxSize;
    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取值");
        }
        int value = arr[front];

        front = (front+1)%maxSize;

        return value;
    }

    public void showQueue(){
        for(int i = front; i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i]);
        }
    }

    public int size(){
        return (rear-front+maxSize)%maxSize;
    }

    public int showHead(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取值");
        }
        return arr[front];
    }
}
