package com.unical.sium.reportvaccinazioni.model;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;

public class Downloader extends Service<Vector<String>> {

    private static Downloader instance = new Downloader();

    private String start, end, region;
    public Downloader(){
    }

    public static Downloader getInstance(){
        return instance;
    }
    public void setDatas(String _start, String _end, String _region){
        String[] tmp = new String[3];
        tmp = _start.split("/");
        start = tmp[2]+"-"+tmp[1]+"-"+tmp[0];
        tmp = _end.split("/");
        end= tmp[2]+"-"+tmp[1]+"-"+tmp[0];
        region = _region;
    }

    @Override
    protected Task<Vector<String>> createTask() {
        return new Task<Vector<String>>() {
            @Override
            protected Vector<String> call() throws Exception {
                String data = "https://raw.githubusercontent.com/italia/covid19-opendata-vaccini/master/dati/somministrazioni-vaccini-summary-latest.csv";
                URL csvData = new URL(data);
                BufferedReader reader = new BufferedReader(new InputStreamReader(csvData.openStream()));
                Vector<String> lines = new Vector<>();
                reader.readLine();
                reader.lines().forEach(s -> {
                    String[] tmp = s.split(",");
                    if(tmp[0].compareTo(start) >= 0 && tmp[0].compareTo(end) <=0 && tmp[14].contains(region))
                        lines.add(s);
                });
                return lines;
            }
        };
    }
}
