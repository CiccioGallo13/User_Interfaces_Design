package com.unical.sium.reportvaccinazioni.model;

import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.Executor;

public class DataManager {
    private static DataManager instance = new DataManager();

    private BarChart<String, Integer> chart = null;

    protected Vector<String> mydata = new Vector<>();

    private DataManager(){
    }

    public static DataManager getInstance(){
        return instance;
    }

    public void setData(Vector<String> _data){
        mydata= _data;
        chart.getData().clear();
        XYChart.Series primaDose = new XYChart.Series();
        primaDose.setName("Prima dose");
        XYChart.Series secondaDose = new XYChart.Series();
        secondaDose.setName("Seconda dose");

        mydata.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(",")[0].compareTo(o2.split(",")[0]);
            }
        });

        for(int i = 0; i<mydata.size(); i++)
        {
            String[] tmp = mydata.get(i).split(",");
            primaDose.getData().add(new XYChart.Data(tmp[0], Integer.parseInt(tmp[5])));
            secondaDose.getData().add(new XYChart.Data(tmp[0], Integer.parseInt(tmp[6])));
        }

        chart.getData().addAll(primaDose, secondaDose);
    }

    public void setChart(BarChart<String, Integer> _chart){
        chart = _chart;
    }
}
