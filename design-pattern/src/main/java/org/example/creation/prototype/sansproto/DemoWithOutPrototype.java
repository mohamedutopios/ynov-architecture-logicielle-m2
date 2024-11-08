package org.example.creation.prototype.sansproto;

public class DemoWithOutPrototype {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10,30, "red");

        Rectangle rectangle1 = new Rectangle(rectangle.getHeight(), rectangle.getWidth(), rectangle.getColor());

        Rectangle rectangle2 = rectangle;

        System.out.println(rectangle == rectangle1);
        System.out.println(rectangle == rectangle2);

    }
}
