package org.example.i.problem;

public class Demo {

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle plane = new Plane();
        Vehicle boat = new Boat();
        car.drive();
        plane.fly();
        boat.sail();
    }
}
