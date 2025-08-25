class Example {
    // Overloaded methods with different signatures
    public void display(int a) {
        System.out.println("Integer: " + a);
    }

    public void display(double a) {
        System.out.println("Double: " + a);
    }

    public void display(int a, double b) {
        System.out.println("Integer: " + a + " and Double: " + b);
    }
}