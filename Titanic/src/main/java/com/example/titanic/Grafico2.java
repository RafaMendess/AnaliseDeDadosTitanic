package com.example.titanic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Grafico2 implements Initializable {
    @FXML
    private BarChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    private int quantManKilled;
    private int quantWomanKilled;

    private Dados dados= new Dados();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calcularDados();

        XYChart.Series setMale= new XYChart.Series();
        XYChart.Series setFemale= new XYChart.Series();

        setMale.getData().add(new XYChart.Data<>("Homens",quantManKilled));
        setFemale.getData().add(new XYChart.Data<>("Mulheres",quantWomanKilled));

        chart.getData().addAll(setFemale,setMale);
    }

    private void calcularDados(){
        ArrayList<Passageiro> passageiros= dados.carregarDados();
        System.out.println(passageiros.size());
        quantManKilled=0;
        quantWomanKilled=0;

        for(Passageiro passageiro:passageiros){
            if (passageiro.getSex().equalsIgnoreCase("male")&&!passageiro.isSurvived()){
                quantManKilled++;
            }
            else if(!passageiro.isSurvived()){
                quantWomanKilled++;
            }
        }
        System.out.println("male:"+quantManKilled+"\nfemale:"+quantWomanKilled);
    }
}
