package com.assignment.test;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static String read(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        Path path = Paths.get(resource.getURI());
        List<String> content = Files.readAllLines(path);
        return listToString(content);
    }

    private static <T> String listToString(List<T> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (T t : list) {
            sb.append(t);
        }
        return sb.toString();
    }

}
