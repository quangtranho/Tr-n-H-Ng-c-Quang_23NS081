package main;

import javax.swing.*;

import controller.FileController;
import model.FileModel;
import view.FileView;

import java.awt.*;
import java.io.File;

public class FileMain {
    public static void main(String[] args) {
        FileModel model = new FileModel();
        FileView view = new FileView();
        FileController controller = new FileController(model, view);

        JFrame frame = new JFrame("Filewalker - JTree Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        JTextField filePathField = new JTextField("D:\\");
        JButton browseButton = new JButton("Choose Dir");
        browseButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("D:\\"));
            chooser.setDialogTitle("Choose Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                filePathField.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        JButton showButton = new JButton("Show Files");
        showButton.addActionListener(e -> {
            String filePath = filePathField.getText();
            controller.updateView(filePath);
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(filePathField);
        panel.add(browseButton);
        panel.add(showButton);

        JScrollPane tree = new JScrollPane(view.getTextArea());
        tree.setPreferredSize(new Dimension(200, 400));

        frame.add(panel, BorderLayout.NORTH);
        frame.add(tree, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
