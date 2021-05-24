import java.util.*;

public class Solution {

    public void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.setData(value);
        if (q.front == null)
            q.front = temp;
        else
            q.rear.setLink(temp);

        q.rear = temp;
        q.rear.setLink(q.front);
    }

    public int deQueue(Queue q) {
        if (q.front == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int value;
        if (q.front == q.rear) {
            value = q.front.getData();
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.getData();
            q.front = q.front.getLink();
            q.rear.setLink(q.front);
        }

        return value;
    }

    public void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.printf("Elements in Circular Queue are: ");
        while (temp.getLink() != q.front) {
            System.out.printf("%d ", temp.getData());
            temp = temp.getLink();
        }
        System.out.printf("%d", temp.getData());
    }

}
