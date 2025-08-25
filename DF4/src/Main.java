public class Main {

    public static void main(String[] args) {
        Circle myCircle = new Circle("circle", 10);
        Rectangle myRectangle = new Rectangle("Rectangle", 20, 20);
        Square mySquare = new Square("Square",10);

        System.out.println(myCircle.toString());
        System.out.println(myRectangle.toString());
        System.out.println(mySquare.toString());


    }
}
