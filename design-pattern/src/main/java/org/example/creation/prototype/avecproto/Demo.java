package org.example.creation.prototype.avecproto;

public class Demo {


    public static void main(String[] args) {
        Square square = new Square(45,"blue");
        Square square2 = (Square) square.clone();

        System.out.println(square);
        System.out.println(square2);
        System.out.println(square == square2);


        Circle circle = new Circle(45,"blue");
        Circle circle2 = (Circle) circle.clone();
        System.out.println(circle);
        System.out.println(circle2);
        System.out.println(circle == circle2);


    }
}
