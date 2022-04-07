package Exam.view;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu(){
        JMenu file = new JMenu("File");
        JMenuItem newExam = new JMenuItem("New Exam");
        JMenuItem loadExam = new JMenuItem("Load Exam");
        file.add(newExam);
        file.add(loadExam);
        JMenu exam = new JMenu("Exam");
        JMenuItem sugg = new JMenuItem("Suggestion");
        JMenuItem check = new JMenuItem("Check answers");
        exam.add(sugg);
        exam.add(check);
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        this.add(file);
        this.add(exam);
        this.add(help);
    }
}
