package AISD4;

public class rec {
    public static class Node<T> {
        T value;
        Node<T> next;  // Добавлен generic тип для next

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class CastList<T> {
        private Node<T> head;
        private Node<T> tail;

        public void add(T value) {
            Node<T> newNode = new Node<>(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void print() {
            Node<T> current = head;
            while(current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }
}
//Node reverse(Node currenet){
//    if (currenet == null || currenet.next == null){
//        return currenet;
//    }
//    Node newHead = reverse(currenet.next);
//    currenet.next.next = currenet;
//    currenet.next = null;
//
//    return newHead;
//}