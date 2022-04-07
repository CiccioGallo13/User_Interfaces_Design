package com.company;

import Exam.view.FileChooser;
import Exam.view.Menu;
import Exam.view.QuestionsPane;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File myExam = FileChooser.ShowChooser();
        JFrame home = new JFrame();
        JMenuBar mymenu = new Menu();
        home.setJMenuBar(mymenu);

        ArrayList<String> answers = new ArrayList<String>();
        answers.add("a");
        answers.add("b");
        QuestionsPane qPane = new QuestionsPane();
        String quest=null;
        for(String line : Files.readAllLines(myExam.toPath()))
        {
            if(quest != null)
            {   qPane.AddQuestion(quest,List.of(line.split(";")));
                quest=null;
            }
            else
                quest=line;
        }

        home.add(qPane);
        home.add(new JScrollPane(qPane));
        home.setSize(700,500);
        home.setVisible(true);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
