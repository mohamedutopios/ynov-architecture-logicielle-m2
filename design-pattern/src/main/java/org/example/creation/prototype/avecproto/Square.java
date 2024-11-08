package org.example.creation.prototype.avecproto;

public class Square implements ShapePrototype {

    private int side;
    private String color;

    public Square(int side, String color) {
        this.side = side;
        this.color = color;
    }

    @Override
    public ShapePrototype clone() {
        return new Square(side, color);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                '}';
    }
}
