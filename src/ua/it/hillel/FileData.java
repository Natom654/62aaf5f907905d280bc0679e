package ua.it.hillel;

public class FileData {
    private String fileway;
    private byte size;
    private String name;

    public FileData(String fileway, byte size, String name) {
        this.fileway = fileway;
        this.size = size;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte getSize() {
        return size;
    }

    public String getFileway() {
        return fileway;
    }

    @Override
    public String toString() {
        return "name =" + name +
                ", size= " + size +
                ", fileway = " + fileway + ";  ";
    }
}

