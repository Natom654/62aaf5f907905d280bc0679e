package ua.it.hillel;

import java.util.Map;
import java.util.TreeMap;

public class ApplicationFile {
    public static void main(String[] args) {
        FileNavigator fileMap = new FileNavigator();
        FileData filedata1 = new FileData("/path/to/file1", (byte) 16, "Text1");
        FileData filedata2 = new FileData("/path/to/file2", (byte) 32, "Text2");
        FileData filedata3 = new FileData("/path/to/file1", (byte) 64, "Jpeg1");
        FileData filedata4 = new FileData("/path/to/file4", (byte) 32, "Jpeg2");

        fileMap.add("/path/to/file1", filedata1);
        fileMap.add("/path/to/file2", filedata2);
        fileMap.add("/path/to/file1", filedata3);
        fileMap.add("/path/to/file4", filedata4);
        System.out.println(fileMap.toString());

        System.out.println(fileMap.find("/path/to(/file1"));

        System.out.println(fileMap.filterBySize((byte) 64));

        System.out.println(fileMap.remove("/path/to/file2"));

        System.out.println(fileMap.sortBySize());

    }
}

