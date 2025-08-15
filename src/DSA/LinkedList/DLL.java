package DSA.LinkedList;

public class DLL {
    private Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
//        node.next = null;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val  + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Printing in reverse");
        while (last != null) {
            System.out.print(last.val  + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}