package com.example.titanic;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Controller {
    @FXML
    private Label welcomeLabel;

    @FXML
    private Button helloButton;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML Stage stage;

    @FXML
    protected void onHelloButtonClick() {
        helloButton.setVisible(false);
        welcomeLabel.setText("Seja Bem-Vindo!\tEscolha um dos Gráficos para visualizar");
        Button grafico1Button= new Button("Gráfico 1");
        grafico1Button.setTranslateX(70);
        grafico1Button.setTranslateY(90);
        Button grafico2Button= new Button("Gráfico 2");
        grafico2Button.setTranslateX(200);
        grafico2Button.setTranslateY(90);

        grafico1Button.setOnAction(this::OnButtonClickHandler);
        grafico2Button.setOnAction(this::OnButtonClickHandler);
        anchorPane.getChildren().addAll(grafico1Button,grafico2Button);

    }
    private void OnButtonClickHandler(ActionEvent event){
        Button button= (Button)event.getSource();
            if(button==null)
                System.out.println("button is null");

        String text=button.getText();
        System.out.println("cheguei aqui  "+text);

        if (text.equalsIgnoreCase("Gráfico 1")){
            changeScene("grafico1.fxml", "Gráfico 1", (Stage) button.getScene().getWindow());
        }
        else if(text.equalsIgnoreCase("Gráfico 2")) {
            changeScene("grafico2.fxml", "Gráfico 2", (Stage) button.getScene().getWindow());
        }
        else{
            System.out.println("Erro");
        }
    }
    public void changeScene(String endereco, String titulo, Stage stageAnterior) {
        if (endereco == null)   return;

        try {
            root = FXMLLoader.load(getClass().getResource(endereco));
            scene = new Scene(root);
            stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
            stageAnterior.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}