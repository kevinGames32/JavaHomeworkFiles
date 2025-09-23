import java.util.List;

    public class singlyLinkedList {

        private Node head;
        private Node tail;

        public singlyLinkedList() {
            head = null;
            tail = null;
        }

        public void appendNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                Node LastElement = tail;
                LastElement.next = newNode;
                tail = newNode;
            }
        }
        public void prepend(int data){
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                Node firstElemet = head;
                head = newNode;
                newNode.next = firstElemet;
            }
        }

        public void insertAfter(int currentItem, int newItem) {
            Node afterNode = searchNode(currentItem);
            if (afterNode != null) {
                Node newNode = new Node(newItem);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else if (afterNode == tail) {
                    tail.next = newNode;
                    tail = newNode;
                } else {
                    newNode.next = afterNode.next;
                    afterNode.next = newNode;
                }
            }


        }


        public Node searchNode(int item) {
            Node current = head;
            while (current.next != null) {
                if (current.data == item) {
                    return current;
                } else {
                    current = current.next;
                }
            }
            return null;
        }

        public boolean remove(int item) {
            Node current = head;
            Node previous = null;

            while (current != null) {
                if (current.data == item) {
                    // remove head
                    if (previous == null) {
                        head = current.next;
                        if (head == null) {
                            tail = null;     // list became empty
                        }
                    } else {
                        // remove middle/tail
                        previous.next = current.next;
                        if (current.next == null) {
                            tail = previous; // removed last node
                        }
                    }
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

        public void toStringLinkedList(){
            Node current = head;
            while(current != null ){
                System.out.println(current.data);
                current = current.next;
            }
        }

    static class Node{
        int data;
        Node next;

        public Node(int data){
                this.data = data;
        }

    }


}