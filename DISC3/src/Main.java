
    //-------------------Content of Main.java------------------------------
    class TwoDShape{
        //This class provides a generic prototype for any two dimensional shape!
        protected String name;
        @Override
        public String toString(){
            return "Generic shape named " + name + " with size " + size();
        }
        public double size(){//this method will be overridden by children of class TwoDShape
            return Double.NaN;
        }
        public TwoDShape(String name){this.name = name;}
    }
    class Rectangle extends TwoDShape{
        //This class represents a rectangle!
        private double width, height;
        @Override
        public String toString(){
            return String.format("Rectangle named %s with area %.2f.", name, size());
        }
        @Override
        public double size(){
            return width * height;//size is defined as the area of rectangle!
        }
        public Rectangle(String name, double width, double height){
            super(name);
            this.width = width;
            this.height = height;
        }
    }
    class Square extends Rectangle{
        //This class represents a square! Square is a special Rectangle...
        //...whose width and height are the same!
        @Override
        public String toString(){
            return String.format("Square named %s with area %.2f.", name, size());
        }
        public Square(String name, double side){
            super(name, side, side);
        }
    }
    class Circle extends TwoDShape{
        //this class represents a circle!
        private double radius;
        @Override
        public double size(){//area of circle
            return Math.PI * radius * radius;
        }
        @Override
        public String toString(){
            return String.format("circle named %s with area %.2f.", name, size());
        }

        public Circle(String name, double radius){
            super(name);
            this.radius = radius;
        }
        public Circle(){
            super("random unit radius");
            this.radius = 1.0;
        }
    }
    //Main class to test previous ones... Only this class is public
    public class Main{
        public static void main(String[] args){
            TwoDShape[] list = {new TwoDShape("Heart"), //item#0
                    new Rectangle("Window", 6.0, 4.0),//item#1
                    new Square("Chess Board", 5.0),//item#2
                    new Circle("Clock Dial", 2.5)//item#3
            };
            for(TwoDShape shape: list){
                System.out.println(shape);
                //In the above line, call to toString method is implicit;
                //i.e. shape.toString() is called automatically by the compiler!
            }
        }
    }

