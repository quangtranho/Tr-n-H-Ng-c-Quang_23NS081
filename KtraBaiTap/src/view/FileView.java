package view;

import javax.swing.JTextArea;

public class FileView {
    private JTextArea textArea;

    public FileView() {
        textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
