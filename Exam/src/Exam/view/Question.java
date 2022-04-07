package Exam.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Question extends JPanel {

    public Question( List<String> ans){
        GridLayout layout = new GridLayout();
        this.setLayout(layout);
        for(int i=0; i<ans.size(); i++){
            this.add(new Checkbox(ans.get(i)));
        }

    }
}
