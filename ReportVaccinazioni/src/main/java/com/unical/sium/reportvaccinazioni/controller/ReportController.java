package com.unical.sium.reportvaccinazioni.controller;

import com.unical.sium.reportvaccinazioni.model.DataManager;
import com.unical.sium.reportvaccinazioni.model.Downloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.xml.crypto.Data;

public class ReportController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private DatePicker endDate;

    @FXML
    private TextField region;

    @FXML
    private DatePicker startDate;

    @FXML
    void processData(ActionEvent event) {
        Downloader.getInstance().setDatas(startDate.getEditor().getText(), endDate.getEditor().getText(), region.getText());
        Downloader.getInstance().restart();
        Downloader.getInstance().setOnSucceeded(event1 -> {
            DataManager.getInstance().setData(Downloader.getInstance().getValue());
        });
    }

    @FXML
    void initialize(){
        barChart.setCategoryGap(20);
        DataManager.getInstance().setChart(barChart);
    }
}
