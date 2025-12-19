abstract class Shape {
    int x;
    int y;

    // Abstract method
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        x = length;
        y = breadth;
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (x * y));
    }
}

// Triangle class
class Triangle extends Shape {

    Triangle(int base, int height) {
        x = base;
        y = height;
    }

    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * x * y));
    }
}

// Circle class
class Circle extends Shape {

    Circle(int radius) {
        x = radius;
    }

    void printArea() {
        System.out.println("Area of Circle = " + (3.14 * x * x));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Shape r = new Rectangle(10, 5);
        Shape t = new Triangle(6, 4);
        Shape c = new Circle(7);

        r.printArea();
        t.printArea();
        c.printArea();
    }
}

