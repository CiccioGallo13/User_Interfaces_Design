package Exam.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooser {
    public static File ShowChooser() {
        JFileChooser fchooser = new JFileChooser();
        fchooser.setFileFilter(new FileNameExtensionFilter("File di Testo","txt"));
        int res = fchooser.showOpenDialog(null);
        File exam = null;
        if (res == JFileChooser.APPROVE_OPTION) {
            exam = fchooser.getSelectedFile();
            System.out.println(exam.getAbsolutePath());
        }
        return exam;
    }
}
