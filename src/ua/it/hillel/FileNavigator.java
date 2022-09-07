package ua.it.hillel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileNavigator {

    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        this.fileMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return " fileMap = " + fileMap;
    }

    // task 2
    public void add(String fileway, FileData filedata) {
        if (fileMap.containsKey(fileway)) {
            this.fileMap.put(fileway, Stream.of(filedata).collect(Collectors.toList()));
        } else {
            this.fileMap.putIfAbsent(fileway, Stream.of(filedata).collect(Collectors.toList()));
        }
    }

    // task 3
    public List<FileData> find(String fileway) {
        return this.fileMap.get(fileway);
    }

    // task 4
    public List<FileData> filterBySize(byte maxSize) {
        return this.fileMap.values().stream()
                .flatMap(Collection::stream)
                .filter(e -> e.getSize() <= maxSize).toList();
    }

    // task 5
    public List<FileData> remove(String fileway) {
        return this.fileMap.remove(fileway);
    }

    // task 6
    public List<FileData> sortBySize() {
        return this.fileMap.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(FileData::getSize))
                .collect(Collectors.toList());
    }
}

