package org.example.l.solution;

public class Demo {
    public static void main(String[] args) {
        Bird[] birds = new Bird[]{new Crow(), new Ostrich(), new Sparrow()};
        for (Bird bird : birds) {
            bird.eat();
        }

        FlyingBird[] birdFlyings = new FlyingBird[]{new Crow(), new Sparrow()};
        for (FlyingBird bird : birdFlyings) {
            bird.fly();
        }


    }
}
