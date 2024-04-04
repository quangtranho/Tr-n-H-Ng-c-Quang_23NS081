package model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class FileModel {
    private DefaultMutableTreeNode root;

    public FileModel() {
        root = new DefaultMutableTreeNode("Ổ D:");
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public void buildTree(String path) {
        File rootDir = new File(path);
        buildTree(root, rootDir);
    }

    private void buildTree(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
            node.add(childNode);
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File f : fileList) {
                    buildTree(childNode, f);
                }
            }
        } else {
            node.add(new DefaultMutableTreeNode(file.getName()));
        }
    }
}
