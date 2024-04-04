package controller;


import model.FileModel;
import view.FileView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileController {
    private FileModel model;
    private FileView view;

    public FileController(FileModel model, FileView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView(String filePath) {
        model.buildTree(filePath);

        view.getTextArea().setText("");

        try (Stream<Path> fileStream = Files.walk(Paths.get(filePath))) {
            fileStream
                    .filter(path -> Files.isRegularFile(path) && Files.isReadable(path)) // Kiểm tra quyền truy cập
                    .forEach(file -> view.getTextArea().append(file.getFileName() + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
