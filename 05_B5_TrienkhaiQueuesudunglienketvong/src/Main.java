public class Main {
    public static void main(String args[]) {
        Solution solution = new Solution();
        Queue q = new Queue();
        q.front = q.rear = null;

        solution.enQueue(q, 14);
        solution.enQueue(q, 22);
        solution.enQueue(q, 6);

        solution.displayQueue(q);

        System.out.printf("Deleted value = %d", solution.deQueue(q));
        System.out.printf("Deleted value = %d", solution.deQueue(q));

        solution.displayQueue(q);

        solution.enQueue(q, 9);
        solution.enQueue(q, 20);
        solution.displayQueue(q);

    }
}
