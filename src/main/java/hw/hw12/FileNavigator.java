package hw.hw12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileNavigator {
    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void add(FileData file) {
        String path = file.getPath();

        if (!fileMap.containsKey(path)) {
            fileMap.put(path, new ArrayList<>());
        }

        List<FileData> fileList = fileMap.get(path);
        fileList.add(file);
    }

    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            for (FileData file : fileList) {
                if (file.getSize() <= maxSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            allFiles.addAll(fileList);
        }

        allFiles.sort((file1, file2) -> Long.compare(file1.getSize(), file2.getSize()));

        return allFiles;
    }

    public void addConsistencyCheck(FileData file) {
        String path = file.getPath();

        if (!fileMap.containsKey(path)) {
            System.out.println("Error: Path does not exist in the file map.");
            return;
        }

        String key = fileMap.keySet().stream()
                .filter(path::startsWith)
                .findFirst()
                .orElse(null);

        if (key == null) {
            System.out.println("Error: Path does not match any existing keys.");
            return;
        }

        if (!key.equals(path)) {
            System.out.println("Error: Path does not match the key.");
            return;
        }

        add(file);
    }
}