public class MyDequeue {
    int[] myqueue;
    int front;
    int rear;
    int size;
    int capacity;

    public MyDequeue(int k) {
        this.myqueue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if(rear==front && size == capacity)
            return false;
        else {
            front = (front + capacity -1)% capacity;
            myqueue[front] = value;
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if(rear==front && size == capacity)
            return false;
        else {
            myqueue[rear] = value;
            rear = (rear+1+capacity)%capacity;
            size++;
            return true;
        }

    }

    public boolean deleteFront() {
        if( rear == front && size == 0) return false;
        else {
            front = (front+1) % capacity;
            size--;
            return true;
        }

    }

    public boolean deleteLast() {
        if( rear == front && size == 0)
            return false;
        else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

    }

    public int getFront() {
        if((rear == front) && size==0)
            return -1;
        else {
            int frontE = myqueue[front];
            return frontE;
        }
    }

    public int getRear() {
        if((rear == front) && size==0) return -1;
        else {
            int rearE = myqueue[(rear-1+capacity)%capacity];
            return rearE;
        }

    }

    public boolean isEmpty() {
        return (rear == front) && size==0;
    }

    public boolean isFull() {
        return rear==front && size == capacity;

    }
}