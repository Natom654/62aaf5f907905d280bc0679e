package ua.hillel.homework;

class UnfinedType extends RuntimeException {
    UnfinedType(String type) {
        super(type + "- type was not found ");
    }
}
