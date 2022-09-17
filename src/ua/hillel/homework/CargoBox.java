package ua.hillel.homework;

public class CargoBox {
    String name;
    String quality;

    public CargoBox(String name, String quality) {
        this.name = name;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return name + ";  weight - " + quality + ";";
    }
}

