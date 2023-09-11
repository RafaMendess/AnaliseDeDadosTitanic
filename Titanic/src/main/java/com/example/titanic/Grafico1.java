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

public class Grafico1 implements Initializable {
    @FXML
    private BarChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    private Dados dados= new Dados();

    private int menorDeIdade;
    private int adulto;
    private int idoso;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calcularDados();

        XYChart.Series setMenorDeIdade= new XYChart.Series();
        XYChart.Series setAdulto= new XYChart.Series();
        XYChart.Series setIdoso= new XYChart.Series();

        setMenorDeIdade.getData().add(new XYChart.Data<>("Menor de 18 anos",menorDeIdade));
        setAdulto.getData().add(new XYChart.Data<>("De 18 a 65 anos",adulto));
        setIdoso.getData().add(new XYChart.Data<>("Mais de 65 anos",idoso));

        chart.getData().addAll(setMenorDeIdade,setAdulto,setIdoso);

    }

    public void calcularDados(){
        ArrayList<Passageiro> passageiros= dados.carregarDados();
        menorDeIdade=idoso=adulto=0;
        System.out.println("Size:"+passageiros.size());

        for(Passageiro passageiro:passageiros){
            if(!passageiro.isSurvived()) {
                if (passageiro.getAge() < 18)
                    menorDeIdade++;
                else if (passageiro.getAge() > 18 && passageiro.getAge() < 65)
                    adulto++;
                else idoso++;
            }
        }
        System.out.println("Menor:"+menorDeIdade+"\nAdulto"+adulto+"\nIdoso:"+idoso);

    }
}
