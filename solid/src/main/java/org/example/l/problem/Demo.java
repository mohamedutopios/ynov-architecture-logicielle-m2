package org.example.l.problem;

public class Demo {
    public static void main(String[] args) {
        Bird[] birds = new Bird[]{new Crow(), new Ostrich(), new Sparrow()};
        for (Bird bird : birds) {
            bird.fly();
        }


    }
}
