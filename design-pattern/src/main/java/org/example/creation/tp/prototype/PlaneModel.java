package org.example.creation.tp.prototype;

public class PlaneModel extends Model3D {
    public PlaneModel() {
        this.size = "Large";
        this.color = "Blue";
        this.texture = "Smooth";
    }

    @Override
    public Model3D clone() {
        PlaneModel copy = new PlaneModel();
        copy.setSize(this.size);
        copy.setColor(this.color);
        copy.setTexture(this.texture);
        return copy;
    }
}
