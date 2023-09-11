package com.example.titanic;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dados {
    private ArrayList<Passageiro> passageiros;

    public ArrayList<Passageiro> carregarDados() {
        FileReader fileReader = null;
        CSVReader Csvreader = null;
        try {
            fileReader = new FileReader(new File("src/main/java/com/example/titanic/titanic.csv"));
            Csvreader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            String[] linha;
            passageiros = new ArrayList<>();
            while ((linha = Csvreader.readNext()) != null) {
                int survived = Integer.parseInt(linha[0]);
                String pClass = linha[1];
                String name = linha[2];
                String sex = linha[3];
                int age = (int) Math.round(Double.parseDouble(linha[4]));

                int siblingsOnBoard =(int) Math.round(Double.parseDouble(linha[5]));
                int childrenOnBoard = (int) Math.round(Double.parseDouble(linha[6]));
                double fare = Double.parseDouble(linha[7]);

                Passageiro passageiro = new Passageiro(survived, pClass, name, sex, age, siblingsOnBoard, childrenOnBoard, fare);
                passageiros.add(passageiro);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                Csvreader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        return passageiros;
    }
}
