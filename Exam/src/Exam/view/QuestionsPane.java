package Exam.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionsPane extends JPanel {
    public QuestionsPane(){
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    public void AddQuestion(String q, List<String> ans){
        this.add(new Label(q));
        this.add(new Question( ans));
    }

}
