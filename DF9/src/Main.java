
public class Main {
    public static void main(String[] args){
        singlyLinkedList List1 = new singlyLinkedList();
        List1.appendNode(43);
        List1.appendNode(63);
        List1.appendNode(41);
        List1.appendNode(55);
        List1.prepend(1);
        List1.insertAfter(1,2);
        List1.remove(55);
        List1.toStringLinkedList();
    }
}
