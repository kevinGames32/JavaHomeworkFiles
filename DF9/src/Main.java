
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> Numbers= new LinkedList<Integer>();


        for (int i = 0; i < 100; i++) {
            Numbers.add(i+1);
        }
        System.out.println();
        System.out.println("Start of the Linked List Part");
        ListIterator<Integer> iterator = Numbers.listIterator();

        int loopCounter = 0;
        while (iterator.hasNext()) {
            int num = iterator.next();
            if(num%2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("List of all numbers with every other element removed" + Numbers);

        ListIterator<Integer> ReverseIterator = Numbers.listIterator(Numbers.size());

        LinkedList<Integer> Numbers2 = new LinkedList<>();
        while (ReverseIterator.hasPrevious()) {
            Numbers2.add(ReverseIterator.previous());
        }
        System.out.println("List of previous list reversed: " + Numbers2);
        System.out.println("end of the Linked List Part");
        System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("Start of the Array List Part");

        ArrayList<Integer> MyIntArray = new ArrayList<>();
        for (int i = 1; i <100 ; i++) {
            MyIntArray.add(i);
        }
        iterator = MyIntArray.listIterator();

        while (iterator.hasNext()){
            int num = iterator.next();
            if(num%2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("List of numbers with every other number removed" + MyIntArray);

        iterator = MyIntArray.listIterator(MyIntArray.size());
        ArrayList<Integer> MyIntArrayReversed = new ArrayList<>();
        while (iterator.hasPrevious()){
            MyIntArrayReversed.add(iterator.previous());
        }
        System.out.println("List of numbers with every other number removed and reversed" + MyIntArrayReversed);
        System.out.println("End of Array list part");



    }
}