import java.awt.*;

public class Circle extends PlanarShape {
    private double radius;
    final double pi = 3.1416;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return pi * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * pi * radius;
    }
}
