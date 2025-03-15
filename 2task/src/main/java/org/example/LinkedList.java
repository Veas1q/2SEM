package org.example;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        private T value;
        private Node prev;
        private Node next;

        public Node(T value){
            this.value = value;
        }

    }
    public void addIn(T value, int index){
        Node newNode = new Node(value);
        int count = 0;
        Node current = head;
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("выход за пределы списка");
        }else{
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
//            19234
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            ++size;

        }
        size++;

    }
    public void addFirst (T value){
        Node newNode = new Node(value);
        if (head == null){
            head = tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        ++size;
    }
    public void addLast (T value){
        Node newNode = new Node(value);
        if (tail == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        ++size;
    }
    public int size(){
        return size;
    }
    public void removeLast(){
        if (tail == null){
            throw new IllegalStateException("Двусвязный список пуст");
        }else {
            tail = tail.prev;
            if (tail.prev == null){
                head = null;
            }else {
                tail.next = null;
                --size;
            }
        }

    }
    public void removeFirst(){
        if (head == null){
            throw new IllegalStateException("Двусвязный список пуст");
        }else {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
                --size;
            }
        }
    }
    public void get(int index){
        int count = 0;
        Node n = head;
        if ( index > size || index < 0){
            throw new IndexOutOfBoundsException("Выход за пределы списка");
        }else {
            for (int i = 0; i < index ; i++) {
                n = n.next;
            }
            System.out.println(n.value);
        }
    }
    public void print(){
        Node current = head;
        while (current != null){
            System.out.println(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void getNext(int index){
        int count = 0;
        Node n = head;
        if ( index > size || index < 0){
            throw new IndexOutOfBoundsException("Выход за пределы списка");
        }else {
            for (int i = 0; i < index ; i++) {
                n = n.next;
            }
            System.out.println(n.next.value);
        }
    }
}
