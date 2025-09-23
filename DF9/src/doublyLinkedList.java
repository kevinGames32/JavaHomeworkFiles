public class doublyLinkedList<T> {
    private doublyLinkedNode<T> head;
    private doublyLinkedNode<T> tail;

    public doublyLinkedList(){
        head = null;
        tail = null;
    }

    public static class doublyLinkedNode<T>{
        T data;
        doublyLinkedNode<T> next;
        doublyLinkedNode<T> previous;

        private doublyLinkedNode(T data){
            this.data = data;
            next = null;
            previous = null;
        }
    }

    public void appendItem(T item){
        appendNode(new doublyLinkedNode<>(item));
    }

    private void appendNode(doublyLinkedNode<T> newNode){
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void prepend(T item){
        prependNode(new doublyLinkedNode<>(item));
    }

    private void prependNode(doublyLinkedNode<T> newNode){
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public doublyLinkedNode<T> search(T data){
        doublyLinkedNode<T> current = head;
        while(current != null){
            if(current.data == data){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sort(){


    }



}
